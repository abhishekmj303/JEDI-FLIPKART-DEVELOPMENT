
package com.flipkart.business;

public interface FlipFitGymOwnerInterface {
	
	public void addGymOwner(int userId, String aadhaarNo, String pan, String phoneNo);
    
    public void addCenterAndSlot(int ownerId);

    public void viewSlotsStatus();

}
