package com.flipkart.exception;

/**
 * Thrown when the requested slot is unavailable 
 * (e.g., no seats left, or slot doesn't exist).
 */
public class SlotUnavailableException extends Exception {

    public SlotUnavailableException(String message) {
        super(message);
    }

    public SlotUnavailableException(String message, Throwable cause) {
        super(message, cause);
    }
}
