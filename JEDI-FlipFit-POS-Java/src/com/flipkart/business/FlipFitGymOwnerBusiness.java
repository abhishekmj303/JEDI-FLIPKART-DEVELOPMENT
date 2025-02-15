/**
 * 
 */

package com.flipkart.business;

import com.flipkart.dao.FlipFitGymOwnerDao;
import com.flipkart.dao.FlipFitGymOwnerDaoImpl;

public class FlipFitGymOwnerBusiness implements FlipFitGymOwnerInterface {
    private FlipFitGymOwnerDao gymOwnerDao;
    
    public FlipFitGymOwnerBusiness() {
        this.gymOwnerDao = new FlipFitGymOwnerDaoImpl();
    }
    
    /**
     * Adds a new Gym Owner by calling the DAO method.
     */
    @Override
    public void addGymOwner(int userId, String aadhaarNo, String pan, String phoneNo) {
        gymOwnerDao.addGymOwner(userId, aadhaarNo, pan, phoneNo);
    }

    /**
     * Adds a new Gym Center and slots for the given owner's email.
     */
    @Override
    public void addCenterAndSlot(String email) {
        gymOwnerDao.addCenterAndSlot(email);
    }

    /**
     * Displays the current slot status via the DAO method.
     */
    @Override
    public void viewSlotsStatus() {
        gymOwnerDao.viewSlotsStatus();
    }
}

