package com.flipkart.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class SlotGenerator {
    private int slotDuration = 60; // Default slot duration in minutes

    public int getSlotDuration() {
        return slotDuration;
    }

    public void setSlotDuration(int slotDuration) {
        this.slotDuration = slotDuration;
    }

    public List<String> generateSlots(String startTime, String endTime) {
        List<String> slots = new ArrayList<>();
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a");

        try {
            Date start = timeFormat.parse(startTime);
            Date end = timeFormat.parse(endTime);

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(start);

            while (calendar.getTime().before(end)) {
                Date slotStart = calendar.getTime();
                calendar.add(Calendar.MINUTE, slotDuration);
                Date slotEnd = calendar.getTime();
                
                if (slotEnd.after(end)) break;

                String slot = timeFormat.format(slotStart) + " - " + timeFormat.format(slotEnd);
                slots.add(slot);
            }
        } catch (ParseException e) {
            System.out.println("Error: Invalid time format. Please enter time in HH:MM format.");
            e.printStackTrace();
        }
        return slots;
    }
}
