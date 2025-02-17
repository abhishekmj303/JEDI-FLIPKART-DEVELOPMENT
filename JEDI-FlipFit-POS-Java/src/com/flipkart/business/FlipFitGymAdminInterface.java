/**
 * The FlipFitGymAdminInterface defines the contract for operations that can be performed by the gym admin in the FlipFit system.
 * It includes methods for managing gym owners, gym centers, and the overall administration of the gym network.
 */
package com.flipkart.business;

/**
 * Interface for gym admin operations, including adding admin users, approving gym owners and centers, 
 * and listing all gym owners and centers.
 */
public interface FlipFitGymAdminInterface {
    
    /**
     * Adds a new gym admin based on the provided user ID.
     * 
     * @param userId The ID of the user to be added as a gym admin.
     */
    public void addGymAdmin(int userId);
    
    /**
     * Approves a gym owner by their user ID, allowing them to operate a gym within the system.
     * 
     * @param userId The ID of the gym owner to be approved.
     */
    public void approveGymOwner(int userId);
    
    /**
     * Approves a gym center based on the provided center ID.
     * 
     * @param centreId The ID of the gym center to be approved.
     */
    public void approveGymCentre(int centreId);
    
    /**
     * Lists all the gym centers in the system.
     */
    public void listAllGymCentres();
    
    /**
     * Lists all the gym owners in the system.
     */
    public void listAllGymOwners();
}
