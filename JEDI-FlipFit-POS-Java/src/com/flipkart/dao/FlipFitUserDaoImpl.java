/**
 * 
 */
package com.flipkart.dao;

import com.flipkart.bean.FlipFitUser;
import com.flipkart.constant.SQLConstant;
import com.flipkart.datasource.Database;

import java.sql.*;

public class FlipFitUserDaoImpl implements FlipFitUserDao {

    private Connection connection;

    public FlipFitUserDaoImpl() {
        Database.getInstance();
		this.connection = Database.getConnection();
    }

    public int addUser(FlipFitUser user) {
        try (PreparedStatement stmt = connection.prepareStatement(SQLConstant.FLIPFIT_ADD_USER, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, user.getId());
            stmt.setString(2, user.getName());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getPassword());
            stmt.setInt(5, user.getRoleId());

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                ResultSet generatedKeys = stmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public boolean updateUser(String email, String name, int roleId) {
        String sql = SQLConstant.FLIPFIT_UPDATE_USER;
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setInt(2, roleId);
            stmt.setString(3, email);

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updatePassword(String email, String oldPassword, String newPassword) {
        String sql = SQLConstant.FLIPFIT_UPDATE_PASSWORD;
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, newPassword);
            stmt.setString(2, email);
            stmt.setString(3, oldPassword);

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public FlipFitUser getUserByEmail(String email) {
        String sql = SQLConstant.FLIPFIT_FETCH_USER_BY_EMAIL;
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new FlipFitUser(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("password"),
                    rs.getInt("roleId")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void listAllUsers() {
        String sql = SQLConstant.FLIPFIT_FETCH_ALL_USERS;
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("User ID: " + rs.getInt("id") +
                        ", Name: " + rs.getString("name") +
                        ", Email: " + rs.getString("email") +
                        ", Role ID: " + rs.getInt("roleId"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public FlipFitUser login(String email, String password) {
        String sql = "SELECT * FROM user WHERE email = ? AND password = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, email);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new FlipFitUser(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("password"),
                    rs.getInt("roleId")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String generateToken(int userId) {
        return "token_" + userId; // Simplified example (not secure)
    }

    public boolean validateToken(String token) {
        return token.startsWith("token_"); // Simplified validation
    }
}
