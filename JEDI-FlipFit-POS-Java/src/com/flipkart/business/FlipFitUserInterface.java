package com.flipkart.business;

import com.flipkart.bean.FlipFitUser;

/**
 * The FlipFitUserInterface defines the contract for operations that can be performed by users in the FlipFit system.
 * It includes methods for adding and updating user information, user authentication, and token generation and validation.
 */
public interface FlipFitUserInterface {
    
    /**
     * Adds a new user to the system with the provided details.
     * 
     * @param name The name of the user.
     * @param email The email address of the user.
     * @param password The password for the user account.
     * @param roleId The role ID associated with the user (e.g., customer, owner, admin).
     * @return The ID of the newly created user.
     */
    public int addUser(String name, String email, String password, int roleId);

    /**
     * Updates the user details (name and role) based on the provided email.
     * 
     * @param email The email of the user to be updated.
     * @param name The new name to set for the user.
     * @param roleId The new role ID to assign to the user.
     * @return true if the update was successful, false otherwise.
     */
    public boolean updateUser(String email, String name, int roleId);

    /**
     * Updates the password for the user based on the provided email and old password.
     * 
     * @param email The email of the user.
     * @param oldPassword The current password of the user.
     * @param newPassword The new password to be set.
     * @return true if the password was successfully updated, false otherwise.
     */
    public boolean updatePassword(String email, String oldPassword, String newPassword);

    /**
     * Lists all the users in the system.
     * This method provides a way to view all the users registered within the FlipFit system.
     */
    public void listAllUsers();

    /**
     * Logs in a user by validating their email and password.
     * 
     * @param email The email address of the user.
     * @param password The password of the user.
     * @return A FlipFitUser object if login is successful, or null if the credentials are invalid.
     */
    public FlipFitUser login(String email, String password);

    /**
     * Logs out the user based on the provided email.
     * 
     * @param email The email of the user to log out.
     * @return true if logout was successful, false otherwise.
     */
    public boolean logout(String email);

    /**
     * Generates a token for the user based on their user ID.
     * The token can be used for authentication in subsequent requests.
     * 
     * @param userId The ID of the user for whom the token is generated.
     * @return The generated token.
     */
    public String generateToken(int userId);

    /**
     * Validates the provided token.
     * 
     * @param token The token to be validated.
     * @return true if the token is valid, false otherwise.
     */
    public boolean validateToken(String token);
}
