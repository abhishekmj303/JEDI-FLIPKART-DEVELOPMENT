/**
 * 
 */
package com.flipkart.constant;

public class SQLConstant {

    //------------------- USER QUERIES ---------------------
    public static final String FLIPFIT_ADD_USER = "INSERT INTO user (id, name, email, password, roleId) VALUES (?, ?, ?, ?, ?)";
    public static final String FLIPFIT_FETCH_ALL_USERS = "SELECT * FROM user";
    public static final String FLIPFIT_LOGIN = "SELECT * FROM user WHERE email = ? AND password = ?";
    public static final String FLIPFIT_FETCH_USER_BY_EMAIL = "SELECT * FROM user WHERE email = ?";
    public static final String FLIPFIT_UPDATE_USER = "UPDATE user SET name = ?, roleId = ? WHERE email = ?";
    public static final String FLIPFIT_UPDATE_PASSWORD = "UPDATE user SET password = ? WHERE email = ? AND password = ?";
    public static final String FLIPFIT_DELETE_USER = "DELETE FROM user WHERE email = ?";

    //------------------- ROLE QUERIES ---------------------
    public static final String FLIPFIT_FETCH_ALL_ROLES = "SELECT * FROM role";
    public static final String FLIPFIT_FETCH_ROLE_BY_ID = "SELECT * FROM role WHERE id = ?";

    //------------------- GYM OWNER QUERIES ---------------------
    public static final String FLIPFIT_REGISTER_GYM_OWNER = "INSERT INTO gymOwner (id, AadhaarId, PAN, phoneNo) VALUES (?, ?, ?, ?)";
    public static final String FLIPFIT_FETCH_ALL_GYM_OWNERS = "SELECT * FROM gymOwner";
    public static final String FLIPFIT_FETCH_PENDING_GYM_OWNERS = "SELECT * FROM gymOwner WHERE isApproved = 0";
    public static final String FLIPFIT_APPROVE_GYM_OWNER = "UPDATE gymOwner SET isApproved = 1 WHERE id = ?";

    //------------------- GYM CENTER QUERIES ---------------------
    public static final String FLIPFIT_ADD_GYM_CENTRE = "INSERT INTO gymCenter (id, name, address, city, seatsPerHour, startTimeMorning, endTimeMorning, startTimeEvening, endTimeEvening, isApproved, gymOwnerId) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String FLIPFIT_FETCH_ALL_GYM_CENTRES = "SELECT * FROM gymCenter";
    public static final String FLIPFIT_FETCH_GYM_CENTRES_BY_OWNER = "SELECT * FROM gymCenter WHERE gymOwnerId = ?";
    public static final String FLIPFIT_FETCH_GYM_CENTRES_BY_CITY = "SELECT * FROM gymCenter WHERE city = ?";
    public static final String FLIPFIT_FETCH_PENDING_GYM_CENTRES = "SELECT * FROM gymCenter WHERE isApproved = 0";
    public static final String FLIPFIT_APPROVE_GYM_CENTRE = "UPDATE gymCenter SET isApproved = 1 WHERE id = ?";

    //------------------- GYM CUSTOMER QUERIES ---------------------
    public static final String FLIPFIT_REGISTER_GYM_CUSTOMER = "INSERT INTO gymCustomer (id, preferredCity) VALUES (?, ?)";
    public static final String FLIPFIT_FETCH_GYM_CUSTOMER_BY_ID = "SELECT * FROM gymCustomer WHERE id = ?";
    public static final String FLIPFIT_UPDATE_PREFERRED_CITY = "UPDATE gymCustomer SET preferredCity = ? WHERE id = ?";

    //------------------- SLOT QUERIES ---------------------
    public static final String FLIPFIT_FETCH_ALL_SLOTS = "SELECT * FROM slot";
    public static final String FLIPFIT_FETCH_SLOTS_BY_CENTRE = "SELECT * FROM slot WHERE centerId = ?";
    public static final String FLIPFIT_ADD_SLOT = "INSERT INTO slot (id, centerId, slotInfo, availableSeats) VALUES (?, ?, ?, ?)";
    public static final String FLIPFIT_FETCH_SLOT_BY_ID = "SELECT * FROM slot WHERE id = ?";

    //------------------- SLOT BOOKING QUERIES ---------------------
    public static final String FLIPFIT_BOOK_SLOT = "INSERT INTO slotBooking (id, slotId, customerId, date) VALUES (?, ?, ?, ?)";
    public static final String FLIPFIT_FETCH_BOOKINGS_BY_CUSTOMER = "SELECT * FROM slotBooking WHERE customerId = ?";
    public static final String FLIPFIT_CANCEL_BOOKING = "DELETE FROM slotBooking WHERE id = ?";

    //------------------- PAYMENT QUERIES ---------------------
    public static final String FLIPFIT_PROCESS_PAYMENT = "INSERT INTO payment (id, customerId, bookingId, amount, status, paymentMethod, transactionDate) VALUES (?, ?, ?, ?, ?, ?, ?)";
    public static final String FLIPFIT_FETCH_PAYMENT_STATUS = "SELECT status FROM payment WHERE id = ?";
    public static final String FLIPFIT_REFUND_PAYMENT = "UPDATE payment SET status = 'Refunded' WHERE id = ?";

    //------------------- NOTIFICATION QUERIES ---------------------
    public static final String FLIPFIT_SEND_NOTIFICATION = "INSERT INTO notification (id, userId, message, dateTime, isRead) VALUES (?, ?, ?, ?, ?)";
    public static final String FLIPFIT_FETCH_NOTIFICATIONS = "SELECT * FROM notification WHERE userId = ?";

}

