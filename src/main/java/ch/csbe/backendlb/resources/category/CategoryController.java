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

/**
 * Controller class for handling category-related endpoints.
 */
@RestController
@RequestMapping("categories")
public class CategoryController {

    @Autowired
    private CategoryServiceImpl categoryService;

    /**
     * Handles the GET request to retrieve all categories.
     *
     * @return List of CategoryShowDto.
     */
    @GetMapping()
    @Operation(
            summary = "Retrieve all categories",
            operationId = "getCategories",
            description = "Retrieve a list of all categories."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Categories found",
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
}
