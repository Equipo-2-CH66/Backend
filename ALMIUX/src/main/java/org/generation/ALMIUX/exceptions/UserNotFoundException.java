package org.generation.ALMIUX.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super("Not found user with username: " );
    }
    public UserNotFoundException(Long id) {
        super("Not found user with id: " + id);
    }
}
