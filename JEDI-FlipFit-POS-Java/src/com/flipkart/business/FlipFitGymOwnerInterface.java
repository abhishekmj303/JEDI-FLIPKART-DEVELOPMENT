package com.flipkart.business;

/**
 * Interface for managing gym owner-related operations.
 * This interface defines methods for adding gym owners, adding gym centers and slots, 
 * and viewing the status of slots.
 */
public interface FlipFitGymOwnerInterface {

    /**
     * Adds a new gym owner.
     * 
     * @param userId The ID of the user to be added as a gym owner.
     */
    public void addGymOwner(int userId);

    /**
     * Adds a gym center and its available slots for a gym owner.
     * 
     * @param ownerId The ID of the gym owner adding the center and slots.
     */
    public void addCenterAndSlot(int ownerId);

    /**
     * Views the status of all available and booked slots for the gym center.
     */
    public void viewSlotsStatus();
    
    public void viewAllCenters(int ownerId);
}
