package com.flipkart.client;

import java.util.Scanner;

public class AdminClient {
    public static void showGymAdminMenu(Scanner scanner, String username) {
        int choice;
        do {
            System.out.println("\n===== Gym Admin Menu =====");
            System.out.println("1. Approve Gym Centers");
            System.out.println("2. View All Gym Centers");
            System.out.println("3. Logout");
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(scanner.nextLine());
            
            switch (choice) {
                case 1:
                    // TODO: Implement logic to approve gym centers.
                    System.out.println("Approving gym centers...");
                    break;
                case 2:
                    // TODO: Implement logic to view all gym centers.
                    System.out.println("Listing all gym centers...");
                    break;
                case 3:
                    System.out.println("Logging out...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
                    break;
            }
        } while (choice != 3);
    }
}
