package com.flipkart.dao;

import com.flipkart.datasource.Database;
import com.flipkart.exception.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class FlipFitGymOwnerDaoImpl implements FlipFitGymOwnerDao {
    private Connection connection;

    public FlipFitGymOwnerDaoImpl() {
        this.connection = Database.getInstance().getConnection();
        this.centreId = 1;
    }

    @Override
    public void addGymOwnerDAO(int userId, String aadhaarNo, String pan, String phoneNo) throws GymOwnerNotRegisteredException {
        String sql = "INSERT INTO GymOwner (user_id, aadhaar_no, pan, phone_no) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, userId);
            statement.setString(2, aadhaarNo);
            statement.setString(3, pan);
            statement.setString(4, phoneNo);
            statement.executeUpdate();
            System.out.println("Gym Owner added successfully.");
        } catch (SQLException e) {
            throw new GymOwnerNotRegisteredException("Error in Registering the Gym owner");
        }
    }

    @Override
    public int addCenterDAO(int ownerId, String centre, String location) {
        String sql = "INSERT INTO gymCenter (gymOwnerId, name, address) VALUES (?, ?, ?)";
    
        try (PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, ownerId);
            statement.setString(2, centre);
            statement.setString(3, location);
    
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new RuntimeException("Adding GymCenter failed, no rows affected.");
            }
    
            try (ResultSet rs = statement.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1); // Correct way to retrieve generated ID
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Database error while adding GymCenter", e);
        }
        return -1;
    }
    

    @Override
    public void addSlot(int centerId, List<String> startTimes, List<String> endTimes) throws GymCenterNotFoundException {
        String sql = "INSERT INTO Slot (center_id, start_time, end_time, capacity) VALUES (?, ?, ?, ?)";
        int defaultCapacity = 10;
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            for (int i = 0; i < startTimes.size(); i++) {
                statement.setInt(1, centerId);
                statement.setString(2, startTimes.get(i));
                statement.setString(3, endTimes.get(i));
                statement.setInt(4, defaultCapacity);
                statement.executeUpdate();
            }
            System.out.println("Slots added successfully.");
        } catch (SQLException e) {
            throw new  GymCenterNotFoundException("Error in finding Gym cenetr");
        }
    }

    @Override
    public void viewSlotsStatusDAO() {
        String sql = "SELECT g.name AS gym_name, s.start_time, s.end_time FROM Slot s JOIN GymCenter g ON s.center_id = g.id";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            System.out.println("Current Slot Status:");
            while (resultSet.next()) {
                System.out.println("Gym: " + resultSet.getString("gym_name") +
                                   " | Slot: " + resultSet.getString("start_time") + " - " + resultSet.getString("end_time"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
