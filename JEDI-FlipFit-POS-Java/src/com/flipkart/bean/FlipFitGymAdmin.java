package com.flipkart.bean;

public class FlipFitGymAdmin extends FlipFitUser {
    public FlipFitGymAdmin(int id, String name, String email, String password) {
        super(id, name, email, password, "ADMIN");
    }
}
