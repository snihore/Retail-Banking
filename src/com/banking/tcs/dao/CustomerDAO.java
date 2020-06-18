package com.banking.tcs.dao;

import java.util.List;

import com.banking.tcs.bean.Customer;

public interface CustomerDAO {
	
	//Signature - Add Customer Details ( insert Customer details into the DB )
	public int addCustomerDetails(Customer customer);
	
	public Customer getCustomerDetails(int ssnID);
	
	public boolean updateCustomerDetails(Customer customer);
	
	public boolean deleteCustomerFromDB(int ssn);
	
	public List<Customer> getAllCustomers();
}
