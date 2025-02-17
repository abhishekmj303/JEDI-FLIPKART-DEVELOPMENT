package com.flipkart.exception;

/**
 * Exception thrown when a gym owner is not registered in the system.
 */
public class GymOwnerNotRegisteredException extends Exception {
    
    /**
     * Constructor to create an exception with a custom error message.
     * 
     * @param message Error message describing the exception
     */
    public GymOwnerNotRegisteredException(String message) {
        super(message);
    }
}
