package com.flipkart.dao;

import com.flipkart.bean.FlipFitGymCustomer;
import com.flipkart.bean.FlipFitNotification;
import com.flipkart.bean.FlipFitPayment;
import com.flipkart.bean.FlipFitSlotBooking;

/**
 * The FlipFitGymCustomerDao interface defines the data access operations related to gym customer tasks.
 * It includes methods for managing customer information, booking and canceling slots, processing payments, and sending notifications.
 */
public interface FlipFitGymCustomerDao {

    /**
     * Adds a new gym customer to the system.
     * 
     * @param customer The FlipFitGymCustomer object containing the details of the customer.
     */
    public void addGymCustomer(FlipFitGymCustomer customer);

    /**
     * Sets the preferred city for the gym customer.
     * 
     * @param userId The ID of the gym customer.
     * @param city The city to be set as the customer's preferred city.
     */
    public void setPreferredCity(int userId, String city);

    /**
     * Books a slot for the gym customer.
     * 
     * @param booking The FlipFitSlotBooking object containing the booking details.
     */
    public void bookSlot(FlipFitSlotBooking booking);

    /**
     * Cancels a slot booking for the customer based on the provided booking ID.
     * 
     * @param bookingId The ID of the booking to be canceled.
     * @return true if the booking was successfully canceled, false otherwise.
     */
    public boolean cancelBooking(int bookingId);

    /**
     * Lists all the gym centers available in the specified city.
     * 
     * @param city The city for which to list the gym centers.
     */
    public void listAllCentersByCity(String city);

    /**
     * Views the available slots for a specific gym center.
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
     * @param payment The FlipFitPayment object containing the payment details.
     */
    public void processPayment(FlipFitPayment payment);

    /**
     * Refunds a payment based on the provided payment ID.
     * 
     * @param paymentId The ID of the payment to be refunded.
     * @return true if the refund was successful, false otherwise.
     */
    public boolean refundPayment(int paymentId);

    /**
     * Retrieves the status of a payment based on the provided payment ID.
     * 
     * @param paymentId The ID of the payment whose status is to be retrieved.
     * @return The status of the payment (e.g., "Completed", "Pending", etc.).
     */
    public String getPaymentStatus(int paymentId);

    /**
     * Sends a notification to the gym customer.
     * 
     * @param notification The FlipFitNotification object containing the notification details.
     */
    public void sendNotification(FlipFitNotification notification);
}
