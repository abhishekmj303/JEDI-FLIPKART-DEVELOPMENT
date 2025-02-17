/**
 * The FlipFitGymCustomerInterface defines the contract for operations that can be performed by gym customers in the FlipFit system.
 * It includes methods for managing customer data, bookings, payments, and notifications.
 */
package com.flipkart.business;

/**
 * Interface for gym customer operations, including adding a customer, managing city preferences, booking and canceling slots,
 * viewing available and booked slots, processing payments, and receiving notifications.
 */
public interface FlipFitGymCustomerInterface {
    
    /**
     * Adds a new gym customer based on the provided user ID.
     * 
     * @param userId The ID of the user to be added as a gym customer.
     */
    public void addGymCustomer(int userId);
    
    /**
     * Sets the preferred city for the gym customer.
     * 
     * @param userId The ID of the gym customer.
     * @param city The preferred city to be set for the customer.
     */
    public void setPreferredCity(int userId, String city);
    
    /**
     * Books a slot for the gym customer in the specified slot.
     * 
     * @param userId The ID of the gym customer.
     * @param slotId The ID of the slot to be booked.
     */
    public void bookSlot(int userId, int slotId);
    
    /**
     * Cancels a booking for a customer based on the provided booking ID.
     * 
     * @param bookingId The ID of the booking to be canceled.
     * @return true if the cancellation was successful, false otherwise.
     */
    public boolean cancelBooking(int bookingId);
    
    /**
     * Lists all gym centers available in the specified city.
     * 
     * @param city The city for which to list the gym centers.
     */
    public void listAllCentersByCity(String city);
    
    /**
     * Views available slots for a specific gym center.
     * 
     * @param gymCenterId The ID of the gym center.
     */
    public void viewAvailableSlots(int gymCenterId);
    
    /**
     * Views the slots that are already booked by the customer.
     * 
     * @param userId The ID of the gym customer.
     */
    public void viewBookedSlots(int userId);
    
    /**
     * Processes the payment for the gym customer.
     * 
     * @param customerId The ID of the customer making the payment.
     * @param amount The amount to be paid.
     */
    public void processPayment(int customerId, double amount);
    
    /**
     * Refunds a payment based on the provided payment ID.
     * 
     * @param paymentId The ID of the payment to be refunded.
     * @return true if the refund was successful, false otherwise.
     */
    public boolean refundPayment(int paymentId);
    
    /**
     * Gets the status of a payment based on the provided payment ID.
     * 
     * @param paymentId The ID of the payment whose status is to be retrieved.
     * @return The status of the payment (e.g., "Completed", "Pending", etc.).
     */
    public String getPaymentStatus(int paymentId);
    
    /**
     * Sends a notification to the specified customer.
     * 
     * @param customerId The ID of the customer to whom the notification is to be sent.
     * @param notification The notification message to be sent.
     */
    public void sendNotification(int customerId, String notification);
}
