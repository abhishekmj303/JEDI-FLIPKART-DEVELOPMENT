package com.flipkart.business;

import java.util.HashMap;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.flipkart.bean.FlipFitGymCenter;
import com.flipkart.bean.FlipFitGymCustomer;
import com.flipkart.bean.FlipFitNotification;
import com.flipkart.bean.FlipFitPayment;
import com.flipkart.bean.FlipFitSlot;
import com.flipkart.bean.FlipFitSlotBooking;

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

    // 1. Add a Gym Customer using a hardcoded customer detail.
    public void addGymCustomer(int userId) {
        FlipFitGymCustomer customer = new FlipFitGymCustomer(userId);
        gymCustomers.put(userId, customer);
        System.out.println("Added Gym Customer: " + customer);
    }

    public void setPreferredCity(String userId, String city) {
        int id = Integer.parseInt(userId);
        FlipFitGymCustomer customer = gymCustomers.get(id);
        if (customer != null) {
            customer.setPreferredCity(city);
            System.out.println("Preferred city for " + userId + " set to " + city);
        } else {
            System.out.println("Customer with user ID " + userId + " not found.");
        }
    }

    // 3. Book a Slot
    public void bookSlot(int userId, int slotId) {
        // Retrieve the customer from the gymCustomers map using userId.
        FlipFitGymCustomer customer = gymCustomers.get(userId);
        if (customer == null) {
            System.out.println("Customer with user id " + userId + " not found.");
            return;
        }
        viewAvailableSlots(101);
        int bookingId = 1;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime bookingDateTime = LocalDateTime.parse("2025-02-14 10:00:00", formatter);
        
        FlipFitSlotBooking booking = new FlipFitSlotBooking(bookingId, slotId, userId, bookingDateTime);
        slotBookings.put(bookingId, booking);
        
        System.out.println("Customer With "+ " slot Id " + slotId + " booked slot with booking id " + bookingId);
        System.out.println("Proceeding to payment...");
        int paymentId = 2;
        processPayment(paymentId, 1000);
        
        if (getPaymentStatus(paymentId).equals("Completed")) {
            sendNotification(paymentId, "Booking confirmed for slot " + slotId);
        } else {
            sendNotification(paymentId, "Payment not successful for booking of slot " + slotId);
        }
    }
    

    // 4. Cancel a booking
    public boolean cancelBooking(int bookingId) {
        if (slotBookings.containsKey(bookingId)) {
            slotBookings.remove(bookingId);
            System.out.println("Booking cancelled with ID: " + bookingId);
            refundPayment(101);
            sendNotification(101, "Booking cancelled for booking id " + bookingId);
            return true;
        } else {
            System.out.println("No booking found with ID: " + bookingId);
            return false;
        }
    }

    // 5. List all Gym Centers by City
    public void listAllCentersByCity(String city) {
        System.out.println("Listing all gym centers for city " + city + ":");
        for (FlipFitGymCenter center : gymCenters.values()) {
            if (center.getCity().equalsIgnoreCase(city)) {
                System.out.println(center);
            }
        }
    }

    // 6. View Available Slots for a given Gym Center
    public void viewAvailableSlots(int gymCenterId) {
        System.out.println("Fetching available slots for Gym Center ID: " + gymCenterId);
        for (FlipFitSlot slot : slots.values()) {
            if (slot.getCenterId() == gymCenterId) {
                System.out.println(slot);
            }
        }
    }

    // 7. View Booked Slots 
    public void viewBookedSlots(int userId) {
        System.out.println("Fetching booked slots for user: " + userId);
        for (FlipFitSlotBooking booking : slotBookings.values()) {
            if (booking.getCustomerId() == userId) {
                System.out.println(booking);
            }
        }
    }
    // 8. Process Payment
    public void processPayment(int customerId, double amount) {
        int paymentId = 101;
        FlipFitPayment payment = new FlipFitPayment(paymentId, customerId, amount, "Completed", "CreditCard", "2025-02-14");
        payments.put(paymentId, payment);
        System.out.println("Processing payment of Rs. " + amount + " for Customer ID: " + customerId);
    }

    // 9. Refund Payment
    public boolean refundPayment(int paymentId) {
        if (payments.containsKey(paymentId)) {
            FlipFitPayment payment = payments.get(paymentId);
            payment.setStatus("Refunded");
            System.out.println("Refunding payment with ID: " + paymentId);
            return true;
        } else {
            System.out.println("Payment with ID " + paymentId + " not found for refund.");
            return false;
        }
    }

    // 10. Get Payment Status
    public String getPaymentStatus(int paymentId) {
        if (payments.containsKey(paymentId)) {
            FlipFitPayment payment = payments.get(paymentId);
            System.out.println("Fetching payment status for Payment ID: " + paymentId);
            return payment.getStatus();
        } else {
            return "Not Found";
        }
    }

    public void sendNotification(int customerId, String notification) {
        int notificationId = notifications.size() + 1;
        FlipFitNotification notif = new FlipFitNotification(notificationId, customerId, notification, null, false);
        notifications.put(notificationId, notif);
        System.out.println("Notification sent to customer ID " + customerId + ": " + notification);
    }
}
