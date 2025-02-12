package com.flipkart.client;

import java.util.Scanner;

public class CustomerClient {
    public static void showGymCustomerMenu(Scanner scanner, String username) {
        int choice;
        do {
            System.out.println("\n===== Gym Customer Menu =====");
            System.out.println("1. View Centers by City");
            System.out.println("2. Book a Slot");
            System.out.println("3. View Booked Slots");
            System.out.println("4. Logout");
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(scanner.nextLine());
            
            switch (choice) {
                case 1:
                    System.out.print("Enter city: ");
                    String city = scanner.nextLine();
                    // TODO: Implement logic to view centers by city.
                    System.out.println("Viewing centers in " + city + "...");
                    break;
                case 2:
                    // TODO: Implement slot booking logic.
                    System.out.println("Booking a slot...");
                    // TODO: Proceed to payment.
                    System.out.println("Proceeding to payment...");
                    break;
                case 3:
                    // TODO: Implement logic to view booked slots.
                    System.out.println("Viewing booked slots...");
                    break;
                case 4:
                    System.out.println("Logging out...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
                    break;
            }
        } while (choice != 4);
    }
}
