package com.flipkart.dao;

import com.flipkart.bean.FlipFitGymCustomer;
import com.flipkart.bean.FlipFitNotification;
import com.flipkart.bean.FlipFitPayment;
import com.flipkart.bean.FlipFitSlotBooking;

/**
 * Interface for managing gym customer data operations.
 * This interface defines methods for adding customers, managing bookings, 
 * handling payments, and sending notifications.
 */
public interface FlipFitGymCustomerDao {

    /**
     * Adds a new gym customer to the system.
     * 
     * @param customer The customer to be added.
     */
    public void addGymCustomer(FlipFitGymCustomer customer) throws UserNotFoundException;

    /**
     * Sets the preferred city for a gym customer.
     * 
     * @param userId The ID of the customer.
     * @param city The preferred city to be set.
     */
    public void setPreferredCity(int userId, String city) throws CustomerNotRegisteredException;

    /**
     * Books a slot for a gym customer.
     * 
     * @param booking The booking details.
     */
    public void bookSlot(FlipFitSlotBooking booking) throws GymCenterNotFoundException;

    /**
     * Cancels a booking made by a gym customer.
     * 
     * @param bookingId The ID of the booking to be canceled.
     * @return true if the booking was successfully canceled, false otherwise.
     */
    public boolean cancelBooking(int bookingId) throws BookingException ;

    /**
     * Lists all gym centers in a specified city.
     * 
     * @param city The city for which the gym centers are to be listed.
     */
    public void listAllCentersByCity(String city);

    /**
     * Views the available slots for a specified gym center.
     * 
     * @param gymCenterId The ID of the gym center for which the available slots are to be viewed.
     */
    public void viewAvailableSlots(int gymCenterId) throws GymCenterNotFoundException ;

    /**
     * Views the slots booked by a gym customer.
     * 
     * @param userId The ID of the customer whose bookings are to be viewed.
     */
    public void viewBookedSlots(int userId) throws CustomerNotRegisteredException;

    /**
     * Processes a payment for a gym customer.
     * 
     * @param payment The payment details.
     */
    public void processPayment(FlipFitPayment payment) throws PaymentFailedException;

    /**
     * Refunds a payment made by a gym customer.
     * 
     * @param paymentId The ID of the payment to be refunded.
     * @return true if the payment was successfully refunded, false otherwise.
     */
    public boolean refundPayment(int paymentId) throws PaymentFailedException;

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
     * @param notification The notification details to be sent.
     */
    public void sendNotification(FlipFitNotification notification);
}
