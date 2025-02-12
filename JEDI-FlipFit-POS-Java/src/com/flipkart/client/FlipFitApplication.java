package com.flipkart.client;

import java.util.Scanner;

public class FlipFitApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int mainChoice;
        
        do {
            printMainMenu();
            mainChoice = Integer.parseInt(scanner.nextLine());
            
            switch (mainChoice) {
                case 1:
                    // Login
                    handleLogin(scanner);
                    break;
                
                case 2:
                    // Registration of the gym customer
                    registerGymCustomer(scanner);
                    break;
                
                case 3:
                    // Registration of the gym owner
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
        System.out.println("Enter the choice:");
        System.out.println("1. Login");
        System.out.println("2. Registration of the Gym Customer");
        System.out.println("3. Registration of the Gym Owner");
        System.out.println("4. Change Password");
        System.out.println("5. Exit");
        System.out.print("Your choice: ");
    }

    /**
     * Handles user login and routes to the appropriate menu based on role.
     */
    private static void handleLogin(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        
        System.out.print("Enter role (gym customer, gym owner, gym admin): ");
        String role = scanner.nextLine().trim().toLowerCase();

        // You would typically validate the username, password, and role
        // with your service/business logic here. For now, we assume it’s correct.
        
        switch (role) {
            case "gym owner":
                showGymOwnerMenu(scanner, username);
                break;
            case "gym customer":
                showGymCustomerMenu(scanner, username);
                break;
            case "gym admin":
                showGymAdminMenu(scanner, username);
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

        // Additional info like city preference can be asked here.
        
        // Call your service layer to register the customer, e.g.:
        // UserService.registerCustomer(name, email, password);
        
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

        // Additional info related to gym center can be asked here.
        
        // Call your service layer to register the owner, e.g.:
        // UserService.registerOwner(name, email, password);
        
        System.out.println("Gym Owner registered successfully!");
    }

    /**
     * Allows user to change password.
     */
    private static void changePassword(Scanner scanner) {
        System.out.println("===== Change Password =====");
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        
        System.out.print("Enter old password: ");
        String oldPassword = scanner.nextLine();
        
        System.out.print("Enter new password: ");
        String newPassword = scanner.nextLine();

        // Validate old password, then update with new password in your service layer.
        
        System.out.println("Password changed successfully!");
    }

    /**
     * Sub-menu for Gym Owner after login.
     */
    private static void showGymOwnerMenu(Scanner scanner, String username) {
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
                    // Add Gym Center logic
                    System.out.println("Adding a new gym center...");
                    // e.g. GymService.addCenter(ownerId, centerDetails);

					// Add Slots logic
                    System.out.println("Adding slots to a center...");
                    // e.g. GymService.addSlots(centerId, slotDetails);
                    break;
                case 2:
                    // View My Centers logic
                    System.out.println("Viewing your gym centers...");
                    // e.g. GymService.viewMyCenters(ownerId);
                    break;
                case 3:
                    System.out.println("Logging out...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 3);
    }

    /**
     * Sub-menu for Gym Customer after login.
     */
    private static void showGymCustomerMenu(Scanner scanner, String username) {
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
                    // View Centers by City
                    System.out.println("Enter city: ");
                    String city = scanner.nextLine();
                    // e.g. GymService.viewCentersByCity(city);
                    break;
                case 2:
                    // Book a Slot
                    System.out.println("Booking a slot...");
                    // e.g. BookingService.bookSlot(customerId, centerId, slotId);
					// Make Payment
                    System.out.println("Proceed to payment...");
                    // e.g. PaymentService.processPayment(bookingId, amount, method);
                    break;
                case 3:
                    // View Booked Slots
                    System.out.println("Viewing booked slots...");
                    // e.g. BookingService.viewBookings(customerId);
                    break;
                case 4:
                    System.out.println("Logging out...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 4);
    }

    /**
     * Sub-menu for Gym Admin (Flipkart Admin) after login.
     */
    private static void showGymAdminMenu(Scanner scanner, String username) {
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
                    // Approve Gym Centers
                    System.out.println("Approving gym centers...");
                    // e.g. AdminService.approveCenter(centerId);
                    break;
                case 2:
                    // View All Gym Centers
                    System.out.println("Listing all gym centers...");
                    // e.g. AdminService.viewAllCenters();
                    break;
                case 3:
                    System.out.println("Logging out...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 3);
    }
}
