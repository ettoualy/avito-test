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
public class PingController {
    
    @GetMapping("/ping")
    public ResponseEntity<?> updateUser() {
        return ResponseEntity.ok().build();
    }
}
