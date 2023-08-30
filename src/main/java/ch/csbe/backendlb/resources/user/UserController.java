package ch.csbe.backendlb.resources.user;

import org.springframework.web.bind.annotation.*;

@RequestMapping("user")
@RestController()
public class UserController {
    @GetMapping("/{Id}")
    public String searchUserById(@PathVariable String Id){
        return "Hier kann ein Benutzer mit seiner ID gesucht werden";
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
