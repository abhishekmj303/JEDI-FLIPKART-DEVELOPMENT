/**
 * Interface for managing gym-related administrative operations.
 * This interface defines methods for adding gym admins, approving gym owners and centres, 
 * and listing gym owners and centres.
 */
package com.flipkart.business;

/**
 * Interface for FlipFit gym admin operations.
 */
public interface FlipFitGymAdminInterface {

    /**
     * Adds a new gym admin.
     * 
     * @param userId The ID of the user to be added as a gym admin.
     */
    public void addGymAdmin(int userId);

    /**
     * Approves a gym owner.
     * 
     * @param userId The ID of the user to be approved as a gym owner.
     */
    public void approveGymOwner(int userId);

    /**
     * Approves a gym centre.
     * 
     * @param centreId The ID of the gym centre to be approved.
     */
    public void approveGymCentre(int centreId);

    /**
     * Lists all the gym centres.
     */
    public void listAllGymCentres();

    /**
     * Lists all the gym owners.
     */
    public void listAllGymOwners();
}
