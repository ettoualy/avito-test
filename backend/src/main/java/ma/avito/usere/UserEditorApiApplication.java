package ma.avito.usere;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import ma.avito.usere.domain.dto.UserDto;
import ma.avito.usere.service.UserService;

@SpringBootApplication
public class UserEditorApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserEditorApiApplication.class, args);
    }

    @Component
    class DatabaseSeeder implements CommandLineRunner { 

        private final UserService userService;

        public DatabaseSeeder(UserService userService) {
            this.userService = userService;
        }

        public void run(String ...args) {
            System.out.println("running cmd runner");
            UserDto user = new UserDto("foo", "bar", "https://image.flaticon.com/icons/svg/147/147144.svg");
            userService.saveUser(user);
        }
    }
}
