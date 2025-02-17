package com.flipkart.client;
import java.util.Scanner;

import com.flipkart.bean.FlipFitUser;
import com.flipkart.business.FlipFitGymCustomerInterface;
import com.flipkart.business.FlipFitUserInterface;

public class FlipFitGymCustomerClient {
    public static void showGymCustomerMenu(Scanner scanner, FlipFitGymCustomerInterface gymCustomerBusiness, FlipFitUserInterface userBusiness, FlipFitUser user) {
        int choice;
        // String city = null;
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
                    gymCustomerBusiness.setPreferredCity(user.getId());
                    break;
                case 2:
                    System.out.println("Booking a slot...");
                    gymCustomerBusiness.bookSlot(user.getId());
                    break;
                case 3:
                	gymCustomerBusiness.viewBookedSlots(user.getId());
                    break;
                case 4:
                	gymCustomerBusiness.cancelBooking(user.getId());
                	break;
                case 5:
                    userBusiness.updateUser(user.getEmail(), user.getName(), user.getRoleId());
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
