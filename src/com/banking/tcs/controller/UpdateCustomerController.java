package com.banking.tcs.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.banking.tcs.bean.Customer;
import com.banking.tcs.bean.User;
import com.banking.tcs.service.CustomerService;
import com.banking.tcs.util.ShowStatus;

public class UpdateCustomerController extends HttpServlet{
	
	public void doPost(HttpServletRequest req, HttpServletResponse res){
		
		int ssn = Integer.parseInt(req.getParameter("cust_ssn"));
		String name = req.getParameter("new_cus_name").toUpperCase();
		String addr = req.getParameter("new_cus_add").toUpperCase();
		int age = Integer.parseInt(req.getParameter("new_cus_age"));
		
		Customer cust = new Customer();
		
		cust.setSsn(ssn);
		cust.setName(name);
		cust.setAddress(addr);
		cust.setAge(age);
		cust.setMsg("Update Customer.".toUpperCase());
		
		HttpSession session = req.getSession(false);
		
		if(session != null){
			
			User user = (User)session.getAttribute("executive");
			
			try {
				PrintWriter pw = res.getWriter();
				
				if(user != null){
					
					CustomerService customerService = new CustomerService();
					
					boolean result = customerService.updateCustomer(cust);
					
					if(result){
//						pw.println("Updated Successfully");
						ShowStatus.showStatus(
								req, 
								res, 
								"Updated Successfully", 
								"success"
								);
					}else{
//						pw.println("Failed to Update !!");
						ShowStatus.showStatus(
								req, 
								res, 
								"Failed to Update", 
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
				
			} catch (IOException e) {
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
