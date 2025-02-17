package com.flipkart.dao;

import java.util.List;

import com.flipkart.exception.GymCenterNotFoundException;
import com.flipkart.exception.GymOwnerNotRegisteredException;

public interface FlipFitGymOwnerDao {
    void addGymOwnerDAO(int userId, String aadhaarNo, String pan, String phoneNo) throws GymOwnerNotRegisteredException;
    int addCenterDAO(int ownerId, String centre, String location);
    void addSlot(int centerId, List<String> startTimes, List<String> endTimes) throws GymCenterNotFoundException;
    void viewSlotsStatusDAO();
}
