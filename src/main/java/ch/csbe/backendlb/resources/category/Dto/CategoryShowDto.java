package ch.csbe.backendlb.resources.category.Dto;

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
@Schema(description = "DTO für die Anzeige einer Kategorie")
public class CategoryShowDto {
    @NotNull
    @Schema(description = "Einzigartige Identifikationsnummer der Kategorie")
    private Long id;

    @Schema(description = "Aktivitätsstatus der Kategorie")
    private int active;

    @NotNull
    @Schema(description = "Name der Kategorie")
    private String name;
}

