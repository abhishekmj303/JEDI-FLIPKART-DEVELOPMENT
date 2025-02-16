package com.flipkart.exception;

/**
 * Thrown when a user attempts to log in with invalid credentials
 * (e.g., wrong username or password).
 */
public class InvalidCredentialsException extends Exception {

    public InvalidCredentialsException(String message) {
        super(message);
    }

    public InvalidCredentialsException(String message, Throwable cause) {
        super(message, cause);
    }
}
