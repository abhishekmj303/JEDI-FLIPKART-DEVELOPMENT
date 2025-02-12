package com.flipkart.bean;

import java.util.UUID;

public class Authentication {
    private static final String SECRET_KEY = "mySecretKey";

    public static String generateToken(User user) {
        return UUID.randomUUID().toString() + "-" + user.getId();
    }

    public static boolean validateToken(String token) {
        return token != null && token.length() > 10;
    }
}
