package ch.csbe.backendlb.resources.user.Dto;

import lombok.Data;

@Data
public class LoginRequestDto {
    private String username;
    private String password;
}

