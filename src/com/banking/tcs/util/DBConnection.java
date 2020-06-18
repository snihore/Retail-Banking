package com.banking.tcs.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.Driver;

public class DBConnection {
	
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DB_NAME = "banking";
	private static final String DB_USER = "root";
	private static final String DB_PWD = "585878srv111@";
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		
		Connection connection = null;
		
		//MYSQL database driver
		Class.forName(DRIVER);
		
		//Connect to the MYSQL localhost server
		connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/"+DB_NAME, DB_USER, DB_PWD);
		
		
		//return connection object
		return connection;
	}
	
	public static void closeConnection(Connection connection) throws SQLException{
		
		if(connection != null){
			
			connection.close();
		}
	}

}
