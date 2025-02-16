/**
 * 
 */
package com.flipkart.constant;

public class SQLConstant {

    //------------------- USER QUERIES ---------------------
    public static final String ADD_USER = "INSERT INTO User (id, name, email, password, roleId) VALUES (?, ?, ?, ?, ?)";
    public static final String FETCH_ALL_USERS = "SELECT * FROM User";
    public static final String FETCH_USER_BY_EMAIL = "SELECT * FROM User WHERE email = ?";
    public static final String UPDATE_USER = "UPDATE User SET name = ?, roleId = ? WHERE email = ?";
    public static final String UPDATE_PASSWORD = "UPDATE User SET password = ? WHERE email = ? AND password = ?";
    public static final String DELETE_USER = "DELETE FROM User WHERE email = ?";
    
    //------------------- GYM OWNER QUERIES ---------------------
    public static final String REGISTER_GYM_OWNER = "INSERT INTO GymOwner (id, name, email, aadhaarNo, pan, phoneNo, isApproved) VALUES (?, ?, ?, ?, ?, ?, ?)";
    public static final String FETCH_ALL_GYM_OWNERS = "SELECT * FROM GymOwner";
    public static final String FETCH_PENDING_GYM_OWNERS = "SELECT * FROM GymOwner WHERE isApproved = 0";
    public static final String APPROVE_GYM_OWNER = "UPDATE GymOwner SET isApproved = 1 WHERE id = ?";

    //------------------- GYM CENTER QUERIES ---------------------
    public static final String ADD_GYM_CENTRE = "INSERT INTO GymCentre (centreId, ownerId, centreName, gstin, city, capacity, price, isApproved) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String FETCH_ALL_GYM_CENTRES = "SELECT * FROM GymCentre";
    public static final String FETCH_GYM_CENTRES_BY_OWNER = "SELECT * FROM GymCentre WHERE ownerId = ?";
    public static final String FETCH_PENDING_GYM_CENTRES = "SELECT * FROM GymCentre WHERE isApproved = 0";
    public static final String APPROVE_GYM_CENTRE = "UPDATE GymCentre SET isApproved = 1 WHERE centreId = ?";

    //------------------- CUSTOMER QUERIES ---------------------
    public static final String REGISTER_CUSTOMER = "INSERT INTO Customer (id, name, email, password, phone, cardDetails) VALUES (?, ?, ?, ?, ?, ?)";
    public static final String CUSTOMER_LOGIN = "SELECT * FROM Customer WHERE email = ? AND password = ?";
    public static final String FETCH_CUSTOMER_BY_ID = "SELECT * FROM Customer WHERE id = ?";

    //------------------- SLOT QUERIES ---------------------
    public static final String FETCH_ALL_SLOTS = "SELECT * FROM Slot";
    public static final String FETCH_SLOTS_BY_CENTRE = "SELECT * FROM Slot WHERE centreId = ?";
    public static final String ADD_SLOT = "INSERT INTO Slot (slotId, centreId, time) VALUES (?, ?, ?)";
    public static final String FETCH_SLOT_BY_ID = "SELECT * FROM Slot WHERE slotId = ?";

    //------------------- BOOKING QUERIES ---------------------
    public static final String BOOK_SLOT = "INSERT INTO Booking (bookingId, userId, slotId, date) VALUES (?, ?, ?, ?)";
    public static final String FETCH_BOOKINGS_BY_CUSTOMER = "SELECT * FROM Booking WHERE userId = ?";
    public static final String CANCEL_BOOKING = "DELETE FROM Booking WHERE bookingId = ?";
    
    //------------------- PAYMENT QUERIES ---------------------
    public static final String PROCESS_PAYMENT = "INSERT INTO Payment (id, customerId, bookingId, amount, status, paymentMethod, transactionDate) VALUES (?, ?, ?, ?, ?, ?, ?)";
    public static final String FETCH_PAYMENT_STATUS = "SELECT status FROM Payment WHERE id = ?";
    public static final String REFUND_PAYMENT = "UPDATE Payment SET status = 'Refunded' WHERE id = ?";
    
    //------------------- NOTIFICATION QUERIES ---------------------
    public static final String SEND_NOTIFICATION = "INSERT INTO Notification (id, userId, message, dateTime, isRead) VALUES (?, ?, ?, ?, ?)";
    public static final String FETCH_NOTIFICATIONS = "SELECT * FROM Notification WHERE userId = ?";
}
