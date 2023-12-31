package ch.csbe.backendlb.resources.user;

import ch.csbe.backendlb.resources.user.authentifikation.TokenService;
import ch.csbe.backendlb.resources.user.authentifikation.TokenWrapper;
import ch.csbe.backendlb.resources.user.Dto.LoginRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    private UserServiceImpl userService;
    @Autowired
    TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<TokenWrapper> login(@RequestBody LoginRequestDto loginRequestDto) {
        if (isValid(loginRequestDto)) {
            User user = this.userService.getUserWithCredentials(loginRequestDto);
            if (user != null) {
                TokenWrapper tokenWrapper = new TokenWrapper();
                String token = this.tokenService.generateToken(user);
                tokenWrapper.setToken(token);
                return ResponseEntity.ok(tokenWrapper); // 200 OK
            } else {
                // Error handling for unauthorized access (401)
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(); // 401 Unauthorized
            }
        } else {
            // Error handling for bad request (400)
            return ResponseEntity.badRequest().build(); // 400 Bad Request
        }
    }

    private boolean isValid(LoginRequestDto loginRequestDto) {
        // Implement the logic to validate the loginRequestDto
        // For example, check if required fields are not null/empty
        return loginRequestDto != null && loginRequestDto.getUsername() != null && !loginRequestDto.getUsername().isEmpty()
                && loginRequestDto.getPassword() != null && !loginRequestDto.getPassword().isEmpty();
    }

    @GetMapping()
    @Operation(
            summary = "Holen Sie alle Benutzer",
            operationId = "getUsers",
            description = "Holen Sie eine Liste aller Benutzer."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Benutzer gefunden",
            content = @Content(schema = @Schema(implementation = User.class))
    )
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = userService.getAll();
        if (!users.isEmpty()) {
            return ResponseEntity.ok(users);
        } else {
            return ResponseEntity.noContent().build();
        }
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
    @ApiResponse(
            responseCode = "400",
            description = "Ungültige Anforderung"
    )
    public ResponseEntity<User> createUser(@RequestBody User user) {
        if (isValidUser(user)) {
            User createdUser = userService.create(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    private boolean isValidUser(User user) {
        if (user == null) {
            return false;
        }

        if (user.getUsername() == null || user.getUsername().isEmpty()) {
            return false;
        }

        return user.getPassword() != null && !user.getPassword().isEmpty();
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Holen Sie einen Benutzer anhand seiner ID",
            operationId = "getUserById",
            description = "Holen Sie einen Benutzer anhand seiner ID."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Benutzer gefunden",
            content = @Content(schema = @Schema(implementation = User.class))
    )
    @ApiResponse(
            responseCode = "404",
            description = "Benutzer nicht gefunden"
    )
    public ResponseEntity<User> getUserById(
            @Parameter(description = "ID des Benutzers") @PathVariable("id") Long id) {
        User user = userService.getById(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Aktualisieren Sie einen Benutzer anhand seiner ID",
            operationId = "updateUserById",
            description = "Aktualisieren Sie einen Benutzer anhand seiner ID."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Benutzer aktualisiert",
            content = @Content(schema = @Schema(implementation = User.class))
    )
    @ApiResponse(
            responseCode = "404",
            description = "Benutzer nicht gefunden"
    )
    public ResponseEntity<User> updateUserById(
            @Parameter(description = "ID des Benutzers") @PathVariable("id") Long id,
            @RequestBody User user) {
        User updatedUser = userService.update(id, user);
        if (updatedUser != null) {
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.notFound().build();
        }
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
    @ApiResponse(
            responseCode = "404",
            description = "Benutzer nicht gefunden"
    )
    public ResponseEntity<Void> userById(
            @Parameter(description = "ID des zu löschenden User") @PathVariable Long id) {
        userService.delete(id);
        if (!userService.userExistsById(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

    @PostMapping("/register")
    @Operation(
            summary = "Registrieren Sie einen neuen Benutzer",
            operationId = "registerNewUser",
            description = "Hier kann sich ein Benutzer registrieren."
    )
    @ApiResponse(
            responseCode = "201",
            description = "Benutzer registriert",
            content = @Content(schema = @Schema(implementation = User.class))
    )
    @ApiResponse(
            responseCode = "400",
            description = "Ungültige Anforderung"
    )
    public ResponseEntity<User> registerNewUser(@RequestBody User user) {
        if (isValidUser(user)) {
            User createdUser = userService.create(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/assign-admin/{userId}")
    public ResponseEntity<String> assignAdmin(@PathVariable Long userId) {
        // Check if the currently logged-in user has administrator rights.
        // This can be verified using Spring Security permissions.

        User user = userService.getById(userId);
        if (user != null) {
            // Set the user's roleId to the Administrator role ID (assuming Administrator role ID is 1).
            user.setRoleId(1L); // Change 1L to the actual Administrator role ID in your system.
            userService.update(userId, user); // Update the user in the database

            return ResponseEntity.ok("User with ID " + userId + " has been promoted to Administrator.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
