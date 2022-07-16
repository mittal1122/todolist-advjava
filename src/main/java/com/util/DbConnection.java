package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbConnection {
	static String driver="com.mysql.cj.jdbc.Driver";
	static String url ="jdbc:mysql://localhost:3306/ism";
	static String userName = "root";
	static String password ="root";
	
	public static Connection getConnection(){
		
		try {
			
			Class.forName(driver);
		
			Connection con =DriverManager.getConnection(url,userName,password);
		
		
			if(con != null) {
				System.out.println("Db is connected");
			}
			return con;
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
