package com.banking.tcs.dao;

import java.util.List;

import com.banking.tcs.bean.Account;

public interface AccountDao {
	
	// Create Account by providing Account POJO -- Method Signature
	public int createAccount(Account acc);
	
	//Get All Available Accounts -- Method Signature
	public List<Account> getAllAccounts();
	
	//Search Account by providing either Customer ID or Account Number -- Method Signature
	public List<Account> searchAccount(String type, int id);
	
	//Get Account Info by providing Account ID/Number -- Method Signature
	public Account getAccountDetails(int id);
	
	//Update Account (Method Signature) by proving 
	// 1. Account Number/ID
	// 2. balance
	// 3. Timestamp ( Get from Transactions)
	// 4. Message 
	public String updateAccount(int accID, int balance, String timestamp, String msg);
	
	// Delete Account by providing Account ID/Number -- Method Signature
	public boolean deleteAccount(int accID);

}
