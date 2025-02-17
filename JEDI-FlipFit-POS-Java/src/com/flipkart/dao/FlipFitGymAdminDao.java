/**
 * 
 */
package com.flipkart.dao;

import com.flipkart.exception.GymCenterNotFoundException;
import com.flipkart.exception.GymOwnerNotRegisteredException;

/**
 * 
 */
public interface FlipFitGymAdminDao {
	
	public boolean approveGymOwner(int ownerId) throws GymOwnerNotRegisteredException;
	
	public boolean approveGymCentre(int centreId) throws GymCenterNotFoundException ;
	
	public void listAllGymCentres();
}
