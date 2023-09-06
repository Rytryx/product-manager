package ch.csbe.backendlb.resources.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/users")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public List<User> getUsers() {
        return userService.getAll();
    }

    @PostMapping()
    public User createUser(@RequestBody User user) {
        return userService.create(user);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Long id) {
        return userService.getById(id);
    }

    @PutMapping("/{id}")
    public User updateUserById(@PathVariable("id") Long id, @RequestBody User user) {
        return userService.update(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable("id") Long id) {
        userService.delete(id);
    }
    @PostMapping("/user/register")
    public String registerNewUser(){
        return "Hier kann sich ein Benutzer Registrieren";
    }
    @PutMapping("/users/assign-admin/{userId}")
    public String assignAdmin(@PathVariable String userId){
        return "Hier kann der ein Adminisistrator Admin rechte verteilen" + userId;
    }
}
