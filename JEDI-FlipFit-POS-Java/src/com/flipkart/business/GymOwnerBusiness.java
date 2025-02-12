/**
 * 
 */
package com.flipkart.business;
import com.flipkart.bean.GymOwner;
/**
 * 
 */

public class GymOwnerBusiness {


     public void addCenterAndSlot(GymOwner gymOwner) {
        System.out.println("Adding a gym center and slots..." + gymOwner.getId());
    }

    public void viewSlotsStatus() {
        System.out.println("Current Slot Status...");
    }
}
