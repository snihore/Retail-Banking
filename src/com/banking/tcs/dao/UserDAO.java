package com.banking.tcs.dao;

import com.banking.tcs.bean.User;

public interface UserDAO {
	
	//Login Cashier and Customer Executive
	public String login(User user, String type);

}
