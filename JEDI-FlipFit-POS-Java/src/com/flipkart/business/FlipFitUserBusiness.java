package com.flipkart.business;

import com.flipkart.bean.FlipFitUser;
import com.flipkart.dao.FlipFitUserDao;
import com.flipkart.dao.FlipFitUserDaoImpl;
import com.flipkart.exception.IncorrectOldPasswordException;
import com.flipkart.exception.InvalidCredentialsException;
import com.flipkart.exception.UserNotFoundException;

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

    public boolean updateUser(int userId) throws UserNotFoundException {
        if (userDao.updateUser(userId)) {
            System.out.println("User name updated !!");
            return true;
        } else {
            throw new UserNotFoundException("User not found: " + userId);  // Throw exception
        }
    }

    public boolean updatePassword(String email, String oldPassword, String newPassword) throws InvalidCredentialsException {
        if (userDao.updatePassword(email, oldPassword, newPassword)) {
            System.out.println("Password updated successfully for: " + email);
            return true;
        } else {
            throw new InvalidCredentialsException("Incorrect old password for: " + email); // Throw exception
        }
    }

    public void listAllUsers() {
        System.out.println("List of all users:");
        userDao.listAllUsers();
    }

    public FlipFitUser login(String email, String password) throws InvalidCredentialsException {
    	FlipFitUser user = userDao.login(email, password);
        if (user != null) {
            System.out.println("User logged in: " + email);
        } else {
        	throw new InvalidCredentialsException("Invalid login credentials for: " + email);
        }
        return user;
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
