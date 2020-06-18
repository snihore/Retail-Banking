package com.banking.tcs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.banking.tcs.bean.Account;
import com.banking.tcs.util.DBConnection;

// Implement Interface 'AccountDao' and defined all the Methods
public class AccountDaoImpl implements AccountDao {
	
	private Connection connection = null;
	private PreparedStatement prst1 = null;
	private PreparedStatement prst2 = null;
	private ResultSet resultSet = null;

	// createAccount() start
	//RETURN Integer value specify the Customer ID 
	@Override
	public int createAccount(Account acc) {
		
		try {
			// "Banking" Database Connection Obj 
			connection = DBConnection.getConnection();
			
			// SQL DDL query for insert a row on 'account' table
			String query = "INSERT INTO account(ws_acct_id, ws_cust_id, ws_acct_type, ws_status, ws_msg, ws_balance) "
					+ "VALUES ('"+acc.getAccountNum()+"', "
					+ "'"+acc.getCustomerID()+"', "
					+ "'"+acc.getAccountType()+"', "
					+ "'"+acc.getAccountStatus()+"', "
					+ "'"+acc.getAccountMsg()+"', "
					+ "'"+acc.getBalance()+"');";
			
			//
			prst1 = connection.prepareStatement(query);
			
			//
			prst1.executeUpdate(); // Row inserted on database table
			
			int customerID = 0; // Customer ID of Account Owner
			
			// SQL DML query for fetching the row from 'account' table
			String query1 = "select ws_cust_id from account where ws_acct_id = '"+acc.getAccountNum()+"';";
			
			//
			prst2 = connection.prepareStatement(query1);
			
			//
			resultSet = prst2.executeQuery();// Get ResultSet Object containing Rows
			
			//LOOP start
			while(resultSet != null && resultSet.next()){
				//Get Customer ID 
				customerID = resultSet.getInt("ws_cust_id");
			}// LOOP End
			
			return customerID; // RETURN Customer ID
			
			
			
		} catch (Exception e) {
			
			// Error Occur then Print Logs
			e.printStackTrace();
			
			//And RETURN -1 that represents ERROR
			return -1;
		}finally{
			
			//Whether an Exception is occur or not, Below instruction is able to CLOSE the Database Connection
			
			try {
				//Close Database Connection
				DBConnection.closeConnection(connection);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//Nested Try-catch END
		}//Try-catch-finally END
		
	}// createAccount() END

	//getAllAccounts() start
	//RETURN List of Accounts 
	@Override
	public List<Account> getAllAccounts() {
		
		try {
			// Get 'banking' 'Database Connection Object
			connection = DBConnection.getConnection();
			
			//Perform DML operation for fetching the rows
			prst1 = connection.prepareStatement("SELECT * FROM account;");
			
			//get Result Set Object containing fetched rows 
			resultSet = prst1.executeQuery();
			
			//Initialise List Account type containing Accounts;
			List<Account> accounts = new ArrayList<>();
			
			//LOOP starts
			while(resultSet != null && resultSet.next()){
				
				int accountNum = resultSet.getInt("ws_acct_id");
				int customerID = resultSet.getInt("ws_cust_id");
				String accountType = resultSet.getString("ws_acct_type");
				String accountStatus = resultSet.getString("ws_status");
				String accountMsg = resultSet.getString("ws_msg");
				String creationDate = resultSet.getString("ws_acct_crdate");
				String lastUpdatedDate = resultSet.getString("ws_acct_lstupda");
				int balance = resultSet.getInt("ws_balance");
				
				//Create Account Object and added to List
				accounts.add(new Account(accountNum, customerID, accountType, balance, creationDate, lastUpdatedDate, accountStatus, accountMsg));
				
			}//Loop End
			
			//IF start
			if(accounts.size() > 0){
				
				//IF List containing accounts then return 
				return accounts;
			}//IF end
			
			return null; //otherwise RETURN NULL
			
		} catch (Exception e) {
			//Error occurs then print Logs
			e.printStackTrace();
			return null; // and return null
		}finally{
			//Whether an Exception occur or not, below instructions Closes the Database Connection
			try {
				//Close Database Connection
				DBConnection.closeConnection(connection);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//Nested try-catch block END
		}//try-catch block END
	}//getAllAccounts() END

	
	//searchAccount() start
	//RETURN List of Accounts
	@Override
	public List<Account> searchAccount(String type, int id) {
		
		try {
			//Get Database Connection object 
			connection = DBConnection.getConnection();
			
			//IF start
			// if 'type' is equal to 'account_id'
			if(type.equals("account_id")){
				type = "ws_acct_id";
				
				
				//If 'type' is equal to 'customer_id' 
			}else if(type.equals("customer_id")){
				type = "ws_cust_id";
				
				//Otherwise 
			}else{
				type = "";
			}//IF-else END
			
			//If type have some value other then Empty string
			if(!type.matches("")){
				
				//SQL DML query for fetch the row containing account's info by prividing Account / Customer ID
				String query = "SELECT * FROM account WHERE "+type+" = '"+id+"';";
				
				prst1 = connection.prepareStatement(query); // 
				
				resultSet = prst1.executeQuery(); // Execute Query and Get the ResultSet object containing rows
				
				List<Account> accounts = new ArrayList<>(); //List of Account Type
				
				//LOOP start
				while(resultSet != null && resultSet.next()){
					
					int accountNum = resultSet.getInt("ws_acct_id");
					int customerID = resultSet.getInt("ws_cust_id");
					String accountType = resultSet.getString("ws_acct_type");
					String accountStatus = resultSet.getString("ws_status");
					String accountMsg = resultSet.getString("ws_msg");
					String creationDate = resultSet.getString("ws_acct_crdate");
					String lastUpdatedDate = resultSet.getString("ws_acct_lstupda");
					int balance = resultSet.getInt("ws_balance");
					
					//Create Account Object and added to the List
					accounts.add(new Account(accountNum, customerID, accountType, balance, creationDate, lastUpdatedDate, accountStatus, accountMsg));

					
				}//Loop-End
				
				
				//If start
				if(accounts.size() > 0){
					
					//RETURN accounts list if size of list is greater then ZERO
					return accounts;
				}//IF-end
				
				
				//otherwise RETURN null;
				return null;
				
				
			}else{
				return null;
			}//If-else END
			
		} catch (Exception e) {
			//
			e.printStackTrace();
			return null;
		}finally{
			
			//Close Database Connection
			try {
				DBConnection.closeConnection(connection);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}//Try=catch=finally END
		
	}// searchAccount() END

	
	//getAccountDetails() starts
	// RETURN Account POJO
	@Override
	public Account getAccountDetails(int id) {
		// TODO Auto-generated method stub
		
		//start Try-catch-finally
		try {
			
			//Get Database Connection Object 
			connection = DBConnection.getConnection();
			
			
			//SQL DML query for fetching the rows containing Account's info by providing Account Number/ID  
			String query = "SELECT * FROM account WHERE ws_acct_id = '"+id+"';";
			
			
			//
			prst1 = connection.prepareStatement(query);
			
			//Get ResultSet Object containing the fetched rows
			resultSet = prst1.executeQuery();
			
			
			//Reference of Account POJO 
			Account acc = null;
			
			//Loop Starts
			while(resultSet != null && resultSet.next()){
				
				int accountNum = resultSet.getInt("ws_acct_id");
				int customerID = resultSet.getInt("ws_cust_id");
				String accountType = resultSet.getString("ws_acct_type");
				String accountStatus = resultSet.getString("ws_status");
				String accountMsg = resultSet.getString("ws_msg");
				String creationDate = resultSet.getString("ws_acct_crdate");
				String lastUpdatedDate = resultSet.getString("ws_acct_lstupda");
				int balance = resultSet.getInt("ws_balance");
				
				
				//Create Account POJO Object and asign to 'acc' reference
				acc = new Account(accountNum, customerID, accountType, balance, creationDate, lastUpdatedDate, accountStatus, accountMsg);

				
			}//Loop End
			
			//RETURN account's pojo instance
			return acc;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally{
			//Close Database Connection 
			try {
				DBConnection.closeConnection(connection);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}//try-catch-finally END
		
	}// getAccountDetails() END

	
	// updateAccount() start
	//RETURN String value containing Account's last updated timestamp
	@Override
	public String updateAccount(int accID, int balance, String timestamp, String msg) {
		// TODO Auto-generated method stub
		
		//Start Try-catch-finally
		try {
			
			//Get Database Connection Object
			connection = DBConnection.getConnection();
			
			//Perform SQL query for update the account's "balance", "last updated timestamp" and "msg"
			//by providing Account's ID in WHERE clause
			String query = "UPDATE account SET ws_balance = '"+balance+"', ws_acct_lstupda = '"+timestamp+"', ws_msg = '"+msg+"' WHERE ws_acct_id = '"+accID+"';";
			
			//
			prst1 = connection.prepareStatement(query);
			
			//"status" represents the numbers of rows affected
			int status = prst1.executeUpdate();
			
			//If start
			//If 'status' is greater then ZERO then peform SQL DML query for fetch the account's last updated timestamp
			if(status > 0){
				
				String query1 = "SELECT ws_acct_lstupda FROM account WHERE ws_acct_id = '"+accID+"';";
				
				prst2 = connection.prepareStatement(query1);
				
				resultSet = prst2.executeQuery();
				
				String ts = "";
				
				//Loop Start
				while(resultSet != null && resultSet.next()){
					ts = resultSet.getString("ws_acct_lstupda");
				}//Loop End
				
				//if start
				if(!ts.matches("")){
					return ts;
				}//if end
				
				return null;
				
			}else{
				return null;
			}// If-else END
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally{
			//Close Database Connection
			try {
				DBConnection.closeConnection(connection);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}//try-catch-finally END
	}

	@Override
	public boolean deleteAccount(int accID) {
		// TODO Auto-generated method stub
		try {
			connection = DBConnection.getConnection();
			
			String query = "delete from account where ws_acct_id = '"+accID+"';";
			String query1 = "delete from transactions where ws_accnt_id = '"+accID+"' or ws_tgt_accnt_id='"+accID+"';";
			
			prst1 = connection.prepareStatement(query1);
			
			prst1.executeUpdate();
			
			prst2 = connection.prepareStatement(query);
			
			int status = prst2.executeUpdate();
			
			if(status > 0){
				
				return true;
				
			}
			
			return false;
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return false;
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
