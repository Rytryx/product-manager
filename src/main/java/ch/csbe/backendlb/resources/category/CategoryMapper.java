package ch.csbe.backendlb.resources.category;

import ch.csbe.backendlb.resources.category.Dto.CategoryCreateDto;
import ch.csbe.backendlb.resources.category.Dto.CategoryDetailDto;
import ch.csbe.backendlb.resources.category.Dto.CategoryShowDto;
import ch.csbe.backendlb.resources.category.Dto.CategoryUpdateDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

/**
 * Mapper interface for converting between Category entities and DTOs.
 */
@Mapper(
        componentModel = "spring"
)
public abstract class CategoryMapper {

    /**
     * Converts a Category entity to a CategoryShowDto.
     *
     * @param category The Category entity.
     * @return The CategoryShowDto.
     */
    public abstract CategoryShowDto toShowDto(Category category);

    /**
     * Converts a CategoryCreateDto to a Category entity.
     *
     * @param categoryCreateDto The CategoryCreateDto.
     * @return The Category entity.
     */
    public abstract Category fromCreateDto(CategoryCreateDto categoryCreateDto);

    /**
     * Converts a Category entity to a CategoryDetailDto.
     *
     * @param category The Category entity.
     * @return The CategoryDetailDto.
     */
    public abstract CategoryDetailDto toDetailDto(Category category);

    /**
     * Updates a Category entity using data from a CategoryUpdateDto.
     *
     * @param categoryUpdateDto The CategoryUpdateDto.
     * @param category          The Category entity to update.
     */
    public abstract void updateFromCategoryUpdateDto(CategoryUpdateDto categoryUpdateDto, @MappingTarget Category category);
}
