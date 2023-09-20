package ch.csbe.backendlb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class for handling playground-related endpoints.
 */
@RestController
@RequestMapping("playground")
public class PlaygroundController {

    /**
     * Handles the GET request for a "Hello World" message.
     *
     * @return A "Hello Java Spring Boot" message.
     */
    @GetMapping("hello-world")
    public String helloWorld() {
        return "Hello Java Spring Boot";
    }
}
