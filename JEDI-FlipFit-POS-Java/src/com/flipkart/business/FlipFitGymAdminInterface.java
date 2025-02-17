/**
 * Interface for managing gym-related administrative operations.
 * This interface defines methods for adding gym admins, approving gym owners and centres, 
 * and listing gym owners and centres.
 */
package com.flipkart.business;

/**
 * Interface for FlipFit gym admin operations.
 */
public interface FlipFitGymAdminInterface {

    /**
     * Approves a gym owner.
     */
    public void approveGymOwner();

    /**
     * Approves a gym centre.
     */
    public void approveGymCentre();

    /**
     * Lists all the gym centres.
     */
    public void listAllGymCentres();

    /**
     * Lists all the gym owners.
     */
    public void listAllGymOwners();
}
