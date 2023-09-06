package ch.csbe.backendlb.resources.user.Dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateDto {
    @NotNull
    private Long id;
    @NotNull
    private String username;
    @NotNull
    private String password;
    private String surname;
    private String lastname;
    private String email;
    private Date birthday;
    private String streetName;
    private String streetNr;
    private String zipCode;
    private String city;
}

