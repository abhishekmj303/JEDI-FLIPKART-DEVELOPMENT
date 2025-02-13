package com.flipkart.client;
import com.flipkart.business.*;
import java.util.Scanner;

import com.flipkart.business.FlipFitGymCustomerBusiness;

public class FlipFitGymCustomerClient {
    public static void showGymCustomerMenu(Scanner scanner, String email) {
        int choice;
        String city = null;
        FlipFitGymCustomerInterface gymcustomer = new FlipFitGymCustomerBusiness();
        FlipFitUserInterface gymuser = new FlipFitUserBusiness();
        do {
            System.out.println("\n===== Gym Customer Menu =====");
            System.out.println("1. Select a City for Gym Centres");
            System.out.println("2. Book a Slot");
            System.out.println("3. View Booked Slots");
            System.out.println("4. Cancel Booked Slots");
            System.out.println("5. Edit Profile");
            System.out.println("6. Logout");
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(scanner.nextLine());
            
            switch (choice) {
                case 1:
                    System.out.print("Enter city: ");
                    city = scanner.nextLine();
                    gymcustomer.setPreferredCity(email, city);
                    break;
                case 2:
                	gymcustomer.listAllCentersByCity(city);
                    System.out.println("Booking a slot...");
                    gymcustomer.bookSlot(email, 101);
                    break;
                case 3:
                    gymcustomer.viewBookedSlots(email);
                    break;
                case 4:
                	gymcustomer.cancelBooking(103);
                	break;
                case 5:
                    gymuser.updateUser(email);
                    break;
                case 6:
                    gymuser.logout(email);
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
                    break;
            }
        } while (choice != 6);
    }
}
