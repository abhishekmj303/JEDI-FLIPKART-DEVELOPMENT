package com.flipkart.exception;

/**
 * Thrown when a payment operation fails for any reason 
 * (e.g., insufficient balance, network issue, etc.).
 */
public class PaymentFailedException extends Exception {

    public PaymentFailedException(String message) {
        super(message);
    }

    public PaymentFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
