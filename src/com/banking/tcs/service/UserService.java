package com.banking.tcs.service;

import com.banking.tcs.bean.User;
import com.banking.tcs.dao.UserDAO;
import com.banking.tcs.dao.UserDAOImpl;

public class UserService {
	
	public String login(User user, String type) throws Exception{
		
		UserDAO userDAO = new UserDAOImpl();
		
		return userDAO.login(user, type);
		
	}

}
