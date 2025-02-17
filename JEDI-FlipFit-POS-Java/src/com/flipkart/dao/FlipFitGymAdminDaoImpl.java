package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.flipkart.datasource.Database;
import com.flipkart.exception.GymCenterNotFoundException;
import com.flipkart.exception.GymOwnerNotRegisteredException;

public class FlipFitGymAdminDaoImpl implements FlipFitGymAdminDao {

    private Connection connection;

    // Constructor initializes the database connection once
    public FlipFitGymAdminDaoImpl() {
        this.connection = Database.getInstance().getConnection();
    }

    @Override
    public boolean approveGymOwner(int ownerId) throws GymOwnerNotRegisteredException {
        String query = "UPDATE gymOwner SET isApproved = TRUE WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, ownerId);
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Gym owner approved with ID: " + ownerId);
                return true;
            } else {
                System.out.println("Gym owner ID not found: " + ownerId);
            }
        } catch (SQLException e) {
            throw new GymOwnerNotRegisteredException("Error in approving Gym");
        }
        return false;
    }

    @Override
    public boolean approveGymCentre(int centreId) throws GymCenterNotFoundException {
        String query = "UPDATE gymCenter SET isApproved = TRUE WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, centreId);
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Gym center approved with ID: " + centreId);
                return true;
            } else {
                System.out.println("Gym center ID not found: " + centreId);
            }
        } catch (SQLException e) {
              throw new GymCenterNotFoundException("Error in approving gym")
        }
        return false;
    }

    @Override
    public void listAllGymCentres() {
        String query = "SELECT id, name, address, city FROM gymCenter";
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            System.out.println("Listing all Gym Centres:");
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
