package com.flipkart.dao;

import java.util.List;

public interface FlipFitGymOwnerDao {
    public void addGymOwnerDAO(int userId, String aadhaarNo, String pan, String phoneNo);
    public int addCenterDAO(int ownerId, String centreName, String city, String address, int seatsPerHour, 
            String startTimeMorning, String endTimeMorning, String startTimeEvening, String endTimeEvening);
    public void addSlot(int centerId, List<String> startTimes, List<String> endTimes);
    public void viewSlotsStatusDAO();
}
