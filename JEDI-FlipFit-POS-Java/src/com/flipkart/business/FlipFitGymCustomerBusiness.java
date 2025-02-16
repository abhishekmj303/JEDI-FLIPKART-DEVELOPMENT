package com.flipkart.business;

import com.flipkart.bean.FlipFitGymCustomer;
import com.flipkart.bean.FlipFitNotification;
import com.flipkart.bean.FlipFitPayment;
import com.flipkart.bean.FlipFitSlotBooking;
import com.flipkart.dao.FlipFitGymCustomerDao;
import com.flipkart.dao.FlipFitGymCustomerDaoImpl;

import java.time.LocalDateTime;

public class FlipFitGymCustomerBusiness implements FlipFitGymCustomerInterface {
    
    private FlipFitGymCustomerDao gymCustomerDao;

    public FlipFitGymCustomerBusiness() {
        this.gymCustomerDao = new FlipFitGymCustomerDaoImpl();
    }

    // 1. Add a Gym Customer
    public void addGymCustomer(int userId) {
        FlipFitGymCustomer customer = new FlipFitGymCustomer(userId);
        gymCustomerDao.addGymCustomer(customer);
    }

    // 2. Set Preferred City
    public void setPreferredCity(String userId, String city) {
        int id = Integer.parseInt(userId);
        gymCustomerDao.setPreferredCity(id, city);
    }

    // 3. Book a Slot
    public void bookSlot(int userId, int slotId) {
        FlipFitSlotBooking booking = new FlipFitSlotBooking(1, slotId, userId, LocalDateTime.now());
        gymCustomerDao.bookSlot(booking);

        System.out.println("Proceeding to payment...");
        processPayment(userId, 1000);

        if (getPaymentStatus(1).equals("Completed")) {
            sendNotification(userId, "Booking confirmed for slot " + slotId);
        } else {
            sendNotification(userId, "Payment not successful for booking of slot " + slotId);
        }
    }

    // 4. Cancel a Booking
    public boolean cancelBooking(int bookingId) {
        boolean success = gymCustomerDao.cancelBooking(bookingId);
        if (success) {
            refundPayment(1);
            sendNotification(1, "Booking cancelled for booking ID " + bookingId);
        }
        return success;
    }

    // 5. List All Gym Centers by City
    public void listAllCentersByCity(String city) {
        gymCustomerDao.listAllCentersByCity(city);
    }

    // 6. View Available Slots for a Gym Center
    public void viewAvailableSlots(int gymCenterId) {
        gymCustomerDao.viewAvailableSlots(gymCenterId);
    }

    // 7. View Booked Slots for a User
    public void viewBookedSlots(int userId) {
        gymCustomerDao.viewBookedSlots(userId);
    }

    // 8. Process Payment
    public void processPayment(int customerId, double amount) {
        FlipFitPayment payment = new FlipFitPayment(1, 101, customerId, amount, "Completed", "CreditCard", LocalDateTime.now());
        gymCustomerDao.processPayment(payment);
    }

    // 9. Refund Payment
    public boolean refundPayment(int paymentId) {
        return gymCustomerDao.refundPayment(paymentId);
    }

    // 10. Get Payment Status
    public String getPaymentStatus(int paymentId) {
        return gymCustomerDao.getPaymentStatus(paymentId);
    }

    // 11. Send Notification
    public void sendNotification(int customerId, String notificationMessage) {
        FlipFitNotification notification = new FlipFitNotification(1, customerId, notificationMessage, null, false);
        gymCustomerDao.sendNotification(notification);
    }
}
