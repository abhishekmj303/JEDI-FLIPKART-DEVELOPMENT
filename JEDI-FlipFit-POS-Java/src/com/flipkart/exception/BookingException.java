package com.flipkart.exception;

/**
 * Thrown when there is a generic booking-related issue 
 * (e.g., invalid booking ID, booking constraints, etc.).
 */
public class BookingException extends Exception {
    
    public BookingException(String message) {
        super(message);
    }

    public BookingException(String message, Throwable cause) {
        super(message, cause);
    }
}
