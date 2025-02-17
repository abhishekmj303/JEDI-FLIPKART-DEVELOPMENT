package com.flipkart.business;

import com.flipkart.helper.SlotGenerator;
import com.flipkart.dao.FlipFitGymOwnerDao;
import com.flipkart.dao.FlipFitGymOwnerDaoImpl;

import java.util.List;
import java.util.Scanner;

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

    public void addCenterAndSlot(int ownerId) {
        System.out.println("Adding a Gym Center...");

        System.out.print("Enter Gym Centre Name: ");
        String centreName = sc.nextLine();

        System.out.print("Enter Gym Centre Address: ");
        String address = sc.nextLine();

        System.out.print("Enter City: ");
        String city = sc.nextLine();

        System.out.print("Enter Number of Seats Available Per Hour: ");
        int seatsPerHour = Integer.parseInt(sc.nextLine());

        // Taking input for start & end times
        System.out.print("Enter Morning Session Start Time (HH:MM): ");
        String startTimeMorning = sc.nextLine() + " AM";

        System.out.print("Enter Morning Session End Time (HH:MM): ");
        String endTimeMorning = sc.nextLine() + " AM";

        System.out.print("Enter Evening Session Start Time (HH:MM): ");
        String startTimeEvening = sc.nextLine() + " PM";

        System.out.print("Enter Evening Session End Time (HH:MM): ");
        String endTimeEvening = sc.nextLine() + " PM";

        int centerId = gymOwnerDao.addCenterDAO(ownerId, centreName, address, city, seatsPerHour, startTimeMorning, endTimeMorning, startTimeEvening, endTimeEvening);

        if (centerId == -1) {
            System.out.println("Error: Failed to add Gym Center.");
            return;
        }

        System.out.println("Generating Slots...");
        List<String> morningSlots = slotGenerator.generateSlots(startTimeMorning, endTimeMorning);
        List<String> eveningSlots = slotGenerator.generateSlots(startTimeEvening, endTimeEvening);

        System.out.println("Generated Morning Slots: " + morningSlots);
        System.out.println("Generated Evening Slots: " + eveningSlots);
        gymOwnerDao.addSlot(centerId, morningSlots, eveningSlots, seatsPerHour);
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
