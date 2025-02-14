/**
 * 
 */
package com.flipkart.dao;

/**
 * 
 */
public interface FlipFitGymAdminDao {
	
	public boolean approveGymOwner(int ownerId);
	
	public boolean approveGymCentre(int centreId);
	
	public void listAllGymCentres();
}
