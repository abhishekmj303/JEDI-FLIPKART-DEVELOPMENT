package com.flipkart.business;

import com.flipkart.bean.FlipFitUser;
import com.flipkart.exception.IncorrectOldPasswordException;
import com.flipkart.exception.InvalidCredentialsException;
import com.flipkart.exception.UserNotFoundException;

/**
 * Interface for managing user-related operations in the FlipFit gym system.
 * This interface defines methods for adding, updating, and logging in users, 
 * managing passwords, generating and validating authentication tokens, and listing all users.
 */
public interface FlipFitUserInterface {

    /**
     * Adds a new user to the system.
     * 
     * @param name The name of the user.
     * @param email The email address of the user.
     * @param password The password for the user.
     * @param roleId The role ID that defines the user's role (e.g., customer, admin).
     * @return The ID of the newly added user.
     */
    public int addUser(String name, String email, String password, int roleId);

    /**
     * Updates an existing user's details.
     * 
     * @param userId The ID of the user to be updated.
     * @return true if the user was successfully updated, false otherwise.
     * @throws UserNotFoundException 
     */
    public boolean updateUser(int userId) throws UserNotFoundException;

    /**
     * Updates the password for a user.
     * 
     * @param email The email of the user.
     * @param oldPassword The current password of the user.
     * @param newPassword The new password to be set for the user.
     * @return true if the password was successfully updated, false otherwise.
     * @throws InvalidCredentialsException 
     */
    public boolean updatePassword(String email, String oldPassword, String newPassword) throws InvalidCredentialsException;

    /**
     * Lists all users in the system.
     */
    public void listAllUsers();

    /**
     * Logs in a user by validating their email and password.
     * 
     * @param email The email of the user.
     * @param password The password of the user.
     * @return The user object if login is successful, null otherwise.
     * @throws InvalidCredentialsException 
     */
    public FlipFitUser login(String email, String password) throws InvalidCredentialsException;

    /**
     * Logs out a user.
     * 
     * @param email The email of the user logging out.
     * @return true if the user was successfully logged out, false otherwise.
     */
    public boolean logout(String email);

    /**
     * Generates an authentication token for a user.
     * 
     * @param userId The ID of the user for whom the token is to be generated.
     * @return The generated authentication token.
     */
    public String generateToken(int userId);

    /**
     * Validates an authentication token.
     * 
     * @param token The token to be validated.
     * @return true if the token is valid, false otherwise.
     */
    public boolean validateToken(String token);
}
