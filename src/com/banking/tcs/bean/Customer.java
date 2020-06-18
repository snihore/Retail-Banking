package com.banking.tcs.bean;

public class Customer {
	
	//Customer's SSN ID
	private int ssn;
	//Customer Name
	private String name;
	//Customer Age
	private int age;
	//Customer's Address
	private String address;
	//City
	private String city;
	//State
	private String state;
	//Status
	private String status;
	//MSG
	private String msg;
	
	//Empty Constructor
	public Customer() {
		super();
	}

	

	public Customer(int ssn, String name, int age, String address, String city, String state, String status,
			String msg) {
		super();
		this.ssn = ssn;
		this.name = name;
		this.age = age;
		this.address = address;
		this.city = city;
		this.state = state;
		this.status = status;
		this.msg = msg;
	}



	public int getSsn() {
		return ssn;
	}

	public void setSsn(int ssn) {
		this.ssn = ssn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public String getMsg() {
		return msg;
	}



	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
	
}
