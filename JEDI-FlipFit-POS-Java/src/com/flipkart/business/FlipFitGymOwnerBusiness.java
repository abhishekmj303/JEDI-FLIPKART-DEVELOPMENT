package com.flipkart.business;

import com.flipkart.helper.SlotGenerator;
import com.flipkart.dao.FlipFitGymOwnerDao;
import com.flipkart.dao.FlipFitGymOwnerDaoImpl;
import com.flipkart.exception.CenterCreationFailedException;
import com.flipkart.exception.InvalidCenterDetailsException;
import com.flipkart.exception.InvalidTimeFormatException;

import java.util.List;
import java.util.Scanner;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;


public class FlipFitGymOwnerBusiness implements FlipFitGymOwnerInterface {

    private final SlotGenerator slotGenerator;
    private final FlipFitGymOwnerDao gymOwnerDao;
    private final Scanner sc;

    public FlipFitGymOwnerBusiness() {
        this.slotGenerator = new SlotGenerator();
        this.gymOwnerDao = new FlipFitGymOwnerDaoImpl();
        this.sc = new Scanner(System.in); // Scanner declared globally to prevent resource leaks
    }

    public void addGymOwner(int userId) {
        System.out.println("Registering Gym Owner...");

        System.out.print("Enter Aadhaar ID: ");
        String aadhaarNo = sc.nextLine();

        System.out.print("Enter PAN Number: ");
        String pan = sc.nextLine();

        System.out.print("Enter Phone Number: ");
        String phoneNo = sc.nextLine();

        gymOwnerDao.addGymOwnerDAO(userId, aadhaarNo, pan, phoneNo);
        System.out.println("Gym Owner Registered Successfully!");
    }

    public void addCenterAndSlot(int ownerId) throws InvalidCenterDetailsException, InvalidTimeFormatException, CenterCreationFailedException {
        System.out.println("Adding a Gym Center...");

        System.out.print("Enter Gym Centre Name: ");
        String centreName = sc.nextLine();

        System.out.print("Enter Gym Centre Address: ");
        String address = sc.nextLine();

        System.out.print("Enter City: ");
        String city = sc.nextLine();

        System.out.print("Enter Number of Seats Available Per Hour: ");
        int seatsPerHour;
        try {
            seatsPerHour = Integer.parseInt(sc.nextLine());
            if (seatsPerHour <= 0) {
                throw new NumberFormatException(); // Re-use NumberFormatException for invalid input
            }
        } catch (NumberFormatException e) {
            throw new InvalidCenterDetailsException("Invalid number of seats per hour. Please enter a positive integer.");
        }


        System.out.print("Enter Morning Session Start Time (HH:MM): ");
        String startTimeMorningStr = sc.nextLine();
        LocalTime startTimeMorning = parseTime(startTimeMorningStr, "Morning Session Start");

        System.out.print("Enter Morning Session End Time (HH:MM): ");
        String endTimeMorningStr = sc.nextLine();
        LocalTime endTimeMorning = parseTime(endTimeMorningStr, "Morning Session End");

        System.out.print("Enter Evening Session Start Time (HH:MM): ");
        String startTimeEveningStr = sc.nextLine();
        LocalTime startTimeEvening = parseTime(startTimeEveningStr, "Evening Session Start");

        System.out.print("Enter Evening Session End Time (HH:MM): ");
        String endTimeEveningStr = sc.nextLine();
        LocalTime endTimeEvening = parseTime(endTimeEveningStr, "Evening Session End");

        if (endTimeMorning.isBefore(startTimeMorning) || endTimeEvening.isBefore(startTimeEvening)) {
            throw new InvalidTimeFormatException("End time cannot be before start time.");
        }

        int centerId = gymOwnerDao.addCenterDAO(ownerId, centreName, address, city, seatsPerHour,
                startTimeMorning.toString(), endTimeMorning.toString(),
                startTimeEvening.toString(), endTimeEvening.toString());

        if (centerId == -1) {
            throw new CenterCreationFailedException("Failed to add Gym Center."); // More specific exception
        }

        System.out.println("Generating Slots...");
        List<String> morningSlots = slotGenerator.generateSlots(startTimeMorning.toString(), endTimeMorning.toString());
        List<String> eveningSlots = slotGenerator.generateSlots(startTimeEvening.toString(), endTimeEvening.toString());

        System.out.println("Generated Morning Slots: " + morningSlots);
        System.out.println("Generated Evening Slots: " + eveningSlots);
        gymOwnerDao.addSlot(centerId, morningSlots, eveningSlots, seatsPerHour);
    }

    private LocalTime parseTime(String timeStr, String timeDescription) throws InvalidTimeFormatException {
        try {
            return LocalTime.parse(timeStr); // Use LocalTime.parse directly
        } catch (DateTimeParseException e) {
            throw new InvalidTimeFormatException("Invalid " + timeDescription + " format. Please use HH:MM.");
        }
    }
    
    public void viewAllCenters(int ownerId) {
        System.out.println("Listing all Gym Centers for Owner Id: " + ownerId);
        gymOwnerDao.listAllGymCentres(ownerId);
    }

    public void viewSlotsStatus() {
        System.out.println("Fetching Current Slot Status...");
        gymOwnerDao.viewSlotsStatusDAO();
    }
}
