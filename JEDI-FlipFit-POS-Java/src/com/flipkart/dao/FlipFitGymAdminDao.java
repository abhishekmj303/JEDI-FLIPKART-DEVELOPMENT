package com.flipkart.dao;

/**
 * Interface for managing gym admin data operations.
 * This interface defines methods for approving gym owners and centers,
 * and listing all gym centers.
 */
public interface FlipFitGymAdminDao {

    /**
     * Approves a gym owner.
     * 
     * @param ownerId The ID of the gym owner to be approved.
     * @return true if the gym owner was successfully approved, false otherwise.
     */
    public boolean approveGymOwner(int ownerId);

    /**
     * Approves a gym center.
     * 
     * @param centreId The ID of the gym center to be approved.
     * @return true if the gym center was successfully approved, false otherwise.
     */
    public boolean approveGymCentre(int centreId);

    /**
     * Lists all the gym centers in the system.
     */
    public void listAllGymCentres();
}
