package ch.csbe.backendlb.resources.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

/**
 * Controller class for managing products.
 */
@RequestMapping("/products")
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * Get a list of all products.
     *
     * @return List of products.
     */
    @GetMapping()
    @Operation(
            summary = "Get all products",
            operationId = "getProducts",
            description = "Retrieve a list of all products."
    )
    public List<Product> getProducts() {
        return productService.getAll();
    }

    /**
     * Create a new product.
     *
     * @param product The product to create.
     * @return Created product.
     */
    @PostMapping()
    @Operation(
            summary = "Create a new product",
            operationId = "createProduct",
            description = "Create a new product."
    )
    @ApiResponse(
            responseCode = "201",
            description = "Product created",
            content = @Content(schema = @Schema(implementation = Product.class))
    )
    public Product createProduct(@RequestBody Product product) {
        return productService.create(product);
    }

    /**
     * Get a product by its ID.
     *
     * @param id ID of the product to retrieve.
     * @return Product with the specified ID.
     */
    @GetMapping("/{id}")
    @Operation(
            summary = "Get a product by ID",
            operationId = "getProductById",
            description = "Retrieve a product by its ID."
    )
    public Product getProductById(
            @Parameter(description = "ID of the product") @PathVariable("id") Long id) {
        return productService.getById(id);
    }

    /**
     * Update a product by its ID.
     *
     * @param id      ID of the product to update.
     * @param product Updated product data.
     * @return Updated product.
     */
    @PutMapping("/{id}")
    @Operation(
            summary = "Update a product by ID",
            operationId = "updateProductById",
            description = "Update a product by its ID."
    )
    public Product updateProductById(
            @Parameter(description = "ID of the product") @PathVariable("id") Long id,
            @RequestBody Product product) {
        return productService.update(id, product);
    }

    /**
     * Delete a product by its ID.
     *
     * @param id ID of the product to delete.
     */
    @DeleteMapping("/{id}")
    @Operation(
            summary = "Delete a product by ID",
            operationId = "deleteProductById",
            description = "Delete a product by its ID."
    )
    @ApiResponse(
            responseCode = "204",
            description = "Product deleted"
    )
    public void deleteProductById(
            @Parameter(description = "ID of the product to delete") @PathVariable("id") Long id) {
        productService.deleteById(id);


    }
}
