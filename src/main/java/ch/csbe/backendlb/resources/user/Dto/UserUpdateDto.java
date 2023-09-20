package ch.csbe.backendlb.resources.user.Dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;
import io.swagger.v3.oas.annotations.media.Schema;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "DTO for updating user details") // Description for Swagger documentation
public class UserUpdateDto {
    @NotNull
    @Schema(description = "Unique identification number of the user")
    private Long id;

    @NotNull
    @Schema(description = "Username")
    private String username;

    @NotNull
    @Schema(description = "Password")
    private String password;

    @Schema(description = "Surname")
    private String surname;

    @Schema(description = "Lastname")
    private String lastname;

    @Schema(description = "E-Mail address")
    private String email;

    @Schema(description = "Birthday")
    private Date birthday;

    @Schema(description = "Street name")
    private String streetName;

    @Schema(description = "Street number")
    private String streetNr;

    @Schema(description = "Zip code")
    private String zipCode;

    @Schema(description = "City")
    private String city;
}
