/**
 * 
 */
package com.flipkart.dao;

import com.flipkart.bean.FlipFitUser;

public interface FlipFitUserDao {

    int addUser(FlipFitUser user);
    
    boolean updateUser(String email, String name, int roleId);
    
    boolean updatePassword(String email, String oldPassword, String newPassword);
    
    FlipFitUser getUserByEmail(String email);
    
    void listAllUsers();
    
    boolean login(String email, String password);
    
    String generateToken(int userId);
    
    boolean validateToken(String token);
}
