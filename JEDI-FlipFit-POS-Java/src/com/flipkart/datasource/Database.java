/**
 * 
 */
package com.flipkart.datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Statement;

/**
 * 
 */
public class Database {
	private static Database dbIsntance;
    private static Connection con ;
    private static Statement stmt;


    private Database() {
      // private constructor //
    }

    public static Database getInstance(){
	    if(dbIsntance==null){
	        dbIsntance = new Database();
	    }
	    return dbIsntance;
    }
    
    public Connection getConnection(){

        if(con==null){
            try {
            	Class.forName("com.mysql.jdbc.Driver");
                String host = "jdbc:mysql://localhost:3306/flipfit_schema";
                String username = "root";
                String password = "root";
                con = DriverManager.getConnection( host, username, password );
                
                PreparedStatement stmt= con.prepareStatement("SHOW TABLES;");
    	
    			int i=stmt.executeUpdate();  
    			System.out.println(i);
            } catch (Exception e) {
            	System.out.println(e);
            }
        }

        return con;
    }
	
//	public void closeConnection() {
//		try {
//			db.close();
//		} catch(Exception e) {
//			System.out.println(e);
//		}
//	}

}

