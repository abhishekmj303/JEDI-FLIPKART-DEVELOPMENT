/**
 * 
 */
package com.flipkart.business;

/**
 * 
 */
public class AuthenticationBusiness {
    public static String generateToken(int userId) {
    	return "generated token";
    }

    public static boolean validateToken(String token) {
    	System.out.println("validating token: " + token);
        return true;
    }
}
