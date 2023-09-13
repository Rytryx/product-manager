package ch.csbe.backendlb.resources.category.Dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "DTO für das Erstellen einer Kategorie")
public class CategoryCreateDto {
    @Schema(description = "Einzigartige Identifikationsnummer der Kategorie")
    private Long id;

    @Schema(description = "Aktivitätsstatus der Kategorie")
    private int active;

    @Schema(description = "Name der Kategorie")
    private String name;
}
