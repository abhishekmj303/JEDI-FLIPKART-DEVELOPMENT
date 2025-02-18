package com.flipkart.client;

import java.time.LocalDateTime;
import java.util.Scanner;

import com.flipkart.bean.FlipFitUser;
import com.flipkart.business.FlipFitGymAdminBusiness;
import com.flipkart.business.FlipFitGymAdminInterface;
import com.flipkart.business.FlipFitGymCustomerBusiness;
import com.flipkart.business.FlipFitGymCustomerInterface;
import com.flipkart.business.FlipFitGymOwnerBusiness;
import com.flipkart.business.FlipFitGymOwnerInterface;
import com.flipkart.business.FlipFitUserBusiness;
import com.flipkart.business.FlipFitUserInterface;
import com.flipkart.exception.InvalidCredentialsException;

public class FlipFitApplication {

    public static void main(String[] args) {
   
    	FlipFitUserInterface userBusiness = new FlipFitUserBusiness();
    	FlipFitGymAdminInterface adminBusiness = new FlipFitGymAdminBusiness();
    	FlipFitGymCustomerInterface gymCustomerBusiness = new FlipFitGymCustomerBusiness();
    	FlipFitGymOwnerInterface gymOwnerBusiness = new FlipFitGymOwnerBusiness();
    	
        Scanner scanner = new Scanner(System.in);
        int mainChoice;
        
        do {
            printMainMenu();
            mainChoice = Integer.parseInt(scanner.nextLine());
            
            switch (mainChoice) {
                case 1:
                    // Login: delegate to the respective client based on role.
                    handleLogin(scanner, userBusiness, adminBusiness, gymCustomerBusiness, gymOwnerBusiness);
                    break;
                
                case 2:
                    // Registration for gym customer
                    registerGymCustomer(scanner, userBusiness, gymCustomerBusiness);
                    break;
                
                case 3:
                    // Registration for gym owner
                    registerGymOwner(scanner, userBusiness, gymOwnerBusiness);
                    break;
                
                case 4:
                    // Change password
                    changePassword(scanner, userBusiness);
                    break;
                
                case 5:
                    // Exit
                    System.out.println("Exiting the application. Thank you for using FlipFit!");
                    break;
                
                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
                    break;
            }
        } while (mainChoice != 5);

        scanner.close();
    }

    /**
     * Prints the main menu options.
     */
    private static void printMainMenu() {
        System.out.println("====================================");
        System.out.println("      Welcome to FlipFit App");
        System.out.println("====================================");
        System.out.println("Enter your choice:");
        System.out.println("1. Login");
        System.out.println("2. Registration of the Gym Customer");
        System.out.println("3. Registration of the Gym Owner");
        System.out.println("4. Change Password");
        System.out.println("5. Exit");
        System.out.print("Your choice: ");
    }

    /**
     * Handles user login and routes to the appropriate client menu based on role.
     */
    private static void handleLogin(Scanner scanner, FlipFitUserInterface userBusiness, FlipFitGymAdminInterface adminBusiness, FlipFitGymCustomerInterface gymCustomerBusiness, FlipFitGymOwnerInterface gymOwnerBusiness) {
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        
        FlipFitUser user = null;
		try {
			user = userBusiness.login(email, password);
		} catch (InvalidCredentialsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        if (user == null) {
        	return;
        }
        
        System.out.println("User " + email + " Logged in at " + LocalDateTime.now());

        // In a real application, you would validate email, password, and role.
        // Here we assume they are correct and simply delegate to the respective menu.
        switch (user.getRoleId()) {
            case 2:
                FlipFitGymOwnerClient.showGymOwnerMenu(scanner, gymOwnerBusiness, userBusiness, user);
                break;
            case 3:
                FlipFitGymCustomerClient.showGymCustomerMenu(scanner, gymCustomerBusiness, userBusiness, user);
                break;
            case 1:
                FlipFitGymAdminClient.showGymAdminMenu(scanner, adminBusiness, userBusiness, user);
                break;
            default:
                System.out.println("Invalid role! Returning to main menu.");
                break;
        }
    }

    /**
     * Registration for gym customer.
     */
    private static void registerGymCustomer(Scanner scanner, FlipFitUserInterface userBusiness, FlipFitGymCustomerInterface gymCustomerBusiness) {
        System.out.println("===== Register Gym Customer =====");
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        
        System.out.print("Enter desired password: ");
        String password = scanner.nextLine();

        int userId = userBusiness.addUser(name, email, password, 3);
        gymCustomerBusiness.addGymCustomer(userId);
        
        System.out.println("Gym Customer registered successfully!");
    }

    /**
     * Registration for gym owner.
     */
    private static void registerGymOwner(Scanner scanner, FlipFitUserInterface userBusiness, FlipFitGymOwnerInterface gymOwnerBusiness) {
        System.out.println("===== Register Gym Owner =====");
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        
        System.out.print("Enter desired password: ");
        String password = scanner.nextLine();

        int userId = userBusiness.addUser(name, email, password, 2);
        gymOwnerBusiness.addGymOwner(userId);
    }

    /**
     * Allows user to change their password.
     */
    private static void changePassword(Scanner scanner, FlipFitUserInterface userBusiness) {
        System.out.println("===== Change Password =====");
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();
        
        System.out.print("Enter old password: ");
        String oldPassword = scanner.nextLine();
        
        System.out.print("Enter new password: ");
        String newPassword = scanner.nextLine();

        try {
			userBusiness.updatePassword(email, oldPassword, newPassword);
		} catch (InvalidCredentialsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}