/**
 * 
 */
package com.flipkart.business;

/**
 * 
 */
public interface FlipFitGymCustomerInterface {
	public void setPreferredCity(String email, String city);
	public void bookSlot(String email, int slotId);
	public boolean cancelBooking(int bookingId);
	public void listAllCentersByCity(String city);
	public void viewAvailableSlots(int gymCenterId);
	public void viewBookedSlots(String email);
	public void processPayment(int customerId, double amount);
	public boolean refundPayment(int paymentId);
	public String getPaymentStatus(int paymentId);
	public void sendNotification(int customerId, String notification);
}
