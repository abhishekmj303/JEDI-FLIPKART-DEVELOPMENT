package com.flipkart.client;

import java.util.Scanner;

import com.flipkart.bean.FlipFitUser;
import com.flipkart.business.FlipFitGymOwnerInterface;
import com.flipkart.business.FlipFitUserInterface;

public class FlipFitGymOwnerClient {
    public static void showGymOwnerMenu(Scanner scanner, FlipFitGymOwnerInterface gymOwnerBusiness, FlipFitUserInterface userBusiness, FlipFitUser user) {
        int choice;
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
                    gymOwnerBusiness.addCenterAndSlot(user.getId());
                    break;
                case 2:
                    gymOwnerBusiness.viewSlotsStatus();
                    break;
                case 3:
                	userBusiness.updateUser(user.getEmail(), user.getName(), user.getRoleId());
                	break;
                case 4:
                    userBusiness.logout(user.getEmail());
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
                    break;
            }
        } while (choice != 4);
    }
}
