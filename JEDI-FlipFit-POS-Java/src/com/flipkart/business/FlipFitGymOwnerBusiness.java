package com.flipkart.business;

import com.flipkart.helper.SlotGenerator;
import com.flipkart.dao.FlipFitGymOwnerDao;
import com.flipkart.dao.FlipFitGymOwnerDaoImpl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class FlipFitGymOwnerBusiness implements FlipFitGymOwnerInterface {
    private static final int START_TIME_MORNING = 6;
    private static final int END_TIME_MORNING = 14;
    private static final int START_TIME_EVENING = 10;
    private static final int END_TIME_EVENING = 18;

    private final SlotGenerator slotGenerator;
    private final FlipFitGymOwnerDao gymOwnerDao;

    public FlipFitGymOwnerBusiness() {
        this.slotGenerator = new SlotGenerator();
        this.gymOwnerDao = new FlipFitGymOwnerDaoImpl();
    }

    public void addGymOwner(int userId, String aadhaarNo, String pan, String phoneNo) {
        System.out.println("Adding a gym owner with ID: " + userId);
        gymOwnerDao.addGymOwnerDAO(userId, aadhaarNo, pan, phoneNo);
    }

	public void addCenterAndSlot(String email) {
		System.out.println("Adding a gym center and slots for " + email);
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your gym centre name:");
		String centreName = sc.nextLine();
		System.out.println("Enter your gym centre location:");
		String location = sc.nextLine();
	
		int ownerId = 1;
		int centerId = gymOwnerDao.addCenterDAO(101, centreName,location);
		if (centerId == -1) {
			System.out.println("Error: Failed to add Gym Center.");
			sc.close();
			return;
		}
	
		int START_TIME_MORNING = 6;
		int END_TIME_MORNING = 14;
		int START_TIME_EVENING = 10;
		int END_TIME_EVENING = 18;
	
		Date morningStartTime = convertToTime(START_TIME_MORNING);
		Date morningEndTime = convertToTime(END_TIME_MORNING);
		Date eveningStartTime = convertToTime(START_TIME_EVENING);
		Date eveningEndTime = convertToTime(END_TIME_EVENING);
	
		System.out.println("Generating Slots...");
		List<String> morningSlots = slotGenerator.generateSlots(morningStartTime, morningEndTime);
		List<String> eveningSlots = slotGenerator.generateSlots(eveningStartTime, eveningEndTime);
	
		System.out.println("Generated Morning Slots: " + morningSlots);
		System.out.println("Generated Evening Slots: " + eveningSlots);
		gymOwnerDao.addSlot(centerId, morningSlots, eveningSlots);
		
		sc.close();
	}
	
    public void viewSlotsStatus() {
        System.out.println("Current Slot Status...");
        gymOwnerDao.viewSlotsStatusDAO();
    }

    private Date convertToTime(int hour) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }
}

