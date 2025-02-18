package com.flipkart.business;

import com.flipkart.bean.FlipFitGymCenter;
import com.flipkart.bean.FlipFitGymCustomer;
import com.flipkart.bean.FlipFitNotification;
import com.flipkart.bean.FlipFitPayment;
import com.flipkart.bean.FlipFitSlot;
import com.flipkart.bean.FlipFitSlotBooking;
import com.flipkart.dao.FlipFitGymCustomerDao;
import com.flipkart.dao.FlipFitGymCustomerDaoImpl;
import com.flipkart.exception.BookingFailedException;
import com.flipkart.exception.BookingNotFoundException;
import com.flipkart.exception.GymCenterNotFoundException;
import com.flipkart.exception.NoAvailableSeatsException;
import com.flipkart.exception.PaymentFailedException;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.*;

public class FlipFitGymCustomerBusiness implements FlipFitGymCustomerInterface {
    
    private FlipFitGymCustomerDao gymCustomerDao;

    public FlipFitGymCustomerBusiness() {
        this.gymCustomerDao = new FlipFitGymCustomerDaoImpl();
    }

    // 1. Add a Gym Customer
    public void addGymCustomer(int userId) {
        FlipFitGymCustomer customer = new FlipFitGymCustomer(userId);
        gymCustomerDao.addGymCustomer(customer);
    }

    // 2. Set Preferred City
    public void setPreferredCity(int userId) {
        List<String> cities = gymCustomerDao.getAllCities();
        if (cities.isEmpty()) {
            System.out.println("No cities available.");
            return;
        }
        System.out.println("Available Cities:");
        for (int i = 0; i < cities.size(); i++) {
            System.out.println((i + 1) + ". " + cities.get(i));
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number corresponding to your preferred city: ");
        int choice;
        while (true) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice < 1 || choice > cities.size()) {
                    System.out.print("Invalid choice. Please select a valid city number: ");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number: ");
            }
        }
    
        String selectedCity = cities.get(choice - 1);
        gymCustomerDao.setPreferredCity(userId, selectedCity);
        System.out.println("Preferred city set to: " + selectedCity);
    }

    // 3. Book a Slot
    public void bookSlot(int userId) throws GymCenterNotFoundException, NoAvailableSeatsException, BookingFailedException, PaymentFailedException {
        List<FlipFitGymCenter> centers = gymCustomerDao.listAllCentersByCity(userId);

        if (centers.isEmpty()) {
            throw new GymCenterNotFoundException("No gym centers available for your preferred city.");
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Available Gym Centers:");
        for (int i = 0; i < centers.size(); i++) {
            System.out.println((i + 1) + ". " + centers.get(i).getName() + ", " + centers.get(i).getAddress());
        }
        System.out.print("Please enter the number corresponding to the center you want to book:");

        int choice = getValidIntegerInput(scanner, 1, centers.size(), "Invalid center selection.");

        FlipFitGymCenter selectedCenter = centers.get(choice - 1);
        System.out.println("You selected: " + selectedCenter.getName() + ", " + selectedCenter.getAddress());

        List<FlipFitSlot> slots = gymCustomerDao.viewAvailableSlots(selectedCenter.getId());

        if (slots.isEmpty()) {
            throw new NoAvailableSeatsException("No slots available for this gym center.");
        }

        System.out.println("Available Slots:");
        for (int i = 0; i < slots.size(); i++) {
            System.out.println((i + 1) + ". " + slots.get(i).getSlotInfo() + " - " + slots.get(i).getAvailableSeats() + " seats available");
        }

        System.out.print("Please enter the number corresponding to the slot you want to book:");
        choice = getValidIntegerInput(scanner, 1, slots.size(), "Invalid slot selection.");

        FlipFitSlot selectedSlot = slots.get(choice - 1);
        int slotId = selectedSlot.getId();

        if (selectedSlot.getAvailableSeats() <= 0) {
            throw new NoAvailableSeatsException("No available seats in the selected slot");
        }

        FlipFitSlotBooking booking = new FlipFitSlotBooking(selectedCenter.getId(), slotId, userId, LocalDate.now());
        int bookingId = gymCustomerDao.bookSlot(booking);

        if (bookingId == -1) {
            throw new BookingFailedException("Booking failed for slot " + slotId);
        }

        gymCustomerDao.updateAvailableSeats(slotId, selectedSlot.getAvailableSeats() - 1);

        System.out.println("Proceeding to payment...");
        processPayment(userId, bookingId, 1000); // Or get the amount dynamically

        if (getPaymentStatus(1).equals("Completed")) { // Assuming payment ID is 1 for now
            sendNotification(userId, "Booking confirmed for slot " + slotId);
        } else {
            sendNotification(userId, "Payment not successful for booking of slot " + slotId);
            throw new PaymentFailedException("Payment not successful for booking of slot " + slotId);
        }
    }
    
    private int getValidIntegerInput(Scanner scanner, int min, int max, String errorMessage) {
        int choice;
        while (true) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice < min || choice > max) {
                    System.out.println(errorMessage);
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number:");
            }
        }
        return choice;
    }


    // 4. Cancel a Booking
    public boolean cancelBooking(int userId) throws BookingNotFoundException {
        List<FlipFitSlotBooking> bookings = gymCustomerDao.viewBookedSlots(userId);
        if (bookings.isEmpty()) {
            throw new BookingNotFoundException("No bookings found for user " + userId);
        }
        for (int i = 0; i < bookings.size(); i++) {
            System.out.println((i + 1) + ". " + bookings.get(i).getId() + " - Slot " + bookings.get(i).getSlotId() + " on " + bookings.get(i).getDate());
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number corresponding to the booking ID for canceling:");
        int choice = getValidIntegerInput(sc, 1, bookings.size(), "Invalid booking selection.");
        int bookingId = bookings.get(choice - 1).getId();

        boolean success = gymCustomerDao.cancelBooking(bookingId);
        if (success) {
            refundPayment(bookingId);
            sendNotification(userId, "Booking cancelled for booking ID " + bookingId);
        } else {
            throw new BookingNotFoundException("Booking with ID " + bookingId + " not found or could not be cancelled.");
        }

        return success;
    }

    // 5. List All Gym Centers by City
    public void listAllCentersByCity(int userId) {
        gymCustomerDao.listAllCentersByCity(userId);
    }

    // 6. View Available Slots for a Gym Center
    public void viewAvailableSlots(int gymCenterId) {
        gymCustomerDao.viewAvailableSlots(gymCenterId);
    }

    // 7. View Booked Slots for a User
    public void viewBookedSlots(int userId) {
        gymCustomerDao.viewBookedSlots(userId);
    }

    // 8. Process Payment
    public void processPayment(int customerId, int bookingId, double amount) {
        FlipFitPayment payment = new FlipFitPayment(1, customerId, bookingId, amount, "Completed", "CreditCard", LocalDateTime.now());
        gymCustomerDao.processPayment(payment);
    }

    // 9. Refund Payment
    public boolean refundPayment(int paymentId) {
        return gymCustomerDao.refundPayment(paymentId);
    }

    // 10. Get Payment Status
    public String getPaymentStatus(int paymentId) {
        return gymCustomerDao.getPaymentStatus(paymentId);
    }

    // 11. Send Notification
    public void sendNotification(int customerId, String notificationMessage) {
        FlipFitNotification notification = new FlipFitNotification(1, customerId, notificationMessage,LocalDateTime.now() , false);
        gymCustomerDao.sendNotification(notification);
    }

    public void listAllCentersByCity(String city) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listAllCentersByCity'");
    }
}
