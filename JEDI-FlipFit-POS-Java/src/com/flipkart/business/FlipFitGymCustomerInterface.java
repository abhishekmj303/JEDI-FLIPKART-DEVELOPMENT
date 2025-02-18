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
 * Interface for FlipFit gym customer operations.
 */
public interface FlipFitGymCustomerInterface {
	public void addGymCustomer(int userId);
	public void setPreferredCity(int userId);
	public void bookSlot(int userId) throws GymCenterNotFoundException, NoAvailableSeatsException, BookingFailedException, PaymentFailedException;
	public boolean cancelBooking(int userId) throws BookingNotFoundException;
	public void listAllCentersByCity(String city);
	public void viewAvailableSlots(int gymCenterId);
	public void viewBookedSlots(int userId);
	public void processPayment(int customerId,int bookingId, double amount);
	public boolean refundPayment(int paymentId);
	public String getPaymentStatus(int paymentId);
	public void sendNotification(int customerId, String notification);
}
