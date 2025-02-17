/**
 * 
 */
package com.flipkart.business;

/**
 * 
 */
public interface FlipFitGymCustomerInterface {
	public void addGymCustomer(int userId);
	public void setPreferredCity(int userId);
	public void bookSlot(int userId);
	public boolean cancelBooking(int userId);
	public void listAllCentersByCity(String city);
	public void viewAvailableSlots(int gymCenterId);
	public void viewBookedSlots(int userId);
	public void processPayment(int customerId,int bookingId, double amount);
	public boolean refundPayment(int paymentId);
	public String getPaymentStatus(int paymentId);
	public void sendNotification(int customerId, String notification);
}
