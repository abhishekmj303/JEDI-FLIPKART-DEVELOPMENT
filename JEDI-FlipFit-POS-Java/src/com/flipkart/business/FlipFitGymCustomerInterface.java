/**
 * 
 */
package com.flipkart.business;

/**
 * 
 */
public interface FlipFitGymCustomerInterface {
	public void addGymCustomer(int userId);
	public void setPreferredCity(int userId, String city);
	public void bookSlot(int userId, int slotId);
	public boolean cancelBooking(int bookingId);
	public void listAllCentersByCity(String city);
	public void viewAvailableSlots(int gymCenterId);
	public void viewBookedSlots(int userId);
	public void processPayment(int customerId, double amount);
	public boolean refundPayment(int paymentId);
	public String getPaymentStatus(int paymentId);
	public void sendNotification(int customerId, String notification);
}
