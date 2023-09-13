package ch.csbe.backendlb.resources.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RequestMapping("/users")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping()
    @Operation(
            summary = "Holen Sie alle Benutzer",
            operationId = "getUsers",
            description = "Holen Sie eine Liste aller Benutzer."
    )
    public List<User> getUsers() {
        return userService.getAll();
    }

    @PostMapping()
    @Operation(
            summary = "Erstellen Sie einen neuen Benutzer",
            operationId = "createUser",
            description = "Erstellen Sie einen neuen Benutzer."
    )
    @ApiResponse(
            responseCode = "201",
            description = "Benutzer erstellt",
            content = @Content(schema = @Schema(implementation = User.class))
    )
    public User createUser(@RequestBody User user) {
        return userService.create(user);
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Holen Sie einen Benutzer anhand seiner ID",
            operationId = "getUserById",
            description = "Holen Sie einen Benutzer anhand seiner ID."
    )
    public User getUserById(
            @Parameter(description = "ID des Benutzers") @PathVariable("id") Long id) {
        return userService.getById(id);
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Aktualisieren Sie einen Benutzer anhand seiner ID",
            operationId = "updateUserById",
            description = "Aktualisieren Sie einen Benutzer anhand seiner ID."
    )
    public User updateUserById(
            @Parameter(description = "ID des Benutzers") @PathVariable("id") Long id,
            @RequestBody User user) {
        return userService.update(id, user);
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Löschen Sie einen Benutzer anhand seiner ID",
            operationId = "deleteUserById",
            description = "Löschen Sie einen Benutzer anhand seiner ID."
    )
    @ApiResponse(
            responseCode = "204",
            description = "Benutzer gelöscht"
    )
    public void deleteUserById(
            @Parameter(description = "ID des zu löschenden Benutzers") @PathVariable("id") Long id) {
        userService.delete(id);
    }

    @PostMapping("/user/register")
    @Operation(
            summary = "Registrieren Sie einen neuen Benutzer",
            operationId = "registerNewUser",
            description = "Hier kann sich ein Benutzer registrieren."
    )
    public String registerNewUser() {
        return "Hier kann sich ein Benutzer registrieren";
    }

    @PutMapping("/users/assign-admin/{userId}")
    @Operation(
            summary = "Weisen Sie einem Benutzer Administratorrechte zu",
            operationId = "assignAdmin",
            description = "Hier kann ein Administrator Administratorrechte einem Benutzer zuweisen."
    )
    public String assignAdmin(
            @Parameter(description = "ID des Benutzers") @PathVariable String userId) {
        return "Hier kann ein Administrator Administratorrechte einem Benutzer zuweisen: " + userId;
    }
}
