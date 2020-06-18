package com.banking.tcs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.banking.tcs.bean.Customer;
import com.banking.tcs.util.DBConnection;


public class CustomerDAOImpl implements CustomerDAO{
	
	private Connection connection = null;
	private PreparedStatement prst1 = null;
	private PreparedStatement prst2 = null;
	private ResultSet resultSet = null;
	

	//Implementation of addCustomerDetails() method of CreateCustomerDAO interface
	@Override
	public int addCustomerDetails(Customer customer){
		// TODO Auto-generated method stub
		
		try{
			
			int customerSSN = 0;
			
			connection = DBConnection.getConnection();
			
			//insert the details using bean object and preparedStatement
			prst1 = (PreparedStatement) connection.prepareStatement(
					"INSERT INTO customer(ws_cust_ssn_id, ws_name, ws_age, ws_adrs, ws_city, ws_state, ws_status, ws_msg) VALUES ("
					+ "'"+customer.getSsn()+"', "
					+ "'"+customer.getName()+"', "
					+ "'"+customer.getAge()+"', "
					+ "'"+customer.getAddress()+"', "
					+ "'"+customer.getCity()+"', "
					+ "'"+customer.getState()+"', "
					+ "'"+customer.getStatus()+"', "
					+ "'"+customer.getMsg()+"'"
					+ ");"
					);
			
			
			
			prst1.executeUpdate();
			
			//Retrieve Inserted Data from 'customer' of 'banking' database
			prst2 = (PreparedStatement)connection.prepareStatement(
					"SELECT * FROM customer WHERE ws_cust_ssn_id = '"+customer.getSsn()+"';"
					);
			
			resultSet = prst2.executeQuery();
			
			while(resultSet.next()){
				
				customerSSN = resultSet.getInt("ws_cust_ssn_id");
			}
			
			
			return customerSSN;
		}catch(Exception e){
			e.printStackTrace();
			return -1;
		}finally{
			try {
				DBConnection.closeConnection(connection);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}


	@Override
	public Customer getCustomerDetails(int ssnID){
		// TODO Auto-generated method stub
		
		try{
			connection = DBConnection.getConnection();
			
			prst1 = connection.prepareStatement(
						"SELECT * FROM customer WHERE ws_cust_ssn_id = '"+ssnID+"';"
					);
			
			resultSet = prst1.executeQuery();
			
			Customer cust = new Customer();
			
			while(resultSet.next()){
				cust.setSsn(resultSet.getInt("ws_cust_ssn_id"));
				cust.setName(resultSet.getString("ws_name"));
				cust.setAge(resultSet.getInt("ws_age"));
				cust.setAddress(resultSet.getString("ws_adrs"));
				cust.setCity(resultSet.getString("ws_city"));
				cust.setState(resultSet.getString("ws_state"));
				cust.setStatus(resultSet.getString("ws_status"));
				cust.setMsg(resultSet.getString("ws_msg"));
				
			}
			
			if(cust.getName().matches("") &&
				cust.getAge() == 0 &&
				cust.getAddress().matches("") &&
				cust.getCity().matches("") &&
				cust.getState().matches("") &&
				cust.getMsg().matches("") &&
				cust.getSsn() == 0 &&
				cust.getStatus().matches("")){
				return null;
			}
			
			
			return cust;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			try {
				DBConnection.closeConnection(connection);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}


	@Override
	public boolean updateCustomerDetails(Customer customer) {
		// TODO Auto-generated method stub
		
		try {
			connection = DBConnection.getConnection();
			
			String query = "UPDATE customer SET "
					+ "ws_name = '"+customer.getName()+"', "
					+ "ws_age = '"+customer.getAge()+"', "
					+ "ws_adrs = '"+customer.getAddress()+"', "
					+ "ws_msg = '"+customer.getMsg()+"' "
					+ "WHERE ws_cust_ssn_id = '"+customer.getSsn()+"';";
			
			prst1 = connection.prepareStatement(query);
			
			prst1.executeUpdate();
			
			String query1 = "SELECT ws_name, ws_age, ws_adrs FROM customer "
					+ "WHERE ws_cust_ssn_id = '"+customer.getSsn()+"';";
			
			prst2 = connection.prepareStatement(query1);
			
			resultSet = prst2.executeQuery();
			
			String name = null, addr = null;
			int age = 0;
			
			while(resultSet != null && resultSet.next()){
				
				name = resultSet.getString("ws_name");
				addr = resultSet.getString("ws_adrs");
				age = resultSet.getInt("ws_age");
			}
			
			if(name != null && name.equals(customer.getName()) &&
				addr != null && addr.equals(customer.getAddress()) &&
				age != 0 && age == customer.getAge()){
				return true;
			}
			return false;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
			
		}finally{
			try {
				DBConnection.closeConnection(connection);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}


	@Override
	public boolean deleteCustomerFromDB(int ssn) {
		// TODO Auto-generated method stub
		
		try {
			connection = DBConnection.getConnection();
			
			String query = "DELETE FROM customer where ws_cust_ssn_id = '"+ssn+"';";
			
			prst1 = connection.prepareStatement(query);
			
			int status = prst1.executeUpdate();
			
			System.out.println("DELETE STATUS: "+status);
			
			if(status > 0){
				return true;
			}
			
			return false;
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return false;
		}finally{
			try {
				DBConnection.closeConnection(connection);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}


	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		
		try {
			connection = DBConnection.getConnection();
			
			prst1 = connection.prepareStatement("SELECT * FROM customer");
			
			resultSet = prst1.executeQuery();
			
			List<Customer> customers = new ArrayList<>();
			
			while(resultSet != null && resultSet.next()){
				
				int ssn = resultSet.getInt("ws_cust_ssn_id");
				String name = resultSet.getString("ws_name");
				int age = resultSet.getInt("ws_age");
				String addr = resultSet.getString("ws_adrs");
				String city = resultSet.getString("ws_city");
				String state = resultSet.getString("ws_state");
				String status = resultSet.getString("ws_status");
				String msg = resultSet.getString("ws_msg");
				
				customers.add(new Customer(ssn, name, age, addr, city, state, status, msg));
				
			}
			
			if(customers.size() > 0){
				return customers;
			}
			
			return null;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally{
			try {
				DBConnection.closeConnection(connection);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	}

}
