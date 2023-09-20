package ch.csbe.backendlb.resources.product.Dto;

import ch.csbe.backendlb.resources.category.Category;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Data Transfer Object (DTO) for displaying a Product.
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "DTO for displaying a product")
public class ProductShowDto {

    @NotNull
    @Schema(description = "Unique identification number of the product")
    private Long id;

    @Schema(description = "Article number (SKU) of the product")
    private String sku;

    @NotNull
    @Schema(description = "Name of the product")
    private String name;

    @Schema(description = "URL of the product image")
    private String image;

    @Schema(description = "Description of the product")
    private String description;

    @NotNull
    @Schema(description = "Price of the product")
    private Double price;

    @Schema(description = "Stock quantity of the product")
    private Integer stock;

    @Schema(description = "Category of the product")
    private Category category;
}
