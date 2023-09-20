package ch.csbe.backendlb.resources.category.Dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Data Transfer Object (DTO) for displaying the details of a category.
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "DTO for displaying the details of a category")
public class CategoryShowDto {

    @NotNull
    @Schema(description = "Unique identification number of the category")
    private Long id;

    @Schema(description = "Activity status of the category")
    private int active;

    @NotNull
    @Schema(description = "Name of the category")
    private String name;
}
