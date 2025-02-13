package com.flipkart.client;

import java.util.Scanner;

import com.flipkart.business.FlipFitGymOwnerBusiness;
import com.flipkart.business.FlipFitGymOwnerInterface;

public class FlipFitGymOwnerClient {
    public static void showGymOwnerMenu(Scanner scanner, String email) {
        int choice;
        FlipFitGymOwnerInterface gymowner = new FlipFitGymOwnerBusiness();
        do {
            System.out.println("\n===== Gym Owner Menu =====");
            System.out.println("1. Add Gym Center");
            System.out.println("2. View My Centers");
            System.out.println("3. Edit Profile");
            System.out.println("4. Logout");
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(scanner.nextLine());
            
            switch (choice) {
                case 1:
                    gymowner.addCenterAndSlot(email);
                    break;
                case 2:
                    gymowner.viewSlotsStatus();
                    break;
                case 3:
                	gymowner.updateUser(email);
                	break;
                case 4:
                    gymowner.logout(email);
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
                    break;
            }
        } while (choice != 4);
    }
}
