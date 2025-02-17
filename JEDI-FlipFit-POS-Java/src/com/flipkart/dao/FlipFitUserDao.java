package com.flipkart.dao;

import com.flipkart.bean.FlipFitUser;

/**
 * Interface for managing user data operations.
 * This interface defines methods for adding, updating, and retrieving users,
 * as well as managing user login and authentication tokens.
 */
public interface FlipFitUserDao {

    /**
     * Adds a new user to the system.
     * 
     * @param user The user to be added.
     * @return The ID of the newly added user.
     */
    public int addUser(FlipFitUser user);

    /**
     * Updates an existing user's details.
     * 
     * @param userId The ID of the user to be updated.
     * @return true if the user was successfully updated, false otherwise.
     */
    public boolean updateUser(int userId);

    /**
     * Updates the password of a user.
     * 
     * @param email The email of the user whose password needs to be updated.
     * @param oldPassword The current password of the user.
     * @param newPassword The new password to be set.
     * @return true if the password was successfully updated, false otherwise.
     */
    public boolean updatePassword(String email, String oldPassword, String newPassword);

    /**
     * Retrieves a user by their email address.
     * 
     * @param email The email of the user to be retrieved.
     * @return The user object if found, null otherwise.
     */
    public FlipFitUser getUserByEmail(String email);

    /**
     * Lists all users in the system.
     */
    public void listAllUsers();

    /**
     * Logs in a user by validating their email and password.
     * 
     * @param email The email of the user attempting to log in.
     * @param password The password of the user attempting to log in.
     * @return The user object if login is successful, null otherwise.
     */
    public FlipFitUser login(String email, String password);

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
