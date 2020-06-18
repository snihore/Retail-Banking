package com.banking.tcs.service;

import java.util.List;

import com.banking.tcs.bean.Account;
import com.banking.tcs.dao.AccountDao;
import com.banking.tcs.dao.AccountDaoImpl;

public class AccountService {
	
	public int createAccount(Account acc){
		
		AccountDao accountDAO = new AccountDaoImpl();
		
		return accountDAO.createAccount(acc);
	}
	
	public List<Account> getAll(){
		
		AccountDao accountDAO = new AccountDaoImpl();
		
		return accountDAO.getAllAccounts();
	}
	
	public List<Account> searchAccount(String type, int id){
		
		AccountDao accountDAO = new AccountDaoImpl();
		
		return accountDAO.searchAccount(type, id);
	}
	
	public Account getAccountDetails(int id){
		
		AccountDao accountDAO = new AccountDaoImpl();
		
		return accountDAO.getAccountDetails(id);
	}
	
public String updateAccount(int accID, int balance, String timestamp, String msg){
		
		AccountDao accountDAO = new AccountDaoImpl();
		
		return accountDAO.updateAccount(accID, balance, timestamp, msg);
	}
	

public boolean deleteAccount(int accID){
	AccountDao accountDAO = new AccountDaoImpl();
	
	return accountDAO.deleteAccount(accID);
}
	

}
