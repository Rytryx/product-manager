package ch.csbe.backendlb.resources.product;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ProductDetailDto {

    @NotNull
    private Long id;

    @NotNull
    private String name;

    private double price;

    public ProductDetailDto(Long id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
