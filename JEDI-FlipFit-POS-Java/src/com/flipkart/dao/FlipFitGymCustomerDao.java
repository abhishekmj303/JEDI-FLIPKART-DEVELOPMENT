/**
 * 
 */
package com.flipkart.dao;

import com.flipkart.bean.FlipFitGymCustomer;
import com.flipkart.bean.FlipFitNotification;
import com.flipkart.bean.FlipFitPayment;
import com.flipkart.bean.FlipFitSlotBooking;
import com.flipkart.exception.CustomerNotRegisteredException;
import com.flipkart.exception.GymCenterNotFoundException;
import com.flipkart.exception.SlotUnavailableException;

/**
 * 
 */
public interface FlipFitGymCustomerDao {

    void addGymCustomer(FlipFitGymCustomer customer);

    void setPreferredCity(int userId, String city) throws CustomerNotRegisteredException;

    void bookSlot(FlipFitSlotBooking booking) throws SlotUnavailableException ;

    boolean cancelBooking(int bookingId);

    void listAllCentersByCity(String city);

    void viewAvailableSlots(int gymCenterId) throws GymCenterNotFoundException;

    void viewBookedSlots(int userId) throws CustomerNotRegisteredException;

    void processPayment(FlipFitPayment payment);

    boolean refundPayment(int paymentId);

    String getPaymentStatus(int paymentId);

    void sendNotification(FlipFitNotification notification);
}
