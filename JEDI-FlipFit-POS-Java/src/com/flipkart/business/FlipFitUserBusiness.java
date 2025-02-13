/**
 * 
 */
package com.flipkart.business;

/**
 * 
 */
public class FlipFitUserBusiness implements FlipFitUserInterface {
	
	public void addUser(String name, String email, String password, String role) {
        System.out.println("User added " + email);
    }
    
    public boolean updateUser(String email) {
    	System.out.println("User updated " + email);
    	return true;
    }
    
    public boolean updatePassword(String email, String password) {
    	System.out.println("Update password for " + email);
    	return true;
    }

    public void listAllUsers() {
    	System.out.println("List all users with details");
    }
    
    public boolean login(String email, String password, String role) {
    	System.out.println("Logging in user: " + email);
    	generateToken(101);
    	return true;
    }
    
    public boolean logout(String email) {
    	System.out.println("Logout user: " + email);
    	return true;
    }
    
    public String generateToken(int userId) {
    	return "generated token";
    }

    public boolean validateToken(String token) {
    	System.out.println("validating token: " + token);
        return true;
    }
}
