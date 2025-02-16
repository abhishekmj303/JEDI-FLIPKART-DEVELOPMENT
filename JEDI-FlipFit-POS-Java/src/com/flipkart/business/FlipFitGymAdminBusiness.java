package com.flipkart.business;

import com.flipkart.dao.FlipFitGymAdminDao;
import com.flipkart.dao.FlipFitGymAdminDaoImpl;

public class FlipFitGymAdminBusiness implements FlipFitGymAdminInterface {

    private FlipFitGymAdminDao gymAdminDAO;

    /**
     * Constructor to initialize the DAO instance.
     */
    public FlipFitGymAdminBusiness() {
        this.gymAdminDAO = new FlipFitGymAdminDaoImpl();
    }

    /**
     * Adds a new gym admin (this method needs further implementation if admins are stored in the DB).
     * @param userId ID of the user to be added as admin.
     */
    public void addGymAdmin(int userId) {
        System.out.println("Adding gym admin ID: " + userId);
        // Logic to add gym admin can be implemented when DB schema supports it.
    }

    /**
     * Approves a gym owner by updating the database using DAO.
     * @param ownerId ID of the gym owner to approve.
     */
    public void approveGymOwner(int ownerId) {
        boolean isApproved = gymAdminDAO.approveGymOwner(ownerId);
        if (isApproved) {
            System.out.println("Gym owner approved with ID: " + ownerId);
        } else {
            System.out.println("Gym owner ID not found: " + ownerId);
        }
    }

    /**
     * Approves a gym center by updating the database using DAO.
     * @param centreId ID of the gym center to approve.
     */
    public void approveGymCentre(int centreId) {
        boolean isApproved = gymAdminDAO.approveGymCentre(centreId);
        if (isApproved) {
            System.out.println("Gym center approved with ID: " + centreId);
        } else {
            System.out.println("Gym center ID not found: " + centreId);
        }
    }

    /**
     * Lists all gym centers using DAO.
     */
    public void listAllGymCentres() {
        System.out.println("Listing all Gym Centres:");
        gymAdminDAO.listAllGymCentres();
    }
}
