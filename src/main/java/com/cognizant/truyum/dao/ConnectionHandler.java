package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConnectionHandler {
	private static Connection con = null;
	private static Properties props = new Properties();
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
	    try{
			FileInputStream fis = null;
			
			//fis = new FileInputStream("\\truyum\\src\\main\\resources\\connection.properties");
			//props.load(fis);
			
			// load the Driver Class
			Class.forName("com.mysql.jdbc.Driver");
			
			String url="jdbc:mysql://localhost:3306/truYum";
			String uname="root";
			String pass = "1234";

			// create the connection now
            con = DriverManager.getConnection(url,uname,pass);
	    }
	    catch(Exception e){
	        e.printStackTrace();
	    }
		return con;	
	}
}
