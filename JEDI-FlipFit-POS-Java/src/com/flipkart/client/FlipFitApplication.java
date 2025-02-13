package com.flipkart.client;

import java.util.Scanner;

import com.flipkart.business.FlipFitUserBusiness;
import com.flipkart.business.FlipFitUserInterface;

public class FlipFitApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int mainChoice;
        
        do {
            printMainMenu();
            mainChoice = Integer.parseInt(scanner.nextLine());
            
            switch (mainChoice) {
                case 1:
                    // Login: delegate to the respective client based on role.
                    handleLogin(scanner);
                    break;
                
                case 2:
                    // Registration for gym customer
                    registerGymCustomer(scanner);
                    break;
                
                case 3:
                    // Registration for gym owner
                    registerGymOwner(scanner);
                    break;
                
                case 4:
                    // Change password
                    changePassword(scanner);
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
    private static void handleLogin(Scanner scanner) {
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        
        System.out.print("Enter role (gym customer, gym owner, gym admin): ");
        String role = scanner.nextLine().trim().toLowerCase();
        
    	FlipFitUserInterface user = new FlipFitUserBusiness();
        user.login(email, password, role);

        // In a real application, you would validate email, password, and role.
        // Here we assume they are correct and simply delegate to the respective menu.
        switch (role) {
            case "gym owner":
                FlipFitGymOwnerClient.showGymOwnerMenu(scanner, email);
                break;
            case "gym customer":
                FlipFitGymCustomerClient.showGymCustomerMenu(scanner, email);
                break;
            case "gym admin":
                FlipFitGymAdminClient.showGymAdminMenu(scanner, email);
                break;
            default:
                System.out.println("Invalid role! Returning to main menu.");
                break;
        }
    }

    /**
     * Registration for gym customer.
     */
    private static void registerGymCustomer(Scanner scanner) {
        System.out.println("===== Register Gym Customer =====");
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        
        System.out.print("Enter desired password: ");
        String password = scanner.nextLine();

        FlipFitUserInterface user = new FlipFitUserBusiness();
        user.addUser(name, email, password, "gym customer");
        
        System.out.println("Gym Customer registered successfully!");
    }

    /**
     * Registration for gym owner.
     */
    private static void registerGymOwner(Scanner scanner) {
        System.out.println("===== Register Gym Owner =====");
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        
        System.out.print("Enter desired password: ");
        String password = scanner.nextLine();

        FlipFitUserInterface user = new FlipFitUserBusiness();
        user.addUser(name, email, password, "gym owner");
        
        System.out.println("Gym Owner registered successfully!");
    }

    /**
     * Allows user to change their password.
     */
    private static void changePassword(Scanner scanner) {
        System.out.println("===== Change Password =====");
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();
        
        System.out.print("Enter old password: ");
        String oldPassword = scanner.nextLine();
        
        System.out.print("Enter new password: ");
        String newPassword = scanner.nextLine();

        FlipFitUserInterface user = new FlipFitUserBusiness();
        user.updatePassword(email, newPassword);
        
        System.out.println("Password changed successfully!");
    }
}
