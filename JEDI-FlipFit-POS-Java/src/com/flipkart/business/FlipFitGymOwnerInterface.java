
package com.flipkart.business;

public interface FlipFitGymOwnerInterface {
	
	public void addGymOwner(int userId, String aadhaarNo, String pan, String phoneNo);
    
    public void addCenterAndSlot(String email);

    public void viewSlotsStatus();

}
