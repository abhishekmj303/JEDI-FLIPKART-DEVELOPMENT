/**
 * 
 */
package com.flipkart.business;
import com.flipkart.bean.GymOwner;
import com.flipkart.dao.GymOwnerDAO;

public class GymOwnerBusiness {

    private GymOwnerDAO gymOwnerDAO = new GymOwnerDAO() ;

    public void registerGymOwner(GymOwner gymOwner) { 
        System.out.println("Process started for registration of Gym owner" + gymOwner.getName());
        gymOwnerDAO.registerGymOwner(gymOwner);
    }


     public void addCenterAndSlot(GymOwner gymOwner) {
        System.out.println("Adding a gym center and slots..." + gymOwner.getId());
    }

    public void viewSlotsStatus() {
        System.out.println("Current Slot Status...");
    }
}
