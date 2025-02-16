package com.flipkart.exception;

/**
 * Thrown when the specified gym center cannot be found 
 * in the system or database.
 */
public class GymCenterNotFoundException extends Exception {
    
    public GymCenterNotFoundException(String message) {
        super(message);
    }

    public GymCenterNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
