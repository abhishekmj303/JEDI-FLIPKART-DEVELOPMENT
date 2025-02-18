package com.flipkart.business;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.flipkart.dao.FlipFitGymAdminDao;
import com.flipkart.dao.FlipFitGymAdminDaoImpl;
import com.flipkart.exception.GymCenterNotFoundException;
import com.flipkart.exception.GymOwnerNotFoundException;

public class FlipFitGymAdminBusiness implements FlipFitGymAdminInterface {

    private FlipFitGymAdminDao gymAdminDAO;

    public FlipFitGymAdminBusiness() {
        this.gymAdminDAO = new FlipFitGymAdminDaoImpl();
    }

    public void approveGymOwner() throws GymOwnerNotFoundException {
        gymAdminDAO.listAllGymOwners();
        System.out.println("Enter the gymOwner ID to select:");

        Scanner sc = new Scanner(System.in);
        int ownerId;

        try {
            ownerId = sc.nextInt();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("Invalid input. Please enter a valid integer for Owner ID.");
        } finally {
            sc.nextLine(); // Consume newline left by nextInt()
        }


        boolean isApproved = gymAdminDAO.approveGymOwner(ownerId);
        if (isApproved) {
            System.out.println("Gym owner approved with ID: " + ownerId);
        } else {
            throw new GymOwnerNotFoundException("Gym owner ID not found: " + ownerId);
        }
    }

    public void approveGymCentre() throws GymCenterNotFoundException {
        gymAdminDAO.listAllGymCentres();
        System.out.println("Enter the gymCenter ID to select:");

        Scanner sc = new Scanner(System.in);
        int centreId;
        try {
            centreId = sc.nextInt();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("Invalid input. Please enter a valid integer for Center ID.");
        } finally {
            sc.nextLine();
        }

        boolean isApproved = gymAdminDAO.approveGymCentre(centreId);
        if (isApproved) {
            System.out.println("Gym center approved with ID: " + centreId);
        } else {
            throw new GymCenterNotFoundException("Gym center ID not found: " + centreId);
        }
    }

    public void listAllGymCentres() {
        System.out.println("Listing all Gym Centres:");
        gymAdminDAO.listAllGymCentres();
    }

    public void listAllGymOwners() {
        System.out.println("Listing all Gym Owners:");
        gymAdminDAO.listAllGymOwners(); // Added missing DAO call
    }
}