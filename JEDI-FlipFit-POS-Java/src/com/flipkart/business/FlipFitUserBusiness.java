package com.flipkart.business;

import com.flipkart.bean.FlipFitUser;
import com.flipkart.dao.FlipFitUserDao;
import com.flipkart.dao.FlipFitUserDaoImpl;

public class FlipFitUserBusiness implements FlipFitUserInterface {
    private FlipFitUserDao userDao;

    public FlipFitUserBusiness() {
        this.userDao = new FlipFitUserDaoImpl();
    }

    public int addUser(String name, String email, String password, int roleId) {
        FlipFitUser newUser = new FlipFitUser(0, name, email, password, roleId);
        int userId = userDao.addUser(newUser);
        if (userId != -1) {
            System.out.println("User added: " + email + " with ID: " + userId);
        } else {
            System.out.println("Failed to add user: " + email);
        }
        return userId;
    }

    public boolean updateUser(String email, String name, int roleId) {
        if (userDao.updateUser(email, name, roleId)) {
            System.out.println("User updated: " + email);
            return true;
        }
        System.out.println("User not found: " + email);
        return false;
    }

    public boolean updatePassword(String email, String oldPassword, String newPassword) {
        if (userDao.updatePassword(email, oldPassword, newPassword)) {
            System.out.println("Password updated successfully for: " + email);
            return true;
        }
        System.out.println("Incorrect old password or user not found: " + email);
        return false;
    }

    public void listAllUsers() {
        System.out.println("List of all users:");
        userDao.listAllUsers();
    }

    public boolean login(String email, String password) {
        if (userDao.login(email, password)) {
            System.out.println("User logged in: " + email);
            return true;
        }
        System.out.println("Invalid login credentials for: " + email);
        return false;
    }

    public boolean logout(String email) {
        System.out.println("User logged out: " + email);
        return true;
    }

    public String generateToken(int userId) {
        return userDao.generateToken(userId);
    }

    public boolean validateToken(String token) {
        return userDao.validateToken(token);
    }
}
