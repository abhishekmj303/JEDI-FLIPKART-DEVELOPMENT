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
	private int ownerId;
	private HashMap<Integer, FlipFitGymCenter> centres;
	private int centerId;

	


	 public FlipFitGymAdminBusiness(
		        HashMap<Integer, FlipFitGymOwner> owners,
		        HashMap<Integer, FlipFitGymCenter> centres
		    ) {
		        this.owners = owners;
		        this.centres = centres;
		        this.ownerId = 1;
		        this.centerId = 1;
		    }

	
	public FlipFitGymAdminBusiness() {
		// TODO Auto-generated constructor stub
	}


	public void addGymAdmin(int userId) {
		System.out.println("Adding gym admin ID: " + userId);
	}
	
	public void approveGymOwner(int ownerId) {
		if(owners.containsKey(ownerId)) {
		System.out.println("Gym owner approved with ID: " + ownerId);
		
	}else {
		System.out.println("Gym owner ID not found: " + ownerId);
	}
	}
	
	public void approveGymCentre(int centreId) {
		if(centres.containsKey(centerId)) {
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
