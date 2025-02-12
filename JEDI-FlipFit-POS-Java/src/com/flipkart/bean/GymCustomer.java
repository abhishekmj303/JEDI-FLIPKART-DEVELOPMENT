package com.flipkart.bean;

public class GymCustomer extends User {
    private String preferredCity;

    public GymCustomer(int id, String name, String email, String password, String preferredCity) {
        super(id, name, email, password, "CUSTOMER");
        this.preferredCity = preferredCity;
    }

    public String getPreferredCity() { return preferredCity; }
    public void setPreferredCity(String preferredCity) { this.preferredCity = preferredCity; }

    public void bookSlot() {
    	System.out.println("Booking a slot..."); 
    }
    public void cancelBooking() {
    	System.out.println("Canceling booking...");
    }
}
