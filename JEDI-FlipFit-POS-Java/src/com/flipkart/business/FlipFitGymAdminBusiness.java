/**
 * 
 */
package com.flipkart.business;
/**
 * 
 */
public class FlipFitGymAdminBusiness implements FlipFitGymAdminInterface {
	
	public void addGymAdmin(int userId) {
		System.out.println("Adding gym owner ID: " + userId);
	}
	
	public void approveGymOwner(int userId) {
		System.out.println("Gym owner approved with ID: " + userId);
	}
	
	public void approveGymCentre(int centreId) {
		System.out.println("Gym centre approved with ID: " + centreId);
	}
    
    public void listAllGymCentres() {
        System.out.println("Listing all Gym Centres with details");
    }
}
