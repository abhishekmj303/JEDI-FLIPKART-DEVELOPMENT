package com.flipkart.bean;

public class GymCenter {
    private int id;
    private String name;
    private String city;
    private int seats;
    private boolean isApproved;

    public GymCenter(int id, String name, String city, int seats, boolean isApproved) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.seats = seats;
        this.isApproved = isApproved;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getCity() { return city; }
    public int getSeats() { return seats; }
    public boolean isApproved() { return isApproved; }

    public void setApproved(boolean approved) { isApproved = approved; }
}
