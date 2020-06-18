package com.banking.tcs.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.banking.tcs.bean.User;
import com.banking.tcs.util.ShowStatus;

public class SearchAccountForActionController extends HttpServlet{
	
	public void doPost(HttpServletRequest req, HttpServletResponse res){
		
		int searchID = 0;
		String searchType = "";
		
		HttpSession session =  req.getSession(false);
		
		if(session != null){
			
			try {
				PrintWriter pw = res.getWriter();
				
//				User user =  (User)session.getAttribute("cashier");
				
//				if(user != null){
//					
//					
//					
//					
//					
//				}else{
////					pw.println("Current user not allowed to do that operation ..");
//					ShowStatus.showStatus(
//							req, 
//							res, 
//							"Current user not allowed to do that operation", 
//							"error"
//							);
//				}
				
				if(req.getParameter("acc_id") != null && !req.getParameter("acc_id").matches("")){
					searchID = Integer.parseInt(req.getParameter("acc_id"));
					searchType = "account_id";
				}else if(req.getParameter("cus_id") != null && !req.getParameter("cus_id").matches("")){
					searchID = Integer.parseInt(req.getParameter("cus_id"));
					searchType = "customer_id";
				}
				
				System.out.println("SEARCH ID: "+searchID);
				System.out.println("SEARCH TYPE: "+searchType);
				
				if(searchID != 0 && !searchType.matches("")){
					req.setAttribute("search_type", searchType);
					req.setAttribute("search_id", searchID);
					
					if(req.getParameter("type123") != null && req.getParameter("type123").equals("delete_account")){
						req.getRequestDispatcher("/DeleteAccount.jsp").forward(req, res);
						
					}else{
						req.getRequestDispatcher("/SelectAccount.jsp").forward(req, res);
					}
					
					
				}else{
//					pw.println("Enter valid account or customer id !!");
					ShowStatus.showStatus(
							req, 
							res, 
							"Enter valid account or customer id", 
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
