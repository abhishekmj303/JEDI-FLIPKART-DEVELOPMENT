/**
 * 
 */
package com.flipkart.business;
import com.flipkart.bean.GymCustomer
/**
 * 
 */
public class GymCustomerBusiness {
	private PaymentBusiness payment = new PaymentBusiness();
	
    public void bookSlot(int customerId, int slotId) {
        System.out.println("Customer " + customerId + " booked slot " + slotId);
        payment.processPayment(customerId,1000);
    }
    
    public boolean cancelBooking(int bookingId) {
        System.out.println("Booking cancelled with ID: " + bookingId);
        return true;
    }
    
    public void viewAvailableSlots(int gymCenterId) {
        System.out.println("Fetching available slots for Gym Center ID: " + gymCenterId);
    }
    
    public void viewBookedSlots(int userId) {
        System.out.println("Fetching available slots for User ID: " + userId);
    }
    
}
