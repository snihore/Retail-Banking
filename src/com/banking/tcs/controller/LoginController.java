package com.banking.tcs.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.banking.tcs.bean.User;
import com.banking.tcs.service.UserService;
import com.banking.tcs.util.ShowStatus;

public class LoginController extends HttpServlet{
	
	public void doPost(HttpServletRequest req, HttpServletResponse res){
		
		String username = req.getParameter("txt_uname");
		String password = req.getParameter("txt_pwd");
		String type = req.getParameter("who_is_login");
		
		System.out.println("1. TYPE::::::::::::::::      "+type);
		
		String timestamp = "";
		
		User user = new User(username, password, timestamp);
		
		UserService userService = new UserService();
		
		try {
			String result = userService.login(user, type);
			
			PrintWriter pw = res.getWriter();
			
			if(result != null){
				HttpSession session = req.getSession();
				
				if((User)session.getValue("cashier") != null){
					session.removeValue("cashier");
				}else if((User)session.getValue("executive") != null){
					session.removeValue("executive");
				}
				
				session.putValue(type, user);
				
				
				req.getRequestDispatcher("/HomePage.jsp").forward(req, res);
			}else{
//				pw.println("Login Failed !!!!!");
				ShowStatus.showStatus(
						req, 
						res, 
						"Login Failed", 
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
