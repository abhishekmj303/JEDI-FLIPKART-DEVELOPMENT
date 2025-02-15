/**
 * 
 */
package com.flipkart.dao;

/**
 * 
 */
public interface FlipFitGymCustomerDao {

    void addGymCustomer(FlipFitGymCustomer customer);

    void setPreferredCity(int userId, String city);

    void bookSlot(FlipFitSlotBooking booking);

    boolean cancelBooking(int bookingId);

    void listAllCentersByCity(String city);

    void viewAvailableSlots(int gymCenterId);

    void viewBookedSlots(int userId);

    void processPayment(FlipFitPayment payment);

    boolean refundPayment(int paymentId);

    String getPaymentStatus(int paymentId);

    void sendNotification(FlipFitNotification notification);
}
