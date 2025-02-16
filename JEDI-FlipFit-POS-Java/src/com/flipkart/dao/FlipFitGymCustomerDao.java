/**
 * 
 */
package com.flipkart.dao;

import com.flipkart.bean.FlipFitGymCustomer;
import com.flipkart.bean.FlipFitNotification;
import com.flipkart.bean.FlipFitPayment;
import com.flipkart.bean.FlipFitSlotBooking;

/**
 * 
 */
public interface FlipFitGymCustomerDao {

    public void addGymCustomer(FlipFitGymCustomer customer);

    public void setPreferredCity(int userId, String city);

    public void bookSlot(FlipFitSlotBooking booking);

    public boolean cancelBooking(int bookingId);

    public void listAllCentersByCity(String city);

    public void viewAvailableSlots(int gymCenterId);

    public void viewBookedSlots(int userId);

    public void processPayment(FlipFitPayment payment);

    public boolean refundPayment(int paymentId);

    public String getPaymentStatus(int paymentId);

    public void sendNotification(FlipFitNotification notification);
}
