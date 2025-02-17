package com.flipkart.dao;

import com.flipkart.datasource.Database;
import com.flipkart.constant.SQLConstant;
import java.sql.Connection;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.List;

public class FlipFitGymOwnerDaoImpl implements FlipFitGymOwnerDao {
    private Connection connection;

    public FlipFitGymOwnerDaoImpl() {
        Database.getInstance();
		this.connection = Database.getConnection();
    }

    @Override
    public void addGymOwnerDAO(int userId, String aadhaarNo, String pan, String phoneNo) {
        String sql = SQLConstant.FLIPFIT_REGISTER_GYM_OWNER;
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, userId);
            statement.setString(2, aadhaarNo);
            statement.setString(3, pan);
            statement.setString(4, phoneNo);
            statement.executeUpdate();
            System.out.println("Gym Owner added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int addCenterDAO(int ownerId, String centreName, String city, String address, int seatsPerHour, 
                            String startTimeMorning, String endTimeMorning, String startTimeEvening, String endTimeEvening) {
        
        String sql = SQLConstant.FLIPFIT_ADD_GYM_CENTRE;
        
        try (PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            
            // Convert time strings into LocalTime
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm a").withLocale(Locale.US);
            LocalTime morningStart = LocalTime.parse(startTimeMorning, timeFormatter);
            LocalTime morningEnd = LocalTime.parse(endTimeMorning, timeFormatter);
            LocalTime eveningStart = LocalTime.parse(startTimeEvening, timeFormatter);
            LocalTime eveningEnd = LocalTime.parse(endTimeEvening, timeFormatter);

            // Set parameters
            statement.setInt(1, ownerId);
            statement.setString(2, centreName);
            statement.setString(3, address);
            statement.setString(4, city);
            statement.setInt(5, seatsPerHour);
            statement.setTime(6, Time.valueOf(morningStart));
            statement.setTime(7, Time.valueOf(morningEnd));
            statement.setTime(8, Time.valueOf(eveningStart));
            statement.setTime(9, Time.valueOf(eveningEnd));
            statement.setInt(10, 0); // isApproved default 0
            

            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Adding GymCenter failed, no rows affected.");
            }

            // Get generated centre ID
            try (ResultSet rs = statement.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }


    @Override
    public void addSlot(int centerId, List<String> morningTimes, List<String> eveningTimes, int availableSeats) {
        String sql = SQLConstant.FLIPFIT_ADD_SLOT;
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            for (int i = 0; i < morningTimes.size(); i++) {
                statement.setInt(1, centerId);
                statement.setString(2, morningTimes.get(i));
                statement.setInt(3, availableSeats);
                statement.executeUpdate();
            }
            for (int i = 0; i < eveningTimes.size(); i++) {
                statement.setInt(1, centerId);
                statement.setString(2, eveningTimes.get(i));
                statement.setInt(3, availableSeats);
                statement.executeUpdate();
            }
            System.out.println("Slots added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void viewSlotsStatusDAO() {
        String sql = "SELECT gc.name AS gym_name, s.slotInfo AS slot_details, s.availableSeats, " +
                     "gc.startTimeMorning, gc.endTimeMorning, gc.startTimeEvening, gc.endTimeEvening " +
                     "FROM gymCenter gc " +
                     "LEFT JOIN slot s ON gc.id = s.centerId";

        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            System.out.println("Current Slot Status:");

            while (resultSet.next()) {
                String gymName = resultSet.getString("gym_name");
                String slotDetails = resultSet.getString("slot_details");
                int availableSeats = resultSet.getInt("availableSeats");
                
                String morningStart = resultSet.getString("startTimeMorning");
                String morningEnd = resultSet.getString("endTimeMorning");
                String eveningStart = resultSet.getString("startTimeEvening");
                String eveningEnd = resultSet.getString("endTimeEvening");

                System.out.println("Gym: " + gymName + 
                                   " | Slot: " + slotDetails + 
                                   " | Available Seats: " + availableSeats);

                if (morningStart != null && morningEnd != null) {
                    System.out.println("  ➝ Morning Slot: " + morningStart + " - " + morningEnd);
                }
                if (eveningStart != null && eveningEnd != null) {
                    System.out.println("  ➝ Evening Slot: " + eveningStart + " - " + eveningEnd);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void listAllGymCentres(int ownerId) {
        String query = SQLConstant.FLIPFIT_FETCH_GYM_CENTRES_BY_OWNER;
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, ownerId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String address = rs.getString("address");
                String city = rs.getString("city");

                System.out.println("Center ID: " + id + " | Name: " + name + " | Address: " + address + " | City: " + city);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
