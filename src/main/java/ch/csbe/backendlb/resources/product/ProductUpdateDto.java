package ch.csbe.backendlb.resources.product;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductUpdateDto {

    @NotNull
    private String name;

    private double price;

    public ProductUpdateDto() {
        // Standardkonstruktor
    }
}
