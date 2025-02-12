package com.flipkart.client;

import java.util.Scanner;

import com.flipkart.business.FlipFitGymAdminBusiness;

public class FlipFitGymAdminClient {
    public static void showGymAdminMenu(Scanner scanner, String email) {
        int choice;
        FlipFitGymAdminBusiness admin = new FlipFitGymAdminBusiness();
        do {
            System.out.println("\n===== Gym Admin Menu =====");
            System.out.println("1. Approve Gym Centers");
            System.out.println("2. View All Gym Centers");
            System.out.println("3. Edit Profile");
            System.out.println("4. Logout");
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(scanner.nextLine());
            
            switch (choice) {
                case 1:
                    admin.approveGymCentre(101);
                    break;
                case 2:
                	admin.listAllGymCentres();
                    break;
                case 3:
                	admin.updateUser(email);
                	break;
                case 4:
                    admin.logout(email);
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
                    break;
            }
        } while (choice != 4);
    }
}
