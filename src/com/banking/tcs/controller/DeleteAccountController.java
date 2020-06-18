package com.banking.tcs.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.banking.tcs.bean.User;
import com.banking.tcs.service.AccountService;
import com.banking.tcs.util.ShowStatus;

public class DeleteAccountController extends HttpServlet{
	
	public void doPost(HttpServletRequest req, HttpServletResponse res){
		
		HttpSession session = req.getSession(false);
		
		if(session == null){
			return;
		}
		
		User user = (User)session.getAttribute("executive");
		
		if(user == null){
			ShowStatus.showStatus(req, res, "Current user not allowed to do that operation", "error");
			return;
		}
		
		try{
			
			int accID = Integer.parseInt(req.getParameter("cust_acc_id"));
			
			System.out.println("DELETED ACC ID: "+accID);
			
			AccountService accountService = new AccountService();
			
			boolean result = accountService.deleteAccount(accID);
			
			if(result){
				ShowStatus.showStatus(req, res, "Account deleted successfully", "success");
			}else{
				ShowStatus.showStatus(req, res, "Account not deleted", "error");
			}
			
		}catch(Exception e){
			e.printStackTrace();
			ShowStatus.showStatus(req, res, e.getMessage(), "error");
		}
	}

}
