/**
 * 
 */
package com.flipkart.business;

import java.util.HashMap;

import com.flipkart.bean.FlipFitGymCenter;
import com.flipkart.bean.FlipFitGymCustomer;
import com.flipkart.bean.FlipFitNotification;
import com.flipkart.bean.FlipFitPayment;
import com.flipkart.bean.FlipFitSlot;
import com.flipkart.bean.FlipFitSlotBooking;

/**
 * 
 */
public class FlipFitGymCustomerBusiness implements FlipFitGymCustomerInterface {
	private HashMap<Integer, FlipFitGymCustomer> gymCustomers;
	private HashMap<Integer, FlipFitGymCenter> gymCenters;
	private HashMap<Integer, FlipFitSlot> slots;
	private HashMap<Integer, FlipFitSlotBooking> slotBookings;
	private HashMap<Integer, FlipFitNotification> notifications;
	private HashMap<Integer, FlipFitPayment> payments;
	
	public FlipFitGymCustomerBusiness(
			HashMap<Integer, FlipFitGymCustomer> gymCustomers,
			HashMap<Integer, FlipFitGymCenter> gymCenters,
			HashMap<Integer, FlipFitSlot> slots,
			HashMap<Integer, FlipFitSlotBooking> slotBookings,
			HashMap<Integer, FlipFitNotification> notifications,
			HashMap<Integer, FlipFitPayment> payments
		) {
		this.gymCustomers = gymCustomers;
        this.gymCenters = gymCenters;
        this.slots = slots;
        this.slotBookings = slotBookings;
        this.notifications = notifications;
        this.payments = payments;
	}
	
	
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
