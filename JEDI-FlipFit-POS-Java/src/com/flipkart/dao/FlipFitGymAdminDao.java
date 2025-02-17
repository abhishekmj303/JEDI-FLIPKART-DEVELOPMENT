package com.flipkart.dao;

/**
 * The FlipFitGymAdminDao interface defines the data access operations related to gym admin tasks.
 * It includes methods for approving gym owners, approving gym centers, and listing all gym centers.
 */
public interface FlipFitGymAdminDao {
    
    /**
     * Approves a gym owner based on their ID.
     * 
     * @param ownerId The ID of the gym owner to be approved.
     * @return true if the gym owner was successfully approved, false otherwise.
     */
    public boolean approveGymOwner(int ownerId);
    
    /**
     * Approves a gym center based on its ID.
     * 
     * @param centreId The ID of the gym center to be approved.
     * @return true if the gym center was successfully approved, false otherwise.
     */
    public boolean approveGymCentre(int centreId);
    
    /**
     * Lists all the gym centers in the system.
     * This method retrieves and displays information about all gym centers.
     */
    public void listAllGymCentres();
}
