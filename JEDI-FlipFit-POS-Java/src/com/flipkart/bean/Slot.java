package com.flipkart.bean;

public class Slot {
    private int id;
    private int centerId;
    private String slotInfo;
    private int availableSeats;

    public Slot(int id, int centerId, String slotInfo, int availableSeats) {
        this.id = id;
        this.centerId = centerId;
        this.slotInfo = slotInfo;
        this.availableSeats = availableSeats;
    }

    public int getId() { return id; }
    public int getCenterId() { return centerId; }
    public String getSlotInfo() { return slotInfo; }
    public int getAvailableSeats() { return availableSeats; }

    public void bookSlot() {
        if (availableSeats > 0) {
            availableSeats--;
            System.out.println("Slot booked successfully.");
        } else {
            System.out.println("No seats available.");
        }
    }
}
