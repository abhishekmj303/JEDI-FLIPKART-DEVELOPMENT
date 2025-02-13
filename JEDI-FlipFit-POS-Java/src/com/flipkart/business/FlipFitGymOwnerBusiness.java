/**
 * 
 */
package com.flipkart.business;

/**
 * 
 */

public class FlipFitGymOwnerBusiness extends FlipFitUserBusiness implements FlipFitGymOwnerInterface {


     public void addCenterAndSlot(String email) {
        System.out.println("Adding a gym center and slots for " + email);
    }

    public void viewSlotsStatus() {
        System.out.println("Current Slot Status...");
    }
}
