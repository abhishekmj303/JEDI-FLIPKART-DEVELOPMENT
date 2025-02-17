/**
 * 
 */
package com.flipkart.dao;

import com.flipkart.bean.FlipFitUser;

public interface FlipFitUserDao {

    public int addUser(FlipFitUser user);
    
    public boolean updateUser(String email, String name, int roleId);
    
    public boolean updatePassword(String email, String oldPassword, String newPassword);
    
    public FlipFitUser getUserByEmail(String email);
    
    public void listAllUsers();
    
    public FlipFitUser login(String email, String password);
    
    public String generateToken(int userId);
    
    public boolean validateToken(String token);
}
