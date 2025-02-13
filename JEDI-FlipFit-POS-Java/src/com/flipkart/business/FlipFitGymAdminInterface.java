/**
 * 
 */
package com.flipkart.business;

/**
 * 
 */
public interface FlipFitGymAdminInterface {
	public void approveGymOwner(int userId);
	
	public void approveGymCentre(int centreId);
	
	public void listAllGymCentres();
}
