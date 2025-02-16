package com.flipkart.dao;

import java.util.List;

public interface FlipFitGymOwnerDao {
    public void addGymOwnerDAO(int userId, String aadhaarNo, String pan, String phoneNo);
    public int addCenterDAO(int ownerId, String centre, String location);
    public void addSlot(int centerId, List<String> startTimes, List<String> endTimes);
    public void viewSlotsStatusDAO();
}
