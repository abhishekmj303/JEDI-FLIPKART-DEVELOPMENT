package com.flipkart.dao;

import java.util.List;

/**
 * Interface for managing gym owner data operations.
 * This interface defines methods for adding gym owners, adding gym centers and slots,
 * and viewing the status of gym slots.
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

    /**
     * Adds a new gym center for the gym owner.
     * 
     * @param ownerId The ID of the gym owner adding the center.
     * @param centreName The name of the gym center.
     * @param city The city where the gym center is located.
     * @param address The address of the gym center.
     * @param seatsPerHour The number of available seats per hour at the gym center.
     * @param startTimeMorning The start time of the morning session.
     * @param endTimeMorning The end time of the morning session.
     * @param startTimeEvening The start time of the evening session.
     * @param endTimeEvening The end time of the evening session.
     * @return The ID of the newly added gym center.
     */
    public int addCenterDAO(int ownerId, String centreName, String city, String address, int seatsPerHour, 
            String startTimeMorning, String endTimeMorning, String startTimeEvening, String endTimeEvening);

    /**
     * Adds available time slots to a gym center.
     * 
     * @param centerId The ID of the gym center for which the slots are being added.
     * @param startTimes A list of start times for the available slots.
     * @param endTimes A list of end times for the available slots.
     */
    public void addSlot(int centerId, List<String> startTimes, List<String> endTimes, int availableSeats);

    /**
     * Views the status of the slots at all gym centers.
     */
    public void viewSlotsStatusDAO();
    
    public void listAllGymCentres(int ownerId);
}
