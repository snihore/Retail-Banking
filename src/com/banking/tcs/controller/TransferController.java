package com.banking.tcs.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.banking.tcs.bean.Account;
import com.banking.tcs.bean.Transaction;
import com.banking.tcs.bean.User;
import com.banking.tcs.service.AccountService;
import com.banking.tcs.service.TransactionService;
import com.banking.tcs.util.GenerateUniqueIDs;
import com.banking.tcs.util.ShowStatus;

public class TransferController extends HttpServlet{
	

public void doPost(HttpServletRequest req, HttpServletResponse res){
		
		HttpSession session = req.getSession(false);
		
		if(session != null){
			
			User user = (User)session.getAttribute("cashier");
			
			try{
				
				if(user != null){
					
					int accID = Integer.parseInt(req.getParameter("acc_id"));
					int accTgtID = Integer.parseInt(req.getParameter("acc_tgt_id"));
					
					AccountService accountService = new AccountService();
					
					Account acc = accountService.getAccountDetails(accID);
					Account targetAcc = accountService.getAccountDetails(accTgtID);
					
					int custID = acc.getCustomerID();
					String accStatus = acc.getAccountStatus();
					int balance = acc.getBalance();
					int amount = Integer.parseInt(req.getParameter("transfer_amount"));
					
					if(acc != null && acc.getAccountNum() == accID && targetAcc != null && targetAcc.getAccountNum() == accTgtID){
						
						
						if(!accStatus.equals("active".toUpperCase())){
							
							ShowStatus.showStatus(req, res, "Current account is not ACTIVE", "error");
							
						}else if(amount != 0 && amount <= balance && accStatus.equals("active".toUpperCase())){
							
							TransactionService transactionService = new TransactionService();
							
							int transID = GenerateUniqueIDs.generateRandomDigits(9);
							
							Transaction trans = new Transaction(transID, custID, accID, acc.getAccountType(), accTgtID, targetAcc.getAccountType(), amount, "transfer amount".toUpperCase(), "");
							
							String timestamp = transactionService.createTransaction(trans);
							
							if(timestamp != null){
								
								//For source account
								int bal = balance;
								balance = balance - amount;
								acc.setBalance(balance);
								
								
								int targetAccBalance = targetAcc.getBalance();
								
								//For target account
								targetAccBalance = targetAccBalance + amount;
								
								String ts01 = accountService.updateAccount(accTgtID, targetAccBalance, timestamp, "Credit amount".toUpperCase());
								
								if(ts01 != null && ts01.equals(timestamp)){
									
									String ts = accountService.updateAccount(accID, balance, timestamp, "Debit amount".toUpperCase());
									
									if(ts != null && ts.equals(timestamp)){
										req.setAttribute("account_info", acc);
										req.setAttribute("old_balance", bal);
										req.setAttribute("target_acc_num", targetAcc.getAccountNum());
										req.getRequestDispatcher("/TransferredMoney.jsp").forward(req, res);
										
										
									}else{
										ShowStatus.showStatus(req, res, "Transaction unsuccessfull", "error");
									}
									
									
								}else{
									ShowStatus.showStatus(req, res, "Transaction unsuccessfull", "error");
								}
							}else{
								ShowStatus.showStatus(req, res, "Transaction unsuccessfull", "error");
							}
		
						}else{
							ShowStatus.showStatus(req, res, "Please enter valid transfer amount", "error");
						}
		
					}else{
						ShowStatus.showStatus(req, res, "Transaction unsuccessfull", "error");
					}
					
					
				}else{
					ShowStatus.showStatus(req, res, "Current user not able to do that operation", "error");
				}
			}catch(Exception e){
				e.printStackTrace();
				ShowStatus.showStatus(req, res, e.getMessage(), "error");
			}
		}
	}

}
