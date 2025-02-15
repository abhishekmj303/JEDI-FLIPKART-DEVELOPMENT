/**
 * 
 */

package com.flipkart.dao;

import com.flipkart.datasource.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FlipFitGymOwnerDaoImpl implements FlipFitGymOwnerDao {

    private Connection connection;

    public FlipFitGymOwnerDaoImpl() {
        // Obtain a DB connection via your Singleton Database class
        this.connection = Database.getInstance().getConnection();
    }

    @Override
    public void addGymOwner(int userId, String aadhaarNo, String pan, String phoneNo) {
        // Example: Insert into the 'gymOwner' table (assuming it has columns: id, AadhaarId, PAN, phoneNo, isApproved)
        String sql = "INSERT INTO gymOwner (id, AadhaarId, PAN, phoneNo, isApproved) VALUES (?, ?, ?, ?, FALSE)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            stmt.setString(2, aadhaarNo);
            stmt.setString(3, pan);
            stmt.setString(4, phoneNo);

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Gym owner added successfully with userId: " + userId);
            } else {
                System.out.println("Failed to add gym owner with userId: " + userId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addCenterAndSlot(String email) {
        Connection connection = Database.getInstance().getConnection();
        Scanner scanner = new Scanner(System.in);
        
        int gymOwnerId = -1;
        int gymCenterId = -1;

        try {
            // Step 1: Find the Gym Owner ID using email
            String findOwnerSql = "SELECT id FROM user WHERE email = ?";
            try (PreparedStatement stmt = connection.prepareStatement(findOwnerSql)) {
                stmt.setString(1, email);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    gymOwnerId = rs.getInt("id");
                } else {
                    System.out.println("Gym Owner with email " + email + " not found.");
                    return;
                }
            }

            // Step 2: Take user input for Gym Center details
            System.out.print("Enter Gym Center Name: ");
            String centerName = scanner.nextLine();
            
            System.out.print("Enter Gym Center Address: ");
            String centerAddress = scanner.nextLine();
            
            System.out.print("Enter Gym Center City: ");
            String centerCity = scanner.nextLine();
            
            System.out.print("Enter Seats Available Per Hour: ");
            int seatsPerHour = scanner.nextInt();
            
            scanner.nextLine(); // Consume newline

            // Step 3: Insert a new Gym Center linked to the Gym Owner
            String insertCenterSql = "INSERT INTO gymCenter (name, address, city, seatsPerHour, gymOwnerId, isApproved) VALUES (?, ?, ?, ?, ?, FALSE)";
            try (PreparedStatement stmt = connection.prepareStatement(insertCenterSql, Statement.RETURN_GENERATED_KEYS)) {
                stmt.setString(1, centerName);
                stmt.setString(2, centerAddress);
                stmt.setString(3, centerCity);
                stmt.setInt(4, seatsPerHour);
                stmt.setInt(5, gymOwnerId);

                int rowsInserted = stmt.executeUpdate();
                if (rowsInserted > 0) {
                    ResultSet generatedKeys = stmt.getGeneratedKeys();
                    if (generatedKeys.next()) {
                        gymCenterId = generatedKeys.getInt(1); // Get the generated Gym Center ID
                    }
                }
            }

            if (gymCenterId == -1) {
                System.out.println("Failed to insert Gym Center.");
                return;
            }

            // Step 4: Take input for number of slots to be created
            System.out.print("Enter number of slots to add: ");
            int numberOfSlots = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            // Step 5: Insert Slots for the Gym Center
            String insertSlotSql = "INSERT INTO slot (centerId, slotInfo, availableSeats) VALUES (?, ?, ?)";
            try (PreparedStatement stmt = connection.prepareStatement(insertSlotSql)) {
                for (int i = 1; i <= numberOfSlots; i++) {
                    System.out.print("Enter Slot " + i + " Time Info (e.g., 9 AM - 10 AM): ");
                    String slotInfo = scanner.nextLine();

                    System.out.print("Enter Available Seats for Slot " + i + ": ");
                    int availableSeats = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    
                    stmt.setInt(1, gymCenterId);
                    stmt.setString(2, slotInfo);
                    stmt.setInt(3, availableSeats);
                    stmt.addBatch(); // Add to batch for efficient execution
                }
                stmt.executeBatch();
            }

            System.out.println("Gym Center and Slots successfully added for Gym Owner with email: " + email);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void viewSlotsStatus() {
        // Example: Query the 'slot' table to display current slots
        String sql = "SELECT id, slotInfo, availableSeats, centerId FROM slot";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            System.out.println("DAO: Current Slot Status:");
            while (rs.next()) {
                int slotId = rs.getInt("id");
                String slotInfo = rs.getString("slotInfo");
                int availableSeats = rs.getInt("availableSeats");
                int centerId = rs.getInt("centerId");
                
                System.out.println(
                    "Slot ID: " + slotId +
                    ", Info: " + slotInfo +
                    ", Available Seats: " + availableSeats +
                    ", Center ID: " + centerId
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
