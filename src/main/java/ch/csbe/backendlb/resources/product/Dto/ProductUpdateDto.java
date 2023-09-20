package ch.csbe.backendlb.resources.product.Dto;

import ch.csbe.backendlb.resources.category.Category;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Data Transfer Object (DTO) for updating a Product.
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "DTO for updating a product")
public class ProductUpdateDto {

    @NotNull
    @Schema(description = "Unique identification number of the product")
    private Long id;

    @Schema(description = "Article number (SKU) of the product")
    private String sku;

    @NotNull
    @Schema(description = "New name of the product")
    private String name;

    @Schema(description = "URL of the new product image")
    private String image;

    @Schema(description = "New description of the product")
    private String description;

    @NotNull
    @Schema(description = "New price of the product")
    private Double price;

    @Schema(description = "New stock quantity of the product")
    private Integer stock;

    @Schema(description = "New category of the product")
    private Category category;
}
