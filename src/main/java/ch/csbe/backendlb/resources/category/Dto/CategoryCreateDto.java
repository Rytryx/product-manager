package ch.csbe.backendlb.resources.category.Dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Data Transfer Object (DTO) for creating a category.
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "DTO for creating a category")
public class CategoryCreateDto {

    @Schema(description = "Unique identification number of the category")
    private Long id;

    @Schema(description = "Activity status of the category")
    private int active;

    @Schema(description = "Name of the category")
    private String name;
}
