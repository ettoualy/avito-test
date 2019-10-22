package ma.avito.usere.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ma.avito.usere.domain.dto.UserCreatedResponse;
import ma.avito.usere.domain.dto.UserDto;
import ma.avito.usere.domain.model.User;
import ma.avito.usere.service.UserService;

@RestController
@CrossOrigin(origins = "*")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUser(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(userService.findUserById(id));
    }

    @PostMapping("/users/{id}")
    public ResponseEntity<?> updateUser(@PathVariable("id") Integer id, @RequestBody UserDto user) {
        User savedUser = userService.updateUser(id, user);
        return ResponseEntity.ok(new UserCreatedResponse(savedUser.getId()));
    }

    @PostMapping("/users")
    public ResponseEntity<?> updateUser(@RequestBody UserDto user) {
        User savedUser = userService.saveUser(user);
        return ResponseEntity.ok(new UserCreatedResponse(savedUser.getId()));
    }
}
