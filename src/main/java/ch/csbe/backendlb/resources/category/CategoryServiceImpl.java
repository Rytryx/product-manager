package ch.csbe.backendlb.resources.category;

import ch.csbe.backendlb.resources.category.Dto.CategoryCreateDto;
import ch.csbe.backendlb.resources.category.Dto.CategoryShowDto;
import ch.csbe.backendlb.resources.category.Dto.CategoryDetailDto;
import ch.csbe.backendlb.resources.category.Dto.CategoryUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;


    private final CategoryMapper categoryMapper;

    public CategoryServiceImpl(CategoryMapper categoryMapper) {
        this.categoryMapper = categoryMapper;
    }

    public List<CategoryShowDto> getAll() {
        List<Category> categories = this.categoryRepository.findAll();
        return categories.stream().map(categoryMapper::toShowDto).collect(Collectors.toList());
    }

    public CategoryShowDto create(CategoryCreateDto categoryCreateDto) {
        Category categoryToSave = categoryMapper.fromCreateDto(categoryCreateDto);
        Category savedCategory = this.categoryRepository.save(categoryToSave);
        return categoryMapper.toShowDto(savedCategory);
    }

    public CategoryDetailDto getById(Long id) {
        Category category = this.categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category with the id " + id + " could not be found!"));
        return categoryMapper.toDetailDto(category);
    }

    public CategoryDetailDto update(Long id, CategoryUpdateDto categoryUpdateDto) {
        Category category = this.categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category with the id " + id + " could not be found!"));
        categoryMapper.updateFromCategoryUpdateDto(categoryUpdateDto, category);
        Category updatedCategory = categoryRepository.save(category);
        return categoryMapper.toDetailDto(updatedCategory);
    }

    public void delete(Long id) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Category with the id " + id + " could not be found!");
        }
    }

    public boolean categoryExistsById(Long id) {
        return categoryRepository.existsById(id);
    }
}
