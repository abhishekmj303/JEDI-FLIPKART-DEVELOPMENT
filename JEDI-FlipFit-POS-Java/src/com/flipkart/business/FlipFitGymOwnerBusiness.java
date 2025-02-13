/**
 * 
 */
package com.flipkart.business;

/**
 * 
 */

public class FlipFitGymOwnerBusiness implements FlipFitGymOwnerInterface {
	
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
