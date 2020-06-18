package com.banking.tcs.service;

import java.util.List;

import com.banking.tcs.bean.Customer;
import com.banking.tcs.dao.CustomerDAO;
import com.banking.tcs.dao.CustomerDAOImpl;

public class CustomerService {
	
	public int createCustomer(Customer customer){
		
		int customerSSN = 0;
		
		CustomerDAO customerDAO = new CustomerDAOImpl();
		
		customerSSN = customerDAO.addCustomerDetails(customer);
		
		return customerSSN;
		
	}
	
	public Customer getDetails(int ssnID){
		
		CustomerDAO customerDAO = new CustomerDAOImpl();
		
		Customer cust = customerDAO.getCustomerDetails(ssnID);
		
		if(cust != null){
			return cust;
		}
		
		return null;
	}
	
	public boolean updateCustomer(Customer customer){
		
		CustomerDAO customerDAO = new CustomerDAOImpl();
		
		return customerDAO.updateCustomerDetails(customer);
	}
	
	public boolean deleteCustomer(int ssn){
		
		CustomerDAO customerDAO = new CustomerDAOImpl();
		
		return customerDAO.deleteCustomerFromDB(ssn);
		
	}
	
	public List<Customer> getAll(){
		CustomerDAO customerDAO = new CustomerDAOImpl();
		
		return customerDAO.getAllCustomers();
		
	}

}
