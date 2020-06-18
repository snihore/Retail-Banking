package com.banking.tcs.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.banking.tcs.bean.Account;
import com.banking.tcs.bean.User;
import com.banking.tcs.service.AccountService;
import com.banking.tcs.util.GenerateUniqueIDs;
import com.banking.tcs.util.ShowStatus;

public class CreateAccountController extends HttpServlet{
	
	public void doPost(HttpServletRequest req, HttpServletResponse res){
		
		int customerID = Integer.parseInt(req.getParameter("acc_cus_ssn_id"));
		String accType = req.getParameter("acc_type").substring(0, 1).toUpperCase();
		int balance = Integer.parseInt(req.getParameter("acc_amount"));
		
		//Account number generate
		// Method - random 5 digit number generate and add with 169400000
		int num = 169400000;
		int num1 = GenerateUniqueIDs.generateRandomDigits(5);
		
		int accountNum = num + num1;
		String accStatus = "active".toUpperCase();
		String accMsg = "Account creation.".toUpperCase();
		String accCreationDate = "";
		String accLastUpDate = "";
		
		Account account = new Account(accountNum, customerID, accType, balance, accCreationDate, accLastUpDate, accStatus, accMsg);
		
		HttpSession session = req.getSession(false);
		
		if(session != null){
			
			User user = (User) session.getAttribute("executive");
			
			try {
				PrintWriter pw = res.getWriter();
				
				if(user != null){
					
					AccountService accService = new AccountService();
					
					int id = accService.createAccount(account);
					
					
					if(id == customerID){
//						pw.println("Account successfully created, Account Number: "+accountNum+" , Customer SSN: "+id);
						ShowStatus.showStatus(
								req, 
								res, 
								"Account successfully created, Account Number: "+accountNum+" , Customer SSN: "+id, 
								"success"
								);
					}else{
//						pw.println("Account creation failed !!");
						ShowStatus.showStatus(
								req, 
								res, 
								"Account creation failed", 
								"error"
								);
					}
					
				}else{
//					pw.println("Current user not allowed to do that operation ...");
					ShowStatus.showStatus(
							req, 
							res, 
							"Current user not allowed to do that operation", 
							"error"
							);
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				ShowStatus.showStatus(
						req, 
						res, 
						e.getMessage(), 
						"error"
						);
				
			}
			
		}
		
	}
	
	

}
