package com.flipkart.dao;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.LocalDate;
import com.flipkart.bean.FlipFitGymCustomer;
import com.flipkart.bean.FlipFitGymCenter;
import com.flipkart.bean.FlipFitNotification;
import com.flipkart.bean.FlipFitPayment;
import com.flipkart.bean.FlipFitSlot;
import com.flipkart.bean.FlipFitSlotBooking;
import com.flipkart.datasource.Database;
import com.flipkart.constant.SQLConstant;

public class FlipFitGymCustomerDaoImpl implements FlipFitGymCustomerDao {

    private Connection connection;

    public FlipFitGymCustomerDaoImpl() {
        Database.getInstance();
		connection = Database.getConnection();
    };
    
    // 1. Add a Gym Customer (insert into gymCustomer table)
    public void addGymCustomer(FlipFitGymCustomer customer) {
        String sql = SQLConstant.FLIPFIT_REGISTER_GYM_CUSTOMER;
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, customer.getId());
            stmt.setString(2, customer.getPreferredCity());
            stmt.executeUpdate();
            System.out.println("Added Gym Customer: " + customer);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 2. Set Preferred City for a Gym Customer
    public void setPreferredCity(int userId, String city) {
        String sql = SQLConstant.FLIPFIT_UPDATE_PREFERRED_CITY;
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, city);
            stmt.setInt(2, userId);
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Preferred city for user " + userId + " set to " + city);
            } else {
                System.out.println("Customer with user ID " + userId + " not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 3. Book a Slot (insert into slotBooking table)
    // Note: The slotBooking table schema: id, slotId, customerId, date
    public void bookSlot(FlipFitSlotBooking booking) {
        String sql = SQLConstant.FLIPFIT_BOOK_SLOT;
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, booking.getId());
            stmt.setInt(2, booking.getSlotId());
            stmt.setInt(3, booking.getCustomerId());
            // Convert LocalDateTime to java.sql.Date (using only the date portion)
            LocalDate bookingDate = booking.getDateTime().toLocalDate();
            stmt.setDate(4, Date.valueOf(bookingDate));
            stmt.executeUpdate();
            System.out.println("Booking inserted: " + booking);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 4. Cancel a Booking (delete from slotBooking table)
    public boolean cancelBooking(int bookingId) {
        String sql = SQLConstant.FLIPFIT_CANCEL_BOOKING;
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, bookingId);
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Booking cancelled with ID: " + bookingId);
                return true;
            } else {
                System.out.println("No booking found with ID: " + bookingId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // 5. List All Gym Centers by City (query gymCenter table)
    public void listAllCentersByCity(String city) {
        String sql = SQLConstant.FLIPFIT_FETCH_GYM_CENTRES_BY_CITY;
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, city);
            ResultSet rs = stmt.executeQuery();
            System.out.println("Listing gym centers for city " + city + ":");
            while (rs.next()) {
                int centerId = rs.getInt("id");
                String name = rs.getString("name");
                String address = rs.getString("address");
                String centerCity = rs.getString("city");
                String seatsPerHour = rs.getString("seatsPerHour");
                // You can fetch other columns as needed
                System.out.println("Center ID: " + centerId + ", Name: " + name + ", Address: " + address + ", City: " + centerCity + ", Seats/Hour: " + seatsPerHour);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 6. View Available Slots for a given Gym Center (query slot table)
    public void viewAvailableSlots(int gymCenterId) {
        String sql = SQLConstant.FLIPFIT_FETCH_SLOTS_BY_CENTRE;
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, gymCenterId);
            ResultSet rs = stmt.executeQuery();
            System.out.println("Available slots for Gym Center ID " + gymCenterId + ":");
            while (rs.next()) {
                int slotId = rs.getInt("id");
                String slotInfo = rs.getString("slotInfo");
                int availableSeats = rs.getInt("availableSeats");
                System.out.println("Slot ID: " + slotId + ", Slot Info: " + slotInfo + ", Available Seats: " + availableSeats);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 7. View Booked Slots for a given customer (query slotBooking table)
    public void viewBookedSlots(int userId) {
        String sql = SQLConstant.FLIPFIT_FETCH_BOOKINGS_BY_CUSTOMER;
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            System.out.println("Booked slots for user " + userId + ":");
            while (rs.next()) {
                int bookingId = rs.getInt("id");
                int slotId = rs.getInt("slotId");
                Date date = rs.getDate("date");
                System.out.println("Booking ID: " + bookingId + ", Slot ID: " + slotId + ", Date: " + date);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 8. Process Payment (insert into payment table)
    // Note: The payment table schema: id, customerId, bookingId, amount, status, paymentMethod, transactionDate
    public void processPayment(FlipFitPayment payment) {
        String sql = SQLConstant.FLIPFIT_PROCESS_PAYMENT;
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, payment.getId());
            stmt.setInt(2, payment.getCustomerId());
            stmt.setInt(3, payment.getBookingId());
            stmt.setDouble(4, payment.getAmount());
            stmt.setString(5, payment.getStatus());
            stmt.setString(6, payment.getPaymentMethod());
            // Convert LocalDateTime to java.sql.Date (using only the date part)
            LocalDate transactionDate = payment.getTransactionDate().toLocalDate();
            stmt.setDate(7, Date.valueOf(transactionDate));
            stmt.executeUpdate();
            System.out.println("Processed payment: " + payment);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 9. Refund Payment (update payment table)
    public boolean refundPayment(int paymentId) {
        String sql = SQLConstant.FLIPFIT_REFUND_PAYMENT;
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, paymentId);
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Refunded payment with ID: " + paymentId);
                return true;
            } else {
                System.out.println("Payment with ID " + paymentId + " not found for refund.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // 10. Get Payment Status (query payment table)
    public String getPaymentStatus(int paymentId) {
        String sql = SQLConstant.FLIPFIT_FETCH_PAYMENT_STATUS;
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, paymentId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String status = rs.getString("status");
                System.out.println("Payment status for ID " + paymentId + " is " + status);
                return status;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Not Found";
    }

    // 11. Send Notification (insert into notification table)
    // Note: The notification table schema: id, userId, message, dateTime, isRead
    public void sendNotification(FlipFitNotification notification) {
        String sql = SQLConstant.FLIPFIT_SEND_NOTIFICATION;
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, notification.getNotificationId());
            stmt.setInt(2, notification.getUserId());
            stmt.setString(3, notification.getNotificationId());
            
            if (notification.getDateTime() != null) {
                stmt.setTimestamp(4, Timestamp.valueOf(notification.getDateTime()));
            } else {
                stmt.setTimestamp(4, null);
            }
            stmt.setBoolean(5, notification.isRead());
            stmt.executeUpdate();
            System.out.println("Notification sent: " + notification);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
