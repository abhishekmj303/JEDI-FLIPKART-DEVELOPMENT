package com.flipkart.business;

import com.flipkart.exception.CenterCreationFailedException;
import com.flipkart.exception.InvalidCenterDetailsException;
import com.flipkart.exception.InvalidTimeFormatException;

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
     * @throws InvalidTimeFormatException 
     * @throws InvalidCenterDetailsException 
     * @throws CenterCreationFailedException 
     */
    public void addCenterAndSlot(int ownerId) throws InvalidCenterDetailsException, InvalidTimeFormatException, CenterCreationFailedException;

    /**
     * Views the status of all available and booked slots for the gym center.
     */
    public void viewSlotsStatus();
    
    public void viewAllCenters(int ownerId);
}
