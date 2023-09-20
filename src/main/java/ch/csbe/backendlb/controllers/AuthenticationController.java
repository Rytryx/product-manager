package ch.csbe.backendlb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class for handling authentication-related endpoints.
 */
@RequestMapping("authentication")
@RestController
public class AuthenticationController {

    /**
     * Handles the GET request for user login.
     *
     * @return A string message indicating that a user can log in.
     */
    @GetMapping("/auth/login")
    public String userLogin() {
        return "A user can log in";
    }
}
