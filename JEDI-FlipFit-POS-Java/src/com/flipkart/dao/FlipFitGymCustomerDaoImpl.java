package com.flipkart.dao;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.FlipFitGymCenter;
import com.flipkart.bean.FlipFitGymCustomer;
import com.flipkart.bean.FlipFitNotification;
import com.flipkart.bean.FlipFitPayment;
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

    public int bookSlot(FlipFitSlotBooking booking) {
        String sql = SQLConstant.FLIPFIT_BOOK_SLOT;
        int bookingId = -1; 
        
        int existingBookingId = checkPrevSlot(booking.getCustomerId(), booking.getDateTime().toLocalDate());
        if (existingBookingId != 0) {
            cancelBooking(existingBookingId);
        }
    
        try {
    
            try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                stmt.setInt(1, booking.getSlotId());
                stmt.setInt(2, booking.getCustomerId());
                stmt.setDate(3, Date.valueOf(booking.getDateTime().toLocalDate()));
        
                int rowsInserted = stmt.executeUpdate();
                if (rowsInserted > 0) {
                    try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                        if (generatedKeys.next()) {
                            bookingId = generatedKeys.getInt(1);
                            System.out.println("Booking successfully inserted with ID: " + bookingId);
                        }
                    }
                }
            }
    
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    
        return bookingId;
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

    public String getPreferredCity(int userId) {
        String sql = SQLConstant.FLIPFIT_FETCH_USER_PREFERRED_CITY;
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getString("preferredCity");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public List<FlipFitGymCenter> listAllCentersByCity(int userId) {
    List<FlipFitGymCenter> centers = new ArrayList<>();
    
    String city = getPreferredCity(userId);
    if (city == null || city.isEmpty()) {
        System.out.println("No preferred city found for user ID: " + userId);
        return centers; 
    }
    
    String sql = SQLConstant.FLIPFIT_FETCH_GYM_CENTRES_BY_CITY;  
    // "SELECT * FROM gymCenter WHERE city = ?"
    
    try (PreparedStatement stmt = connection.prepareStatement(sql)) {
        stmt.setString(1, city);
        ResultSet rs = stmt.executeQuery();
        System.out.println("Listing gym centers for city " + city + ":");
        
        int index = 1;
        while (rs.next()) {
            int centerId = rs.getInt("id");
            String name = rs.getString("name");
            String address = rs.getString("address");
            String centerCity = rs.getString("city");
            int seatsPerHour = rs.getInt("seatsPerHour");
            java.sql.Time startTimeMorning = rs.getTime("startTimeMorning");
            java.sql.Time endTimeMorning = rs.getTime("endTimeMorning");
            java.sql.Time startTimeEvening = rs.getTime("startTimeEvening");
            java.sql.Time endTimeEvening = rs.getTime("endTimeEvening");
            
            FlipFitGymCenter center = new FlipFitGymCenter(
                    centerId, 
                    name, 
                    address, 
                    centerCity, 
                    seatsPerHour, 
                    startTimeMorning, 
                    endTimeMorning, 
                    startTimeEvening, 
                    endTimeEvening);
                    
            centers.add(center);
            System.out.println(index + ". " + center);
            index++;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    
    return centers;
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
            stmt.setInt(1, payment.getCustomerId());
            stmt.setInt(2, payment.getBookingId());
            stmt.setDouble(3, payment.getAmount());
            stmt.setString(4, payment.getStatus());
            stmt.setString(5, payment.getPaymentMethod());
            stmt.setDate(6, Date.valueOf(payment.getTransactionDate().toLocalDate()));
    
            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Payment successfully processed: " + payment);
            } else {
                System.out.println("Error: Payment failed.");
            }
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
            stmt.setInt(1, notification.getUserId());
            stmt.setString(2, notification.getMessage());
            // Use Timestamp for dateTime column
            if (notification.getDateTime() != null) {
                stmt.setTimestamp(3, Timestamp.valueOf(notification.getDateTime()));
            } else {
                stmt.setTimestamp(3, null);
            }
            stmt.setBoolean(4, notification.isRead());
            stmt.executeUpdate();
            System.out.println("Notification sent: " + notification);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<String> getAllCities() {
        String sql = SQLConstant.FLIPFIT_GET_CITIES;
        List<String> cities = new ArrayList<>();
    
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
    
            while (rs.next()) {
                cities.add(rs.getString("city"));
            }
    
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        return cities;
    }

    public int checkPrevSlot(int userId, LocalDate date) {
        String sql = SQLConstant.FLIPFIT_CHECK_SLOT;
        //"SELECT booking_id FROM bookings WHERE customer_id = ? AND DATE(datetime) = ?"
        int bookingId = 0;
    
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            stmt.setDate(2, Date.valueOf(date));
    
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    bookingId = rs.getInt("booking_id");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(bookingId != 0) System.out.println("Booking already found with booking ID" + bookingId );
        return bookingId;
    }
    

}
