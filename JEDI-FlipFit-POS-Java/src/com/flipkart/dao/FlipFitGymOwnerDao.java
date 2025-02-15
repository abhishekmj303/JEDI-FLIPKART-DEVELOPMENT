/**
 * 
 */
package com.flipkart.dao;

/**
 * 
 */
public interface FlipFitGymOwnerDao {
	
	void addGymOwner(int userId, String aadhaarNo, String pan, String phoneNo);
	
	void addCenterAndSlot(String email);
	
	void viewSlotsStatus();
	
}
