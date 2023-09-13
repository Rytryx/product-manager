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
@Schema(description = "DTO für das Aktualisieren eines Benutzers")
public class UserUpdateDto {
    @NotNull
    @Schema(description = "Einzigartige Identifikationsnummer des Benutzers")
    private Long id;

    @NotNull
    @Schema(description = "Benutzername")
    private String username;

    @NotNull
    @Schema(description = "Passwort")
    private String password;

    @Schema(description = "Nachname")
    private String surname;

    @Schema(description = "Vorname")
    private String lastname;

    @Schema(description = "E-Mail-Adresse")
    private String email;

    @Schema(description = "Geburtstag")
    private Date birthday;

    @Schema(description = "Straßenname")
    private String streetName;

    @Schema(description = "Hausnummer")
    private String streetNr;

    @Schema(description = "Postleitzahl")
    private String zipCode;

    @Schema(description = "Stadt")
    private String city;
}
