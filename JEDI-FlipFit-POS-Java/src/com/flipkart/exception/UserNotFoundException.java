package com.flipkart.exception;

/**
 * Thrown when the specified user cannot be found in the system 
 * (e.g., during login, booking, or profile access).
 */
public class UserNotFoundException extends Exception {

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
