/**
 * 
 */
package com.flipkart.business;

/**
 * 
 */
public class FlipFitGymCustomerBusiness implements FlipFitGymCustomerInterface {
	
	public void addGymCustomer(int userId) {
		System.out.println("Added Gym Customer " + userId);
	}
	
	public void setPreferredCity(String email, String city) {
		System.out.println("Set city as " + city);
	}
	
    public void bookSlot(String email, int slotId) {
    	viewAvailableSlots(101);
        System.out.println("Customer " + email + " booked slot " + slotId);
        System.out.println("Proceeding to payment...");
        processPayment(101,1000);
        if (getPaymentStatus(101) == "Completed") {
        	sendNotification(101, "Booking confirmed");
        } else {
        	sendNotification(101, "Payment not successful");
        }
    }
    
    public boolean cancelBooking(int bookingId) {
        System.out.println("Booking cancelled with ID: " + bookingId);
        refundPayment(101);
        sendNotification(101, "Booking cancelled");
        return true;
    }
    
    public void listAllCentersByCity(String city) {
    	System.out.println("Listing all gym centers for city "+ city);
    }
    
    public void viewAvailableSlots(int gymCenterId) {
        System.out.println("Fetching available slots for Gym Center ID: " + gymCenterId);
    }
    
    public void viewBookedSlots(String email) {
        System.out.println("Fetching available slots for User: " + email);
    }
    
    public void processPayment(int customerId, double amount) {
        System.out.println("Processing payment of Rs. " + amount + " for Customer ID: " + customerId);
    }
    
    public boolean refundPayment(int paymentId) {
        System.out.println("Refunding payment with ID: " + paymentId);
        return true;
    }
    
    public String getPaymentStatus(int paymentId) {
        System.out.println("Fetching payment status for Payment ID: " + paymentId);
        return "Completed";
    }
    
    public void sendNotification(int customerId, String notification) {
        System.out.println("Notification sent to customer ID " + customerId);
    }
}
