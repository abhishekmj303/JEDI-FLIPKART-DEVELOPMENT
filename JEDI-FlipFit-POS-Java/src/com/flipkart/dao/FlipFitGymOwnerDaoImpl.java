package com.flipkart.dao;

import com.flipkart.datasource.Database;
import com.flipkart.constant.SQLConstant;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class FlipFitGymOwnerDaoImpl implements FlipFitGymOwnerDao {
    private Connection connection;
    private int centreId;

    public FlipFitGymOwnerDaoImpl() {
        Database.getInstance();
		this.connection = Database.getConnection();
        this.centreId = 1;
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
    public int addCenterDAO(int ownerId, String centre, String location) {
        String sql = SQLConstant.FLIPFIT_ADD_GYM_CENTRE;
        try (PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, ownerId);
            statement.setString(2, centre);
            statement.setString(3, location);
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Adding GymCenter failed, no rows affected.");
            }
            try (ResultSet rs = statement.getGeneratedKeys()) {
                if (rs.next()) {
                    centreId++;
                    return centreId;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public void addSlot(int centerId, List<String> startTimes, List<String> endTimes) {
        String sql = SQLConstant.FLIPFIT_BOOK_SLOT;
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
            e.printStackTrace();
        }
    }

    @Override
    public void viewSlotsStatusDAO() {
        String sql = SQLConstant.FLIPFIT_FETCH_ALL_SLOTS;
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
