package ch.csbe.backendlb.resources.category;

import ch.csbe.backendlb.resources.category.Dto.CategoryCreateDto;
import ch.csbe.backendlb.resources.category.Dto.CategoryDetailDto;
import ch.csbe.backendlb.resources.category.Dto.CategoryShowDto;
import ch.csbe.backendlb.resources.category.Dto.CategoryUpdateDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(
        componentModel = "spring"
)
public abstract class CategoryMapper {

    public abstract CategoryShowDto toShowDto(Category category);

    public abstract Category fromCreateDto(CategoryCreateDto categoryCreateDto);

    public abstract CategoryDetailDto toDetailDto(Category category);

    public abstract void updateFromCategoryUpdateDto(CategoryUpdateDto categoryUpdateDto, @MappingTarget Category category);
}
