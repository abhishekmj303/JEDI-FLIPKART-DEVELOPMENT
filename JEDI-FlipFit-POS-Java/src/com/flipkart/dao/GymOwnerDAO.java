package com.flipkart.dao;

import com.flipkart.bean.GymOwner;
import com.flipkart.helper.SlotGenerator;
import java.util.List;

public class GymOwnerDAO {
    private SlotGenerator slotGenerator = new SlotGenerator();

    public void registerGymOwner(GymOwner gymOwner) {
        System.out.println("Registering gym owner: " + gymOwner.getName());

        List<String> morningSlots = slotGenerator.generateSlots(
            gymOwner.getMorningStartTime(),
            gymOwner.getMorningEndTime()
        );
        System.out.println("Generated Morning Slots: " + morningSlots);

        List<String> eveningSlots = slotGenerator.generateSlots(
            gymOwner.getEveningStartTime(),
            gymOwner.getEveningEndTime()
        );
        System.out.println("Generated Evening Slots: " + eveningSlots);
    }
}
