/**
 * FlipFitUserBusiness - Handles user management operations.
 */
package com.flipkart.business;

import java.util.HashMap;
import java.util.Map;
import com.flipkart.bean.FlipFitUser;

public class FlipFitUserBusiness implements FlipFitUserInterface {
    private HashMap<Integer, FlipFitUser> users;
    private int userId; 


    public int addUser(String name, String email, String password, int roleId) {
        FlipFitUser newUser = new FlipFitUser(userId, name, email, password, roleId);
        users.put(userId, newUser);
        System.out.println("User added: " + email + " with ID: " + userId);
        return userId++;
    }

    public boolean updateUser(String email, String name, int roleId) {
        for (Map.Entry<Integer, FlipFitUser> entry : users.entrySet()) {
            FlipFitUser user = entry.getValue();
            if (user.getEmail().equals(email)) {
                user.setName(name);
                user.setRoleId(roleId);
                users.put(entry.getKey(), user); // Update HashMap
                System.out.println("User updated: " + email);
                return true;
            }
        }
        System.out.println("User not found: " + email);
        return false;
    }

    public boolean updatePassword(String email, String password) {
        for (Map.Entry<Integer, FlipFitUser> entry : users.entrySet()) {
            FlipFitUser user = entry.getValue();
            if (user.getEmail().equals(email)) {
                user.setPassword(password);
                users.put(entry.getKey(), user); // Update HashMap
                System.out.println("Password updated for: " + email);
                return true;
            }
        }
        System.out.println("User not found: " + email);
        return false;
    }

    public void listAllUsers() {
        System.out.println("List of all users:");
        for (FlipFitUser user : users.values()) {
            System.out.println(user);
        }
    }

    public boolean login(String email, String password) {
        for (FlipFitUser user : users.values()) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                System.out.println("User logged in: " + email);
                return true;
            }
        }
        System.out.println("Invalid login credentials for: " + email);
        return false;
    }

    public boolean logout(String email) {
        System.out.println("User logged out: " + email);
        return true;
    }

    public String generateToken(int userId) {
        String token = "token_" + userId;
        System.out.println("Generated token: " + token);
        return token;
    }

    public boolean validateToken(String token) {
        System.out.println("Validating token: " + token);
        return token.startsWith("token_");
    }
}
