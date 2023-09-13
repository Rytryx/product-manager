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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categories")
public class CategoryController {

    @Autowired
    private CategoryServiceImpl categoryService;

    @GetMapping()
    @Operation(
            summary = "Holen Sie alle Kategorien",
            operationId = "getCategories",
            description = "Holen Sie eine Liste aller Kategorien."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Kategorien gefunden",
            content = @Content(schema = @Schema(implementation = CategoryShowDto.class))
    )
    public ResponseEntity<List<CategoryShowDto>> getCategories() {
        List<CategoryShowDto> categories = categoryService.getAll();
        if (!categories.isEmpty()) {
            return ResponseEntity.ok(categories);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping()
    @Operation(
            summary = "Erstellen Sie eine neue Kategorie",
            operationId = "createCategory",
            description = "Erstellen Sie eine neue Kategorie."
    )
    @ApiResponse(
            responseCode = "201",
            description = "Kategorie erstellt",
            content = @Content(schema = @Schema(implementation = CategoryShowDto.class))
    )
    @ApiResponse(
            responseCode = "400",
            description = "Ungültige Anforderung"
    )
    public ResponseEntity<CategoryShowDto> createCategory(@RequestBody CategoryCreateDto categoryCreateDto) {
        if (isValidCategoryCreateDto(categoryCreateDto)) {
            CategoryShowDto createdCategory = categoryService.create(categoryCreateDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdCategory);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    private boolean isValidCategoryCreateDto(CategoryCreateDto categoryCreateDto) {
        if (categoryCreateDto == null) {
            return false;
        }
        if (categoryCreateDto.getName() == null || categoryCreateDto.getName().isEmpty()) {
            return false;
        }
        return true; // Wenn alle Validierungen erfolgreich sind, gilt die Kategorie als gültig.
    }


    @GetMapping("/{id}")
    @Operation(
            summary = "Holen Sie eine Kategorie anhand ihrer ID",
            operationId = "getCategoryById",
            description = "Holen Sie eine Kategorie anhand ihrer ID."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Kategorie gefunden",
            content = @Content(schema = @Schema(implementation = CategoryDetailDto.class))
    )
    @ApiResponse(
            responseCode = "404",
            description = "Kategorie nicht gefunden"
    )
    public ResponseEntity<CategoryDetailDto> getCategoryById(
            @Parameter(description = "ID der Kategorie") @PathVariable Long id) {
        CategoryDetailDto category = categoryService.getById(id);
        if (category != null) {
            return ResponseEntity.ok(category);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Aktualisieren Sie eine Kategorie anhand ihrer ID",
            operationId = "updateCategoryById",
            description = "Aktualisieren Sie eine Kategorie anhand ihrer ID."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Kategorie aktualisiert",
            content = @Content(schema = @Schema(implementation = CategoryDetailDto.class))
    )
    @ApiResponse(
            responseCode = "404",
            description = "Kategorie nicht gefunden"
    )
    public ResponseEntity<CategoryDetailDto> updateCategoryById(
            @Parameter(description = "ID der Kategorie") @PathVariable Long id,
            @RequestBody CategoryUpdateDto categoryUpdateDto) {
        CategoryDetailDto updatedCategory = categoryService.update(id, categoryUpdateDto);
        if (updatedCategory != null) {
            return ResponseEntity.ok(updatedCategory);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Löschen Sie eine Kategorie anhand ihrer ID",
            operationId = "deleteCategoryById",
            description = "Löschen Sie eine Kategorie anhand ihrer ID."
    )
    @ApiResponse(
            responseCode = "204",
            description = "Kategorie gelöscht"
    )
    @ApiResponse(
            responseCode = "404",
            description = "Kategorie nicht gefunden"
    )
    public ResponseEntity<Void> deleteCategoryById(
            @Parameter(description = "ID der zu löschenden Kategorie") @PathVariable Long id) {
        categoryService.delete(id);
        if (!categoryService.categoryExistsById(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }
}
