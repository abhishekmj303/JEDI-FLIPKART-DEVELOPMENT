/**
 * 
 */
package com.flipkart.business;

/**
 * 
 */
public interface FlipFitUserInterface {
	public void addUser(String name, String email, String password, String role);
	
	public boolean updateUser(String email);
	
	public boolean updatePassword(String email, String password);

    public void listAllUsers();

    public boolean login(String email, String password, String role);

    public boolean logout(String email);

    public String generateToken(int userId);

    public boolean validateToken(String token);
}
