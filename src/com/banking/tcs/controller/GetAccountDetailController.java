package com.banking.tcs.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.banking.tcs.bean.Account;
import com.banking.tcs.bean.User;
import com.banking.tcs.service.AccountService;
import com.banking.tcs.util.ShowStatus;

public class GetAccountDetailController extends HttpServlet{
	
	public void doPost(HttpServletRequest req, HttpServletResponse res){
		
		HttpSession session = req.getSession(false);
		
		if(session != null){
			
			User user = (User)session.getAttribute("cashier");
			
			try{
				PrintWriter pw = res.getWriter();
				
				if(user != null){
					
					System.out.println("ACCOUNT NUM: "+req.getParameter("cust_acc_id"));
					
					int id = Integer.parseInt(req.getParameter("cust_acc_id"));
					
					AccountService accountService = new  AccountService();
					
					Account account = accountService.getAccountDetails(id);
					
					System.out.println("ACCOUNT DETAIL: "+account.getAccountNum()+" , Customer SSN: "+account.getCustomerID());
					
					req.setAttribute("account_info", account);
					
					req.getRequestDispatcher("/ShowAccount.jsp").forward(req, res);
					
					
				}else{
//					pw.println("Current user not allowed to do that operation ...");
					ShowStatus.showStatus(
							req, 
							res, 
							"Current user not allowed to do that operation", 
							"error"
							);
				}
			}catch(Exception e){
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
