/**
 * 
 */
package com.flipkart.business;

/**
 * 
 */
public interface FlipFitGymAdminInterface {
	public void addGymAdmin(int userId);
	
	public void approveGymOwner(int userId);
	
	public void approveGymCentre(int centreId);
	
	public void listAllGymCentres();
	
	public void listAllGymOwners();
}
