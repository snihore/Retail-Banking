package com.banking.tcs.bean;

public class User {
	
	private String username;
	
	private String password;
	
	private String timestamp;

	public User() {
		super();
		this.username = "";
		this.password = "";
		this.timestamp = "";
	}

	public User(String username, String password, String timestamp) {
		super();
		this.username = username;
		this.password = password;
		this.timestamp = timestamp;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	
	

}
