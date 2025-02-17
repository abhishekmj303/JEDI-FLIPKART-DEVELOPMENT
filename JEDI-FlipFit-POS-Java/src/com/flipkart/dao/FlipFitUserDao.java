package com.flipkart.dao;

import com.flipkart.bean.FlipFitUser;

/**
 * The FlipFitUserDao interface defines the data access operations related to user tasks in the FlipFit system.
 * It includes methods for adding, updating, and retrieving user information, as well as user authentication and token management.
 */
public interface FlipFitUserDao {

    /**
     * Adds a new user to the system.
     * 
     * @param user The FlipFitUser object containing the details of the user.
     * @return The ID of the newly created user.
     */
    public int addUser(FlipFitUser user);
    
    /**
     * Updates the details of an existing user based on their email.
     * 
     * @param email The email of the user to be updated.
     * @param name The new name to set for the user.
     * @param roleId The new role ID to assign to the user.
     * @return true if the update was successful, false otherwise.
     */
    public boolean updateUser(String email, String name, int roleId);
    
    /**
     * Updates the password of a user based on their email and the old password.
     * 
     * @param email The email of the user whose password needs to be updated.
     * @param oldPassword The current password of the user.
     * @param newPassword The new password to be set for the user.
     * @return true if the password was successfully updated, false otherwise.
     */
    public boolean updatePassword(String email, String oldPassword, String newPassword);
    
    /**
     * Retrieves a user from the system based on their email.
     * 
     * @param email The email of the user to be retrieved.
     * @return The FlipFitUser object corresponding to the provided email, or null if no user exists with that email.
     */
    public FlipFitUser getUserByEmail(String email);
    
    /**
     * Lists all the users in the system.
     * This method retrieves and displays information about all users registered within the FlipFit system.
     */
    public void listAllUsers();
    
    /**
     * Authenticates a user based on their email and password.
     * 
     * @param email The email address of the user.
     * @param password The password of the user.
     * @return A FlipFitUser object if login is successful, or null if the credentials are invalid.
     */
    public FlipFitUser login(String email, String password);
    
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
