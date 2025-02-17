package com.flipkart.business;

import java.util.Scanner;

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
     * Approves a gym owner by updating the database using DAO.
     * @param ownerId ID of the gym owner to approve.
     */
    public void approveGymOwner() {
    	gymAdminDAO.listAllGymOwners();
    	System.out.println("Enter the gymOwner ID to select:");
        
        Scanner sc = new Scanner(System.in); 
        int ownerId = sc.nextInt();
        sc.nextLine(); 
        
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
    public void approveGymCentre() {
    	gymAdminDAO.listAllGymCentres();
    	System.out.println("Enter the gymCenter ID to select:");
        
        Scanner sc = new Scanner(System.in); 
        int centreId = sc.nextInt();
        sc.nextLine(); 
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
    
    public void listAllGymOwners() {
    	System.out.println("Listing all Gym Owners:");
    }
}
