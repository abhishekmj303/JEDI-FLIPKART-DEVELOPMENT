package com.flipkart.bean;

import java.time.LocalDateTime;

public class Booking {
    private int id;
    private int slotId;
    private int customerId;
    private LocalDateTime dateTime;

    public Booking(int id, int slotId, int customerId, LocalDateTime dateTime) {
        this.id = id;
        this.slotId = slotId;
        this.customerId = customerId;
        this.dateTime = dateTime;
    }

    public int getId() { return id; }
    public int getSlotId() { return slotId; }
    public int getCustomerId() { return customerId; }
    public LocalDateTime getDateTime() { return dateTime; }

    public void confirmBooking() { System.out.println("Booking confirmed."); }
}
