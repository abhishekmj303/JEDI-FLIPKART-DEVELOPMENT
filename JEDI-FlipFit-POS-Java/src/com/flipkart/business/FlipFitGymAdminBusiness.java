/**
 * 
 */
package com.flipkart.business;

import java.util.HashMap;
import com.flipkart.bean.FlipFitGymAdmin;
import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.bean.FlipFitGymCenter;
import com.flipkart.dao.FlipFitGymAdminDao;
import com.flipkart.dao.FlipFitGymAdminDaoImpl;
/**
 * 
 */
public class FlipFitGymAdminBusiness implements FlipFitGymAdminInterface {
	private HashMap<Integer, FlipFitGymOwner> owners;
	private HashMap<Integer, FlipFitGymCenter> centres;
	private FlipFitGymAdminDao adminDao;


	 public FlipFitGymAdminBusiness(
		        HashMap<Integer, FlipFitGymOwner> owners,
		        HashMap<Integer, FlipFitGymCenter> centres
		) {
			this.owners = owners;
			this.centres = centres;
			this.adminDao = new FlipFitGymAdminDaoImpl(); // Initialize DAO
	}

	 public void addGymAdmin(int userId, String name, String email, String password) {
	        FlipFitGymAdmin admin = new FlipFitGymAdmin(userId, name, email, password);
	        adminDao.addGymAdmin(admin);
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
		if(centres.containsKey(centreId)) {
			FlipFitGymCenter center = centres.get(centreId);
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
