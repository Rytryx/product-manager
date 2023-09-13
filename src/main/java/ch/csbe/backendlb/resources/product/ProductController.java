package ch.csbe.backendlb.resources.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RequestMapping("/products")
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping()
    @Operation(
            summary = "Holen Sie alle Produkte",
            operationId = "getProducts",
            description = "Holen Sie eine Liste aller Produkte."
    )
    public List<Product> getProducts() {
        return productService.getAll();
    }

    @PostMapping()
    @Operation(
            summary = "Erstellen Sie ein neues Produkt",
            operationId = "createProduct",
            description = "Erstellen Sie ein neues Produkt."
    )
    @ApiResponse(
            responseCode = "201",
            description = "Produkt erstellt",
            content = @Content(schema = @Schema(implementation = Product.class))
    )
    public Product createProduct(@RequestBody Product product) {
        return productService.create(product);
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Holen Sie ein Produkt anhand seiner ID",
            operationId = "getProductById",
            description = "Holen Sie ein Produkt anhand seiner ID."
    )
    public Product getProductById(
            @Parameter(description = "ID des Produkts") @PathVariable("id") Long id) {
        return productService.getById(id);
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Aktualisieren Sie ein Produkt anhand seiner ID",
            operationId = "updateProductById",
            description = "Aktualisieren Sie ein Produkt anhand seiner ID."
    )
    public Product updateProductById(
            @Parameter(description = "ID des Produkts") @PathVariable("id") Long id,
            @RequestBody Product product) {
        return productService.update(id, product);
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Löschen Sie ein Produkt anhand seiner ID",
            operationId = "deleteProductById",
            description = "Löschen Sie ein Produkt anhand seiner ID."
    )
    @ApiResponse(
            responseCode = "204",
            description = "Produkt gelöscht"
    )
    public void deleteProductById(
            @Parameter(description = "ID des zu löschenden Produkts") @PathVariable("id") Long id) {
        productService.deleteById(id);
    }
}
