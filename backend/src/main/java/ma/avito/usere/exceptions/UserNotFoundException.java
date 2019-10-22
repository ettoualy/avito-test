package ma.avito.usere.exceptions;

/**
 * Thrown when a user is not found by a given identifier
 */
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Integer id) {
        super("Could not find user with the given identifier:" + id);
    }
}
