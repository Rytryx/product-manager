package ch.csbe.backendlb.resources.category;

import ch.csbe.backendlb.resources.category.Dto.CategoryCreateDto;
import ch.csbe.backendlb.resources.category.Dto.CategoryShowDto;
import ch.csbe.backendlb.resources.category.Dto.CategoryDetailDto;
import ch.csbe.backendlb.resources.category.Dto.CategoryUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public List<CategoryShowDto> getAll() {
        List<Category> categories = this.categoryRepository.findAll();
        return categories.stream().map(Category::toCategoryShowDto).collect(Collectors.toList());
    }

    public CategoryShowDto create(CategoryCreateDto categoryCreateDto) {
        Category categoryToSave = Category.fromCategoryCreateDto(categoryCreateDto);
        Category savedCategory = this.categoryRepository.save(categoryToSave);
        return savedCategory.toCategoryShowDto();
    }

    public CategoryDetailDto getById(Long id) {
        Category category = this.categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category with the id " + id + " could not be found!"));
        return category.toCategoryDetailDto();
    }

    public CategoryShowDto update(Long id, CategoryUpdateDto categoryUpdateDto) {
        Category category = this.categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category with the id " + id + " could not be found!"));
        category.updateFromCategoryUpdateDto(categoryUpdateDto);
        Category updatedCategory = categoryRepository.save(category);
        return updatedCategory.toCategoryShowDto();
    }

    public void delete(Long id) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Category with the id " + id + " could not be found!");
        }
    }
}
