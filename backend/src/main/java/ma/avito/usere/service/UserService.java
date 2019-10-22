package ma.avito.usere.service;

import ma.avito.usere.domain.dto.UserDto;
import ma.avito.usere.domain.model.User;
import ma.avito.usere.exceptions.UserNotFoundException;
import ma.avito.usere.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findUserById(Integer id) {
        Optional<User> maybeUser = userRepository.findById(id);
        if(!maybeUser.isPresent()) {
            throw new UserNotFoundException(id);
        }
        return maybeUser.get();
    }

    @Transactional
    public User updateUser(Integer userId, UserDto updatedUserView) {
        User user = findUserById(userId);
        user.setAvatar(updatedUserView.getAvatar());
        user.setName(updatedUserView.getName());
        user.setEmail(updatedUserView.getEmail());
        return userRepository.save(user);
    }

    @Transactional
    public User saveUser(UserDto userView) {
        User user = new User(
                userView.getName(),
                userView.getEmail(),
                userView.getAvatar()
        );
        return userRepository.save(user);
    }
}
