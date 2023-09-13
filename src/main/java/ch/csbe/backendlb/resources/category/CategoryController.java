package ch.csbe.backendlb.resources.category;

import ch.csbe.backendlb.resources.category.Dto.CategoryCreateDto;
import ch.csbe.backendlb.resources.category.Dto.CategoryDetailDto;
import ch.csbe.backendlb.resources.category.Dto.CategoryShowDto;
import ch.csbe.backendlb.resources.category.Dto.CategoryUpdateDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categories")
public class CategoryController {

    @Autowired
    private CategoryServiceImpl categoryService;

    @GetMapping()
    @Operation(summary = "Holen Sie alle Kategorien", operationId = "getCategories", description = "Holen Sie eine Liste aller Kategorien.")
    public List<CategoryShowDto> getCategories() {
        return categoryService.getAll();
    }

    @PostMapping()
    @Operation(summary = "Erstellen Sie eine neue Kategorie", operationId = "createCategory", description = "Erstellen Sie eine neue Kategorie.")
    @ApiResponse(responseCode = "201", description = "Kategorie erstellt",
            content = @Content(schema = @Schema(implementation = CategoryShowDto.class)))
    public CategoryShowDto createCategory(@RequestBody CategoryCreateDto categoryCreateDto) {
        return categoryService.create(categoryCreateDto);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Holen Sie eine Kategorie anhand ihrer ID", operationId = "getCategoryById", description = "Holen Sie eine Kategorie anhand ihrer ID.")
    public CategoryDetailDto getCategoryById(@Parameter(description = "ID der Kategorie") @PathVariable Long id) {
        return categoryService.getById(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Aktualisieren Sie eine Kategorie anhand ihrer ID", operationId = "updateCategoryById", description = "Aktualisieren Sie eine Kategorie anhand ihrer ID.")
    public CategoryDetailDto updateCategoryById(
            @Parameter(description = "ID der Kategorie") @PathVariable Long id,
            @RequestBody CategoryUpdateDto categoryUpdateDto) {
        return categoryService.update(id, categoryUpdateDto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Löschen Sie eine Kategorie anhand ihrer ID", operationId = "deleteCategoryById", description = "Löschen Sie eine Kategorie anhand ihrer ID.")
    @ApiResponse(responseCode = "204", description = "Kategorie gelöscht")
    public void deleteCategoryById(@Parameter(description = "ID der zu löschenden Kategorie") @PathVariable Long id) {
        categoryService.delete(id);
    }
}
