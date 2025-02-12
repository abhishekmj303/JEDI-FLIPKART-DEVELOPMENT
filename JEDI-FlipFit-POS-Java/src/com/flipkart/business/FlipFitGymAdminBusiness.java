/**
 * 
 */
package com.flipkart.business;
/**
 * 
 */
public class FlipFitGymAdminBusiness extends FlipFitUserBusiness {
	
	public void approveGymCentre(int centreId) {
		System.out.println("Gym centre approved with ID: " + centreId);
	}
    
    public void listAllGymCentres() {
        System.out.println("Listing all Gym Centres with details");
    }
}
