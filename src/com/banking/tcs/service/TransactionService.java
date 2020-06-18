package com.banking.tcs.service;

import java.util.List;

import com.banking.tcs.bean.Transaction;
import com.banking.tcs.dao.TransactionDAO;
import com.banking.tcs.dao.TransactionDAOImpl;

public class TransactionService {

	
	public String createTransaction(Transaction trans){
		
		TransactionDAO transactionDAO = new TransactionDAOImpl();
		
		return transactionDAO.createTransaction(trans);
	}
	
	public List<Transaction> getLastTransactions(int accID, int limit){
		TransactionDAO transactionDAO = new TransactionDAOImpl();
		return transactionDAO.getLastTransactions(accID, limit);
		
	}
	
	public List<Transaction> getTransactions(int accID, String start, String end){
		TransactionDAO transactionDAO = new TransactionDAOImpl();
		return transactionDAO.getTransactions(accID, start, end);
		
	}
}
