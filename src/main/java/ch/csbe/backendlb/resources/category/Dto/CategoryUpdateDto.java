package ch.csbe.backendlb.resources.category.Dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Data Transfer Object (DTO) for updating a category.
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "DTO for updating a category")
public class CategoryUpdateDto {

    @NotNull
    @Schema(description = "Unique identification number of the category")
    private Long id;

    @Schema(description = "Activity status of the category")
    private int active;

    @NotNull
    @Schema(description = "New name of the category")
    private String name;
}
