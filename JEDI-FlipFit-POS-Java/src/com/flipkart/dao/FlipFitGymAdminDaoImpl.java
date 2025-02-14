package com.flipkart.dao;

import com.flipkart.bean.FlipFitGymAdmin;
import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.bean.FlipFitGymCenter;
import com.flipkart.utils.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FlipFitGymAdminDaoImpl implements FlipFitGymAdminDao {
    
    private Connection con;

    public FlipFitGymAdminDaoImpl() {
        this.con = Database.getInstance().getConnection();
    }

    @Override
    public void addGymAdmin(FlipFitGymAdmin admin) {
        String query = "INSERT INTO gym_admins (user_id, name, email, password) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setInt(1, admin.getUserId());
            stmt.setString(2, admin.getName());
            stmt.setString(3, admin.getEmail());
            stmt.setString(4, admin.getPassword());
            stmt.executeUpdate();
            System.out.println("Gym admin added: " + admin.getName() + " (ID: " + admin.getUserId() + ")");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean approveGymOwner(int ownerId) {
        String query = "UPDATE gym_owners SET approved = TRUE WHERE owner_id = ?";
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setInt(1, ownerId);
            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean approveGymCentre(int centreId) {
        String query = "UPDATE gym_centres SET approved = TRUE WHERE centre_id = ?";
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setInt(1, centreId);
            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<FlipFitGymCenter> listAllGymCentres() {
        List<FlipFitGymCenter> centres = new ArrayList<>();
        String query = "SELECT centre_id, name FROM gym_centres";
        try (PreparedStatement stmt = con.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("centre_id");
                String name = rs.getString("name");
                centres.add(new FlipFitGymCenter(id, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return centres;
    }
}
