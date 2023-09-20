package ch.csbe.backendlb.resources.category;

import ch.csbe.backendlb.resources.category.Dto.CategoryCreateDto;
import ch.csbe.backendlb.resources.category.Dto.CategoryDetailDto;
import ch.csbe.backendlb.resources.category.Dto.CategoryShowDto;
import ch.csbe.backendlb.resources.category.Dto.CategoryUpdateDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service interface for managing Category entities.
 */
public interface CategoryService {

    /**
     * Create a new category.
     *
     * @param category The CategoryCreateDto containing category data.
     * @return The created CategoryShowDto.
     */
    CategoryShowDto create(CategoryCreateDto category);

    /**
     * Get a category by its ID.
     *
     * @param id The ID of the category to retrieve.
     * @return The CategoryDetailDto with detailed category information.
     */
    CategoryDetailDto getById(Long id);

    /**
     * Get a list of all categories.
     *
     * @return A list of CategoryShowDto representing all categories.
     */
    List<CategoryShowDto> getAll();

    /**
     * Update an existing category by its ID.
     *
     * @param id                 The ID of the category to update.
     * @param categoryUpdateDto The CategoryUpdateDto containing updated category data.
     * @return The updated CategoryDetailDto.
     */
    CategoryDetailDto update(Long id, CategoryUpdateDto categoryUpdateDto);

    /**
     * Delete a category by its ID.
     *
     * @param id The ID of the category to delete.
     */
    void delete(Long id);
}
