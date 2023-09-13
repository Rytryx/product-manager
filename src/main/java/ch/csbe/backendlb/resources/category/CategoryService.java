package ch.csbe.backendlb.resources.category;

import ch.csbe.backendlb.resources.category.Dto.CategoryCreateDto;
import ch.csbe.backendlb.resources.category.Dto.CategoryDetailDto;
import ch.csbe.backendlb.resources.category.Dto.CategoryShowDto;
import ch.csbe.backendlb.resources.category.Dto.CategoryUpdateDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    CategoryShowDto create(CategoryCreateDto category);
    CategoryDetailDto getById(Long id);
    List<CategoryShowDto> getAll();
    CategoryDetailDto update(Long id, CategoryUpdateDto categoryUpdateDto);
    void delete(Long id);
}

