package com.flipkart.helper;

import java.text.SimpleDateFormat;
import java.util.*;

public class SlotGenerator {
    private int slotDuration = 60; 
    public int getSlotDuration() {
        return slotDuration;
    }
    public void setSlotDuration(int slotDuration) {
        this.slotDuration = slotDuration;
    }

    public List<String> generateSlots(Date startTime, Date endTime) {
        List<String> slots = new ArrayList<>();
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startTime);

        while (calendar.getTime().before(endTime)) {
            Date slotStart = calendar.getTime();
            calendar.add(Calendar.MINUTE, slotDuration);
            Date slotEnd = calendar.getTime();

            if (slotEnd.after(endTime)) break;

            String slot = timeFormat.format(slotStart) + " - " + timeFormat.format(slotEnd);
            slots.add(slot);
        }

        return slots;
    }
}
