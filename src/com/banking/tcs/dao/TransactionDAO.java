package com.banking.tcs.dao;

import java.util.List;

import com.banking.tcs.bean.Transaction;

public interface TransactionDAO {
	
	public String createTransaction(Transaction trans);
	
	public List<Transaction> getLastTransactions(int accID, int limit);
	
	public List<Transaction> getTransactions(int accID, String start, String end);

}
