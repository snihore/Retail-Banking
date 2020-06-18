package com.banking.tcs.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.banking.tcs.bean.Customer;
import com.banking.tcs.bean.User;
import com.banking.tcs.service.CustomerService;
import com.banking.tcs.util.ShowStatus;

public class SearchCustomerController extends HttpServlet{
	
	public void doGet(HttpServletRequest req, HttpServletResponse res){
		
		String typeOfSearch = req.getParameter("type_of_search");
		
		HttpSession session = req.getSession(false);
		
		if(session != null){
			
			User user = (User)session.getAttribute("executive");
			
			PrintWriter pw;
			
			try {
				pw = res.getWriter();
				
				if(user != null){
					//Get Customer Object
					
					int ssnID = Integer.parseInt(req.getParameter("cus_ssn_id"));
					
					if(ssnID > 0){
						
						CustomerService customerService = new CustomerService();
						
						Customer cust = customerService.getDetails(ssnID);
						
						if(cust != null){
							System.out.println("Name "+cust.getName());
							System.out.println("SSN "+cust.getSsn());
							req.setAttribute("customer_details", cust);
							
							if(typeOfSearch != null){
								
								if(typeOfSearch.equals("for_update")){
									
									req.getRequestDispatcher("/updateCustomer.jsp").forward(req, res);
									
								}else if(typeOfSearch.equals("for_delete")){
									
									req.getRequestDispatcher("/deleteCustomer.jsp").forward(req, res);
									
								}
							}
							
							
						}else{
//							pw.println("Customer not found !!");
							ShowStatus.showStatus(
									req, 
									res, 
									"Customer not found", 
									"error"
									);
						}
						
						
					}else{
//						pw.println("Please enter valid SSN");
						ShowStatus.showStatus(
								req, 
								res, 
								"Please enter valid SSN", 
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

}
