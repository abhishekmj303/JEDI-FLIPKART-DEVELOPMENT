/**
 * 
 */
package com.flipkart.business;

import com.flipkart.bean.User;

/**
 * 
 */
public class UserBusiness {
	public void addUser(User user) {
        System.out.println("User added " + user.getId());
    }
    
    public boolean updateUser(User user) {
    	System.out.println("User updated "+user.getId());
    	return true;
    }

    public int getUserById(int id) {
    	System.out.println("Get user id "+ id);
        return id;
    }

    public void listAllUsers() {
    	System.out.println("List all users with details");
    }
}
