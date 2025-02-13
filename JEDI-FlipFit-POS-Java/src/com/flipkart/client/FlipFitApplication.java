package com.flipkart.client;
import com.flipkart.bean.GymOwner;
import com.flipkart.business.GymOwnerBusiness;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class FlipFitApplication {
    private static GymOwnerBusiness gymOwnerBusiness = new GymOwnerBusiness();
    
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
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        
        System.out.print("Enter role (gym customer, gym owner, gym admin): ");
        String role = scanner.nextLine().trim().toLowerCase();

        // In a real application, you would validate username, password, and role.
        // Here we assume they are correct and simply delegate to the respective menu.
        switch (role) {
            case "gym owner":
                GymOwnerClient.showGymOwnerMenu(scanner, username);
                break;
            case "gym customer":
                CustomerClient.showGymCustomerMenu(scanner, username);
                break;
            case "gym admin":
                AdminClient.showGymAdminMenu(scanner, username);
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

        // TODO: Call your service layer to register the customer.
        
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

        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

        System.out.print("Enter your gym morning start time (HH:mm): ");
        Date morningStartTime = parseTime(scanner, timeFormat);

        System.out.print("Enter your gym morning end time (HH:mm): ");
        Date morningEndTime = parseTime(scanner, timeFormat);

        System.out.print("Enter your gym evening start time (HH:mm): ");
        Date eveningStartTime = parseTime(scanner, timeFormat);

        System.out.print("Enter your gym evening end time (HH:mm): ");
        Date eveningEndTime = parseTime(scanner, timeFormat);

        GymOwner gymOwner = new GymOwner(1, name, email, password, 
                                         morningStartTime, morningEndTime, 
                                         eveningStartTime, eveningEndTime);
        gymOwnerBusiness.registerGymOwner(gymOwner);                                 
        System.out.println("Gym Owner registered successfully!");
    }
    private static Date parseTime(Scanner scanner, SimpleDateFormat timeFormat) {
        while (true) {
            try {
                String input = scanner.nextLine();
                return timeFormat.parse(input);
            } catch (ParseException e) {
                System.out.print("❌ Invalid time format! Please enter in HH:mm format: ");
            }
        }
    }
    /**
     * Allows user to change their password.
     */
    private static void changePassword(Scanner scanner) {
        System.out.println("===== Change Password =====");
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        
        System.out.print("Enter old password: ");
        String oldPassword = scanner.nextLine();
        
        System.out.print("Enter new password: ");
        String newPassword = scanner.nextLine();

        // TODO: Validate and update password via your service layer.
        
        System.out.println("Password changed successfully!");
    }
}
