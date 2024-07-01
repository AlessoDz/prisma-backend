package pe.edu.utp.controller;

import org.springframework.http.ResponseEntity;
import pe.edu.utp.model.User;
import pe.edu.utp.service.RegistrationService;
import pe.edu.utp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RegistrationService registrationService;

    @PostMapping("/save")
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
    @GetMapping("/{id}/registration-status")
    public ResponseEntity<String> getRegistrationStatus(@PathVariable Long id) {
        String status = String.valueOf(registrationService.getRegistrationStatus(id));
        return ResponseEntity.ok(status);
    }
}
