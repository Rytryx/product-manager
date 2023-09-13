package ch.csbe.backendlb.resources.product.Dto;

import ch.csbe.backendlb.resources.category.Category;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import io.swagger.v3.oas.annotations.media.Schema;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "DTO für das Erstellen eines Produkts")
public class ProductCreateDto {
    @NotNull
    @Schema(description = "Einzigartige Identifikationsnummer des Produkts")
    private Long id;

    @Schema(description = "Artikelnummer (SKU) des Produkts")
    private String sku;

    @NotNull
    @Schema(description = "Name des Produkts")
    private String name;

    @Schema(description = "URL des Produktbilds")
    private String image;

    @Schema(description = "Beschreibung des Produkts")
    private String description;

    @NotNull
    @Schema(description = "Preis des Produkts")
    private Double price;

    @Schema(description = "Lagerbestand des Produkts")
    private Integer stock;

    @Schema(description = "Kategorie des Produkts")
    private Category category;
}
