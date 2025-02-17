package com.flipkart.dao;

import com.flipkart.constant.SQLConstant;
import com.flipkart.datasource.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FlipFitGymAdminDaoImpl implements FlipFitGymAdminDao {

    private Connection connection;

    // Constructor initializes the database connection once
    public FlipFitGymAdminDaoImpl() {
        Database.getInstance();
		this.connection = Database.getConnection();
    }

    @Override
    public boolean approveGymOwner(int ownerId) {
        String query = SQLConstant.FLIPFIT_APPROVE_GYM_OWNER;
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
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean approveGymCentre(int centreId) {
        String query = SQLConstant.FLIPFIT_APPROVE_GYM_CENTRE;
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
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void listAllGymCentres() {
        String query = SQLConstant.FLIPFIT_FETCH_ALL_GYM_CENTRES;
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
