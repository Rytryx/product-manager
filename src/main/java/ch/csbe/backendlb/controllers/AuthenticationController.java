package ch.csbe.backendlb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("authentication")
@RestController()
public class AuthenticationController {
    @GetMapping("/auth/login")
    public String userLogin(){
        return "kann sich der Benutzer einloggen";
    }
}
