/**
 * Interface for managing customer-related operations in a gym system.
 * This interface defines methods for adding customers, managing bookings, 
 * handling payments, and sending notifications.
 */
package com.flipkart.business;

/**
 * Interface for FlipFit gym customer operations.
 */
public interface FlipFitGymCustomerInterface {

    /**
     * Adds a new gym customer.
     * 
     * @param userId The ID of the user to be added as a gym customer.
     */
    public void addGymCustomer(int userId);

    /**
     * Sets the preferred city for a gym customer.
     * 
     * @param userId The ID of the customer.
     * @param city The preferred city to set for the customer.
     */
    public void setPreferredCity(int userId, String city);

    /**
     * Books a slot for a gym customer.
     * 
     * @param userId The ID of the customer.
     * @param slotId The ID of the slot to be booked.
     */
    public void bookSlot(int userId, int slotId);

    /**
     * Cancels a booking for a gym customer.
     * 
     * @param bookingId The ID of the booking to be canceled.
     * @return true if the booking was successfully canceled, false otherwise.
     */
    public boolean cancelBooking(int bookingId);

    /**
     * Lists all gym centers in a specified city.
     * 
     * @param city The city for which the gym centers need to be listed.
     */
    public void listAllCentersByCity(String city);

    /**
     * Views the available slots for a specified gym center.
     * 
     * @param gymCenterId The ID of the gym center.
     */
    public void viewAvailableSlots(int gymCenterId);

    /**
     * Views the slots booked by a gym customer.
     * 
     * @param userId The ID of the customer whose bookings are to be viewed.
     */
    public void viewBookedSlots(int userId);

    /**
     * Processes a payment for a gym customer.
     * 
     * @param customerId The ID of the customer making the payment.
     * @param amount The amount to be processed.
     */
    public void processPayment(int customerId, double amount);

    /**
     * Refunds a payment made by a gym customer.
     * 
     * @param paymentId The ID of the payment to be refunded.
     * @return true if the payment was successfully refunded, false otherwise.
     */
    public boolean refundPayment(int paymentId);

    /**
     * Gets the status of a payment.
     * 
     * @param paymentId The ID of the payment whose status is to be retrieved.
     * @return The status of the payment as a string.
     */
    public String getPaymentStatus(int paymentId);

    /**
     * Sends a notification to a gym customer.
     * 
     * @param customerId The ID of the customer to receive the notification.
     * @param notification The content of the notification.
     */
    public void sendNotification(int customerId, String notification);
}
