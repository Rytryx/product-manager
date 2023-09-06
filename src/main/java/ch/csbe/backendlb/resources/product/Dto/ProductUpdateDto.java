package ch.csbe.backendlb.resources.product.Dto;

import ch.csbe.backendlb.resources.category.Category;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductUpdateDto {
    @NotNull
    private Long id;
    private String sku;
    @NotNull
    private String name;
    private String image;
    private String description;
    @NotNull
    private Double price;
    private Integer stock;
    private Category category;

}
