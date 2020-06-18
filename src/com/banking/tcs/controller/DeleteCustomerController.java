package com.banking.tcs.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.banking.tcs.bean.User;
import com.banking.tcs.service.CustomerService;
import com.banking.tcs.util.ShowStatus;

public class DeleteCustomerController extends HttpServlet{
	
	public void doPost(HttpServletRequest req, HttpServletResponse res){
		
		int customerSSN = Integer.parseInt(req.getParameter("ssnid"));
		
		HttpSession session = req.getSession(false);
		
		if(session != null){
			
			User user = (User)session.getAttribute("executive");
			
			try{
				
				PrintWriter pw = res.getWriter();
				
				if(user != null){
					
					CustomerService customerService = new CustomerService();
					
					boolean result = customerService.deleteCustomer(customerSSN);
					
					if(result){
//						pw.println("Customer deleted successfully");
						ShowStatus.showStatus(
								req, 
								res, 
								"Customer deleted successfully", 
								"success"
								);
					}else{
//						pw.println("Customer not deleted !!");
						ShowStatus.showStatus(
								req, 
								res, 
								"Customer not deleted", 
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
