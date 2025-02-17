package com.flipkart.dao;

import java.util.List;

/**
 * The FlipFitGymOwnerDao interface defines the data access operations related to gym owner tasks in the FlipFit system.
 * It includes methods for adding gym owners, centers, slots, and viewing slot statuses.
 */
public interface FlipFitGymOwnerDao {

    /**
     * Adds a new gym owner to the system.
     * 
     * @param userId The ID of the gym owner.
     * @param aadhaarNo The Aadhaar number of the gym owner.
     * @param pan The PAN number of the gym owner.
     * @param phoneNo The phone number of the gym owner.
     */
    public void addGymOwnerDAO(int userId, String aadhaarNo, String pan, String phoneNo);
<<<<<<< HEAD

    /**
     * Adds a new gym center to the system and associates it with the gym owner.
     * 
     * @param ownerId The ID of the gym owner to whom the center belongs.
     * @param centre The name of the gym center.
     * @param location The location of the gym center.
     * @return The ID of the newly added gym center.
     */
    public int addCenterDAO(int ownerId, String centre, String location);

    /**
     * Adds available slots for a specific gym center.
     * 
     * @param centerId The ID of the gym center for which the slots are being added.
     * @param startTimes A list of start times for the slots.
     * @param endTimes A list of end times for the slots.
     */
=======
    public int addCenterDAO(int ownerId, String centreName, String city, String address, int seatsPerHour, 
            String startTimeMorning, String endTimeMorning, String startTimeEvening, String endTimeEvening);
>>>>>>> 2b379df129282e95fc550c917e3596d9a689a9bc
    public void addSlot(int centerId, List<String> startTimes, List<String> endTimes);

    /**
     * Views the status of all the slots in the system.
     * This method retrieves and displays information about the availability of slots across gym centers.
     */
    public void viewSlotsStatusDAO();
}
