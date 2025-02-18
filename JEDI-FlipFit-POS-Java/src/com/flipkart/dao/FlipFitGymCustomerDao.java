package com.flipkart.dao;

import java.util.List;

import com.flipkart.bean.FlipFitGymCenter;
import com.flipkart.bean.FlipFitGymCustomer;
import com.flipkart.bean.FlipFitNotification;
import com.flipkart.bean.FlipFitPayment;
import com.flipkart.bean.FlipFitSlot;
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
    public void addGymCustomer(FlipFitGymCustomer customer);

    /**
     * Sets the preferred city for a gym customer.
     * 
     * @param userId The ID of the customer.
     * @param city The preferred city to be set.
     */
    public void setPreferredCity(int userId, String city);

    /**
     * Books a slot for a gym customer.
     * 
     * @param booking The booking details.
     */
    public int bookSlot(FlipFitSlotBooking booking);

    /**
     * Cancels a booking made by a gym customer.
     * 
     * @param bookingId The ID of the booking to be canceled.
     * @return true if the booking was successfully canceled, false otherwise.
     */
    public boolean cancelBooking(int bookingId);

    /**
     * Lists all gym centers in a specified city.
     * 
     * @param city The city for which the gym centers are to be listed.
     */
    public List<FlipFitGymCenter> listAllCentersByCity(int userId);

    /**
     * Views the available slots for a specified gym center.
     * 
     * @param gymCenterId The ID of the gym center for which the available slots are to be viewed.
     */
    public List<FlipFitSlot> viewAvailableSlots(int gymCenterId);

    /**
     * Views the slots booked by a gym customer.
     * 
     * @param userId The ID of the customer whose bookings are to be viewed.
     * @return 
     */
    public List<FlipFitSlotBooking> viewBookedSlots(int userId);

    /**
     * Processes a payment for a gym customer.
     * 
     * @param payment The payment details.
     */
    public void processPayment(FlipFitPayment payment);

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
     * @param notification The notification details to be sent.
     */
    public void sendNotification(FlipFitNotification notification);

    public List<String> getAllCities();
    
    public boolean updateAvailableSeats(int slotId, int availableSeats);
}
