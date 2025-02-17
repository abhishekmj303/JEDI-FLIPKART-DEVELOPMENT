ackage com.flipkart.exception;

// Exception for when a customer is not registered
public class CustomerNotRegisteredException extends Exception {
    public CustomerNotRegisteredException(String message) {
        super(message);
    }

    public CustomerNotRegisteredException(String message, Throwable cause) {
        super(message, cause);
    }
}
