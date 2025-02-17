package com.flipkart.client;

import java.util.Scanner;

import com.flipkart.bean.FlipFitUser;
import com.flipkart.business.FlipFitGymAdminInterface;
import com.flipkart.business.FlipFitUserInterface;

public class FlipFitGymAdminClient {
    public static void showGymAdminMenu(Scanner scanner, FlipFitGymAdminInterface adminBusiness, FlipFitUserInterface userBusiness, FlipFitUser user) {
        int choice;
        do {
            System.out.println("\n===== Gym Admin Menu =====");
            System.out.println("1. Approve a Gym Owner");
            System.out.println("2. View All Gym Owners");
            System.out.println("3. Approve a Gym Center");
            System.out.println("4. View All Gym Centers");
            System.out.println("5. Edit Profile");
            System.out.println("6. Logout");
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(scanner.nextLine());
            
            switch (choice) {
            	case 1:
            		adminBusiness.approveGymOwner(201);
            		break;
            	case 2:
            		adminBusiness.listAllGymOwners();
                case 3:
                	adminBusiness.approveGymCentre(101);
                    break;
                case 4:
                	adminBusiness.listAllGymCentres();
                    break;
                case 4:
                	userBusiness.updateUser(user.getId());
                	break;
                case 6:
                	userBusiness.logout(user.getEmail());
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
                    break;
            }
        } while (choice != 6);
    }
}
