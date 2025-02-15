package com.flipkart.datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static Database dbInstance;
    private static Connection con;

    private Database() {}

    public static Database getInstance() {
        if (dbInstance == null) {
            synchronized (Database.class) {  
                if (dbInstance == null) {
                    dbInstance = new Database();
                }
            }
        }
        return dbInstance;
    }


    public static Connection getConnection() {
        if (con == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");  // Updated driver
                String host = "jdbc:mysql://localhost:3306/flipfit_schema?serverTimezone=UTC";
                String username = "root";
                String password = "root";
                con = DriverManager.getConnection(host, username, password);
                System.out.println("✅ Database connected successfully!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return con;
    }

    public void closeConnection() {
        if (con != null) {
            try {
                con.close();
                con = null;  
                System.out.println("🔴 Database connection closed.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
