/**
 * 
 */
package com.flipkart.business;

import com.flipkart.bean.FlipFitUser;

/**
 * 
 */
public interface FlipFitUserInterface {
	public int addUser(String name, String email, String password, int roleId);

    public boolean updateUser(String email, String name, int roleId) ;

	public boolean updatePassword(String email, String oldPassword, String newPassword);

    public void listAllUsers();

    public FlipFitUser login(String email, String password);

    public boolean logout(String email);

    public String generateToken(int userId);

    public boolean validateToken(String token);
}
