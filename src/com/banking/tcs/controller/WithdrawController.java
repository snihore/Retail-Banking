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

public class WithdrawController extends HttpServlet{

public void doPost(HttpServletRequest req, HttpServletResponse res){
		
		HttpSession session = req.getSession(false);
		
		if(session != null){
			
			User user = (User)session.getAttribute("cashier");
			
			try{
				
				if(user != null){
					
					int accID = Integer.parseInt(req.getParameter("acc_id"));
					
					AccountService service = new AccountService();
					
					Account acc = service.getAccountDetails(accID);
					
					if(acc != null && acc.getAccountNum() == accID){
						
						int custID = acc.getCustomerID();
						String accType = acc.getAccountType();
						String accStatus = acc.getAccountStatus();
						int balance = acc.getBalance();
						int amount = Integer.parseInt(req.getParameter("withdraw_amount"));
						
						if(!accStatus.equals("active".toUpperCase())){
							
							ShowStatus.showStatus(req, res, "Current account is not ACTIVE", "error");
							
						}else if(amount != 0 && amount <= balance && accStatus.equals("active".toUpperCase())){
							
							TransactionService transactionService = new TransactionService();
							
							int transID = GenerateUniqueIDs.generateRandomDigits(9);
							
							Transaction trans = new Transaction(transID, custID, accID, accType, accID, accType, amount, "withdraw amount".toUpperCase(), "");
							
							String timestamp = transactionService.createTransaction(trans);
							
							if(timestamp != null){
								
								int bal = balance;
								balance = balance - amount;
								acc.setBalance(balance);

								
								AccountService accountService = new AccountService();
								
								String ts = accountService.updateAccount(accID, balance, timestamp, "Withdraw amount".toUpperCase());
								
								if(ts != null && ts.equals(timestamp)){
									
									req.setAttribute("account_info", acc);
									req.setAttribute("old_balance", bal);
									req.getRequestDispatcher("/WithdrawnMoney.jsp").forward(req, res);
									
									
								}else{
									ShowStatus.showStatus(req, res, "Transaction unsuccessfull", "error");
								}
								
							}else{
								ShowStatus.showStatus(req, res, "Transaction unsuccessfull", "error");
							}
							
						}else{
							ShowStatus.showStatus(req, res, "Please enter valid withdraw amount", "error");
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
