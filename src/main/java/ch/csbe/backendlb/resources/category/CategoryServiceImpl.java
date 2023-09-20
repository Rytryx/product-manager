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

/**
 * Implementation of the CategoryService interface for managing Category entities.
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    private final CategoryMapper categoryMapper;

    @Autowired
    public CategoryServiceImpl(CategoryMapper categoryMapper) {
        this.categoryMapper = categoryMapper;
    }

    /**
     * Get a list of all categories.
     *
     * @return A list of CategoryShowDto representing all categories.
     */
    public List<CategoryShowDto> getAll() {
        List<Category> categories = this.categoryRepository.findAll();
        return categories.stream().map(categoryMapper::toShowDto).collect(Collectors.toList());
    }

    /**
     * Create a new category.
     *
     * @param categoryCreateDto The CategoryCreateDto containing category data.
     * @return The created CategoryShowDto.
     */
    public CategoryShowDto create(CategoryCreateDto categoryCreateDto) {
        Category categoryToSave = categoryMapper.fromCreateDto(categoryCreateDto);
        Category savedCategory = this.categoryRepository.save(categoryToSave);
        return categoryMapper.toShowDto(savedCategory);
    }

    /**
     * Get a category by its ID.
     *
     * @param id The ID of the category to retrieve.
     * @return The CategoryDetailDto with detailed category information.
     * @throws ResourceNotFoundException if the category with the specified ID is not found.
     */
    public CategoryDetailDto getById(Long id) {
        Category category = this.categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category with the id " + id + " could not be found!"));
        return categoryMapper.toDetailDto(category);
    }

    /**
     * Update an existing category by its ID.
     *
     * @param id                 The ID of the category to update.
     * @param categoryUpdateDto The CategoryUpdateDto containing updated category data.
     * @return The updated CategoryDetailDto.
     * @throws ResourceNotFoundException if the category with the specified ID is not found.
     */
    public CategoryDetailDto update(Long id, CategoryUpdateDto categoryUpdateDto) {
        Category category = this.categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category with the id " + id + " could not be found!"));
        categoryMapper.updateFromCategoryUpdateDto(categoryUpdateDto, category);
        Category updatedCategory = categoryRepository.save(category);
        return categoryMapper.toDetailDto(updatedCategory);
    }

    /**
     * Delete a category by its ID.
     *
     * @param id The ID of the category to delete.
     * @throws ResourceNotFoundException if the category with the specified ID is not found.
     */
    public void delete(Long id) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Category with the id " + id + " could not be found!");
        }
    }

    /**
     * Check if a category with the specified ID exists.
     *
     * @param id The ID of the category to check.
     * @return true if a category with the specified ID exists; otherwise, false.
     */
    public boolean categoryExistsById(Long id) {
        return categoryRepository.existsById(id);
    }
}
