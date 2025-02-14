/**
 * 
 */
package com.flipkart.business;

import java.util.HashMap;
import com.flipkart.bean.FlipFitGymAdmin;
import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.bean.FlipFitGymCenter;
/**
 * 
 */
public class FlipFitGymAdminBusiness implements FlipFitGymAdminInterface {
	private HashMap<Integer, FlipFitGymOwner> owners;
	private HashMap<Integer, FlipFitGymCenter> centres;

	 public FlipFitGymAdminBusiness(
		        HashMap<Integer, FlipFitGymOwner> owners,
		        HashMap<Integer, FlipFitGymCenter> centres
		) {
			this.owners = owners;
			this.centres = centres;
	}

	public void addGymAdmin(int userId) {
		System.out.println("Adding gym admin ID: " + userId);
	}
	
	public void approveGymOwner(int ownerId) {
		if(owners.containsKey(ownerId)) {
			FlipFitGymOwner owner = owners.get(ownerId);
			owner.setApproved(true);
			System.out.println("Gym owner approved with ID: " + ownerId);
	}else {
		System.out.println("Gym owner ID not found: " + ownerId);
	}
	}
	
	public void approveGymCentre(int centreId) {
		if(centres.containsKey(centerId)) {
			FlipFitGymCenter center = centers.get(ownerId);
			center.setApproved(true);
			System.out.println("Gym center approved with ID: " + centreId);
		}else {
		System.out.println("Gym centre ID not found: " + centreId);
	
		}
		}
    
    public void listAllGymCentres() {
        System.out.println("Listing all Gym Centres with details");
        for (int id : centres.keySet()) {
            System.out.println("Center ID: " + id + " - " + centres.get(id).getName());
        }
    }
}
