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

public class CreateCustomerController extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse res){
		
		HttpSession session = req.getSession(false);
		
		if(session != null){
			
			User user = (User)session.getAttribute("executive");
			
			PrintWriter pw;
			try {
				pw = res.getWriter();
				
				if(user != null){
					//Get Customer Object
					Customer customer = getParameters(req);
					
					CustomerService customerService = new CustomerService();
					
					int customerSSN = customerService.createCustomer(customer);
					
					if(customerSSN > 0){
//						pw.println("Customer Create Successfully, Customer SSN : "+customerSSN);
						ShowStatus.showStatus(
								req, 
								res, 
								"Customer Create Successfully, Customer SSN : "+customerSSN, 
								"success"
								);
					}else{
//						pw.println("Customer is not created !!!");
						ShowStatus.showStatus(
								req, 
								res, 
								"Customer is not created", 
								"error"
								);
					}

					
				}else{
//					pw.println("Current user not allowed to create a customer.");
					ShowStatus.showStatus(
							req, 
							res, 
							"Current user not allowed to create a customer", 
							"error"
							);
				}
				
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				
				e1.printStackTrace();
				ShowStatus.showStatus(
						req, 
						res, 
						e1.getMessage(), 
						"error"
						);
				
			}
			
			
		}
		
		
	
	}
	
	//Get input parameters from GET request
	private Customer getParameters(HttpServletRequest req){
		
		int ssn = Integer.parseInt(req.getParameter("cus_ssn_id"));
		String name = req.getParameter("cus_name").toUpperCase();
		int age = Integer.parseInt(req.getParameter("cus_age"));
		String address = req.getParameter("cus_add").toUpperCase();
		String city = req.getParameter("city").toUpperCase();
		String state = req.getParameter("stt").toUpperCase();
		
		return new Customer(ssn, name, age, address, city, state, "active".toUpperCase(), "Account Creation.".toUpperCase());
	}

}
