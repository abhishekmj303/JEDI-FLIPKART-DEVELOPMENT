package com.flipkart.client;

import java.util.Scanner;

public class GymOwnerClient {
    public static void showGymOwnerMenu(Scanner scanner, String username) {
        int choice;
        do {
            System.out.println("\n===== Gym Owner Menu =====");
            System.out.println("1. Add Gym Center");
            System.out.println("2. View My Centers");
            System.out.println("3. Logout");
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(scanner.nextLine());
            
            switch (choice) {
                case 1:
                    // TODO: Implement logic to add a gym center.
                    System.out.println("Adding a new gym center...");
                    // Optionally, implement adding slots as well.
                    System.out.println("Adding slots to the center...");
                    break;
                case 2:
                    // TODO: Implement logic to view gym centers owned by the user.
                    System.out.println("Viewing your gym centers...");
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
