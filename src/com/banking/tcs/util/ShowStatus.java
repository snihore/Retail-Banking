package com.banking.tcs.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowStatus {
	
	public static void showStatus(HttpServletRequest req, HttpServletResponse res ,String msg, String type){
		
		try{
			
			req.setAttribute("message", msg);
			
			if(type.equals("success")){
				
				req.getRequestDispatcher("/success.jsp").forward(req, res);
				
			}else if(type.equals("error")){
				
				req.getRequestDispatcher("/error.jsp").forward(req, res);
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
