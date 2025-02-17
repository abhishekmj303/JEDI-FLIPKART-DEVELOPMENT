package com.flipkart.business;

/**
 * The FlipFitGymOwnerInterface defines the contract for operations that can be performed by gym owners in the FlipFit system.
 * It includes methods for managing gym owner data, adding centers and slots, and viewing slot statuses.
 */
public interface FlipFitGymOwnerInterface {
    
<<<<<<< HEAD
    /**
     * Adds a new gym owner based on the provided details.
     * 
     * @param userId The ID of the gym owner.
     * @param aadhaarNo The Aadhaar number of the gym owner.
     * @param pan The PAN (Permanent Account Number) of the gym owner.
     * @param phoneNo The phone number of the gym owner.
     */
    public void addGymOwner(int userId, String aadhaarNo, String pan, String phoneNo);
    
    /**
     * Adds a gym center and available slots based on the provided email.
     * 
     * @param email The email of the gym owner.
     */
    public void addCenterAndSlot(String email);
    
    /**
     * Views the status of the available slots in the gym.
     * This method provides information about whether slots are available or fully booked.
     */
=======
    public void addCenterAndSlot(int ownerId);

>>>>>>> 2b379df129282e95fc550c917e3596d9a689a9bc
    public void viewSlotsStatus();
}
