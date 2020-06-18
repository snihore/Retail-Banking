package com.banking.tcs.bean;

public class Account {

	private int accountNum;
	private int customerID;
	private String accountType;
	private int balance;
	private String creationDate;
	private String lastUpdatedDate;
	private String accountStatus;
	private String accountMsg;
	
	
	
	public Account() {
		super();
		this.accountNum = 0;
		this.customerID = 0;
		this.accountType = "";
		this.balance = 0;
		this.creationDate = "";
		this.lastUpdatedDate = "";
		this.accountStatus = "";
		this.accountMsg = "";
	}



	public Account(int accountNum, int customerID, String accountType, int balance, String creationDate,
			String lastUpdatedDate, String accountStatus, String accountMsg) {
		super();
		this.accountNum = accountNum;
		this.customerID = customerID;
		this.accountType = accountType;
		this.balance = balance;
		this.creationDate = creationDate;
		this.lastUpdatedDate = lastUpdatedDate;
		this.accountStatus = accountStatus;
		this.accountMsg = accountMsg;
	}



	public int getAccountNum() {
		return accountNum;
	}



	public void setAccountNum(int accountNum) {
		this.accountNum = accountNum;
	}



	public int getCustomerID() {
		return customerID;
	}



	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}



	public String getAccountType() {
		return accountType;
	}



	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}



	public int getBalance() {
		return balance;
	}



	public void setBalance(int balance) {
		this.balance = balance;
	}



	public String getCreationDate() {
		return creationDate;
	}



	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}



	public String getLastUpdatedDate() {
		return lastUpdatedDate;
	}



	public void setLastUpdatedDate(String lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}



	public String getAccountStatus() {
		return accountStatus;
	}



	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}



	public String getAccountMsg() {
		return accountMsg;
	}



	public void setAccountMsg(String accountMsg) {
		this.accountMsg = accountMsg;
	}
	
	public String toString(){
		
		String str = this.getAccountNum()+"___"
					+ ""+this.getCustomerID()+"___"
					+ ""+this.getAccountType()+"___"
					+ ""+this.getBalance()+"___"
					+ ""+this.getCreationDate()+"___"
					+ ""+this.getLastUpdatedDate()+"___"
					+ ""+this.getAccountStatus()+"___"
					+ ""+this.getAccountMsg();
		
		return str;
	}
	
	public static Account getAccountFromString(String str){
		
		if(str != null){
			
			String[] arr = str.split("___");
			
			if(arr.length == 8){
				
				try{
					
					int accountNum = Integer.parseInt(arr[0]);
					int customerID = Integer.parseInt(arr[1]);
					String accountType = arr[2];
					int balance = Integer.parseInt(arr[3]);
					String creationDate = arr[4];
					String lastUpdatedDate = arr[5];
					String accountStatus = arr[6];
					String accountMsg = arr[7];
					
					return new Account(accountNum, customerID, accountType, balance, creationDate, lastUpdatedDate, accountStatus, accountMsg);
					
					
				}catch(Exception e){
					e.printStackTrace();
					return new Account();
				}
				
			}else{
				return new Account();
			}
		}
		
		return new Account();
	}
	
	
}
