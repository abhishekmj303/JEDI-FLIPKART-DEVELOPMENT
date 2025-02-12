package com.flipkart.bean;


public class Authentication {
    private static final String SECRET_KEY = "mySecretKey";

    public static String generateToken(User user) {
    	return "generated token";
    }

    public static boolean validateToken(String token) {
    	System.out.println("validating token: " + token);
        return true;
    }
}
