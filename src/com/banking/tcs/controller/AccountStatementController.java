package com.banking.tcs.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.banking.tcs.bean.Transaction;
import com.banking.tcs.bean.User;
import com.banking.tcs.service.TransactionService;
import com.banking.tcs.util.ShowStatus;

public class AccountStatementController extends HttpServlet{
	
	public void doPost(HttpServletRequest req, HttpServletResponse res){
		
		HttpSession session =  req.getSession(false);
		
		if(session == null){
			return;
		}
		
		User user = (User)session.getAttribute("cashier");
		
		if(user == null){
			ShowStatus.showStatus(req, res, "Current user not allowed to do that operation", "error");
			return;
		}
		
		try{
			
			
			String type = req.getParameter("statement_type");
			TransactionService transactionService = new TransactionService();
			List<Transaction> transactions = null;
			
			if(type.equals("date_type")){
				
				int accID = Integer.parseInt(req.getParameter("account_id"));
				String start = req.getParameter("str_date");
				String end = req.getParameter("lst_date");
				
				System.out.println("Account Num: "+accID);
				System.out.println("Start: "+start);
				System.out.println("End: "+end);
				
				transactions = transactionService.getTransactions(accID, start, end);
				
				if(transactions == null){
					ShowStatus.showStatus(req, res, "Can't find transactions #1", "error");
					return;
				}
				
				if(transactions.size()  == 0){
					ShowStatus.showStatus(req, res, "Can't find transactions #2", "error");
					return;
				}
				
				req.setAttribute("date_transactions", transactions);
				req.getRequestDispatcher("/AccountStatementWithDate.jsp").forward(req, res);
				
			}else if(type.equals("last_type")){
				
				
				int accID = Integer.parseInt(req.getParameter("account_id"));
				int noOfTrans = Integer.parseInt(req.getParameter("num_of_trans"));
				String modeOfOps = req.getParameter("trans");
				String type01 = "Last Number of Transactions";
				String type02 = "Start-End Dates";
				
				if(modeOfOps.equals(type01)){
					// Last Number of Transactions
					
					if(noOfTrans <= 0){
						ShowStatus.showStatus(req, res, "Please select number of transactions", "error");
						return;
					}
					
					transactions = transactionService.getLastTransactions(accID, noOfTrans);
					
					if(transactions == null){
						ShowStatus.showStatus(req, res, "Can't find transactions #1", "error");
						return;
					}
					
					if(transactions.size()  == 0){
						ShowStatus.showStatus(req, res, "Can't find transactions #2", "error");
						return;
					}
					
					req.setAttribute("transactions", transactions);
					req.getRequestDispatcher("/lastntransaction.jsp").forward(req, res);
					
				}else if(modeOfOps.equals(type02)){
					// Between start date and end date
					req.setAttribute("account_id", accID);
					req.getRequestDispatcher("/AccountStatementWithDate.jsp").forward(req, res);
					
				}
			}
			
			
			
			
			
		}catch(Exception e){
			e.printStackTrace();
			ShowStatus.showStatus(req, res, e.getMessage(), "error");
		}
		
	}

}
