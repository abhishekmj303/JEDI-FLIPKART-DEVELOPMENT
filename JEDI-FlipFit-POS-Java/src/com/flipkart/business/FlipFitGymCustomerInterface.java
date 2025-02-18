/**
 * Interface for managing customer-related operations in a gym system.
 * This interface defines methods for adding customers, managing bookings, 
 * handling payments, and sending notifications.
 */
package com.flipkart.business;

import com.flipkart.exception.BookingFailedException;
import com.flipkart.exception.BookingNotFoundException;
import com.flipkart.exception.GymCenterNotFoundException;
import com.flipkart.exception.NoAvailableSeatsException;
import com.flipkart.exception.PaymentFailedException;

/**
 * Interface for managing FlipFit gym customers.
 */
public interface FlipFitGymCustomerInterface {

    /**
     * Adds a new gym customer.
     *
     * @param userId The unique ID of the user to be added as a gym customer.
     */
    public void addGymCustomer(int userId);

    /**
     * Sets the preferred city for the gym customer.
     *
     * @param userId The unique ID of the user.
     */
    public void setPreferredCity(int userId);

    /**
     * Books a gym slot for the customer.
     *
     * @param userId The unique ID of the user.
     * @throws GymCenterNotFoundException If no gym center is found.
     * @throws NoAvailableSeatsException If no available seats are found at the chosen gym center.
     * @throws BookingFailedException If the booking process fails.
     * @throws PaymentFailedException If the payment process fails.
     */
    public void bookSlot(int userId) throws GymCenterNotFoundException, NoAvailableSeatsException, BookingFailedException, PaymentFailedException;

    /**
     * Cancels a booking for the customer.
     *
     * @param userId The unique ID of the user.
     * @return {@code true} if the booking was successfully cancelled, {@code false} otherwise.
     * @throws BookingNotFoundException If the booking is not found.
     */
    public boolean cancelBooking(int userId) throws BookingNotFoundException;

    /**
     * Lists all gym centers in a given city.
     *
     * @param city The name of the city.
     */
    public void listAllCentersByCity(String city);

    /**
     * Views the available slots for a given gym center.
     *
     * @param gymCenterId The unique ID of the gym center.
     */
    public void viewAvailableSlots(int gymCenterId);

    /**
     * Views the booked slots for a given customer.
     *
     * @param userId The unique ID of the user.
     */
    public void viewBookedSlots(int userId);

    /**
     * Processes the payment for a booking.
     *
     * @param customerId The ID of the customer making the payment.
     * @param bookingId The ID of the booking for which payment is being made.
     * @param amount The amount to be paid.
     */
    public void processPayment(int customerId, int bookingId, double amount);

    /**
     * Refunds a payment.
     *
     * @param paymentId The unique ID of the payment to be refunded.
     * @return {@code true} if the refund was successful, {@code false} otherwise.
     */
    public boolean refundPayment(int paymentId);

    /**
     * Gets the payment status.
     *
     * @param paymentId The unique ID of the payment.
     * @return The status of the payment.
     */
    public String getPaymentStatus(int paymentId);

    /**
     * Sends a notification to the customer.
     *
     * @param customerId The unique ID of the customer to notify.
     * @param notification The notification message.
     */
    public void sendNotification(int customerId, String notification);
}