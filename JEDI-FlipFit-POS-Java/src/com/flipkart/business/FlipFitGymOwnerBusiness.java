/**
 * 
 */
package com.flipkart.business;

import com.flipkart.dao.FlipFitGymOwnerDao;
import com.flipkart.dao.FlipFitGymOwnerDaoImpl;

/**
 * 
 */

public class FlipFitGymOwnerBusiness implements FlipFitGymOwnerInterface {
	private FlipFitGymOwnerDao gymOwnerDao;
	
	public FlipFitGymOwnerBusiness() {
		this.gymOwnerDao = new FlipFitGymOwnerDaoImpl();
	}
	
	public void addGymOwner(int userId, String aadhaarNo, String pan, String phoneNo) {
		System.out.println("Adding a gym owner " + userId);
	}


     public void addCenterAndSlot(String email) {
        System.out.println("Adding a gym center and slots for " + email);
    }

    public void viewSlotsStatus() {
        System.out.println("Current Slot Status...");
    }
}
