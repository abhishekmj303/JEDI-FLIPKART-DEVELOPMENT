package com.flipkart.bean;

public class GymOwner extends User {
    public GymOwner(int id, String name, String email, String password) {
        super(id, name, email, password, "GYM_OWNER");
    }

    public void addCenterAndSlot() {
        System.out.println("Adding a gym center and slots...");
    }
}
