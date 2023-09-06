package ch.csbe.backendlb.resources.product;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductCreateDto {

    @NotNull
    private String name;

    @NotNull
    private double price;

    public ProductCreateDto(String name, double price) {
        this.name = name;
        this.price = price;
    }

}
