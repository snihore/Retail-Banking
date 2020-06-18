package com.banking.tcs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.banking.tcs.bean.User;
import com.banking.tcs.util.DBConnection;

public class UserDAOImpl implements UserDAO{
	
	private Connection connection = null;
	private PreparedStatement prst1 = null;
	private PreparedStatement prst2 = null;
	private ResultSet rs = null;

	@Override
	public String login(User user, String type){
		// TODO Auto-generated method stub
		
		
		try{
			
			//Get MYSQL connection object from DBConnection
			connection = DBConnection.getConnection();
			
			
			String username_key = null;
			String table_type = null;
			String username = null;
			String password = null;
			
			if(type.equals("cashier")){
				username_key = "cash_login";
				table_type = "cashier";
			}else if(type.equals("executive")){
				username_key = "login";
				table_type = "userstore";
			}
			
			//Retrieve data from userstore (cashier / executive) table 
			String query = query = "SELECT * FROM "+table_type+" WHERE "+username_key+" = '"+user.getUsername()+"';";
			
			prst1 = connection.prepareStatement(query);
			
			
			rs = prst1.executeQuery();
			
			// Get username and password
			while(rs.next()){
				username = rs.getString(username_key);
				password = rs.getString("password");
			}
			
			if(username != null && password != null){
				
				//if password is correct
				if(username.equals(user.getUsername()) && password.equals(user.getPassword())){
					
					//update timestamp
					prst2 = connection.prepareStatement(
							"update "+table_type+" set timestamp = CURRENT_TIMESTAMP "
							+" WHERE "+username_key+" = '"+user.getUsername()+"';"
							);
					
					if(prst2.executeUpdate() > 0){
						return user.getUsername();
					}else{
						return null;
					}
				}else{ // if password is incorrect
					return null;
				}
			}else{ // if new user try to logged in
				
				//save login info
				prst2 = connection.prepareStatement(
						"INSERT INTO "+table_type+" VALUES ('"
								+user.getUsername()
								+ "', '"
								+user.getPassword()
								+ "', CURRENT_TIMESTAMP);"
						);
				
				
				
				if(prst2.executeUpdate() > 0){
					return user.getUsername();
				}else{
					return null;
				}
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			try {
				DBConnection.closeConnection(connection);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
	}

}
