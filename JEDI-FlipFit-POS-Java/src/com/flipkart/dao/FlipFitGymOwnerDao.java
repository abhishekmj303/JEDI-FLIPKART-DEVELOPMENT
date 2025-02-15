package com.flipkart.dao;

import java.util.List;

public interface FlipFitGymOwnerDao {
    void addGymOwnerDAO(int userId, String aadhaarNo, String pan, String phoneNo);
    int addCenterDAO(int ownerId, String centre, String location);
    void addSlot(int centerId, List<String> startTimes, List<String> endTimes);
    void viewSlotsStatusDAO();
}
