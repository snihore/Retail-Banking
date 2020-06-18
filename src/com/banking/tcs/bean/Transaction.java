package com.banking.tcs.bean;

public class Transaction {

	private int transID;
	private int custID;
	private int accID;
	private String accType;
	private int tgtAccID;
	private String tgtAccType;
	private int amount;
	private String description;
	private String timestamp;
	
	public Transaction() {
		super();
	}

	public Transaction(int transID, int custID, int accID, String accType, int tgtAccID, String tgtAccType, int amount,
			String description, String timestamp) {
		super();
		this.transID = transID;
		this.custID = custID;
		this.accID = accID;
		this.accType = accType;
		this.tgtAccID = tgtAccID;
		this.tgtAccType = tgtAccType;
		this.amount = amount;
		this.description = description;
		this.timestamp = timestamp;
	}

	public int getTransID() {
		return transID;
	}

	public void setTransID(int transID) {
		this.transID = transID;
	}

	public int getCustID() {
		return custID;
	}

	public void setCustID(int custID) {
		this.custID = custID;
	}

	public int getAccID() {
		return accID;
	}

	public void setAccID(int accID) {
		this.accID = accID;
	}

	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

	public int getTgtAccID() {
		return tgtAccID;
	}

	public void setTgtAccID(int tgtAccID) {
		this.tgtAccID = tgtAccID;
	}

	public String getTgtAccType() {
		return tgtAccType;
	}

	public void setTgtAccType(String tgtAccType) {
		this.tgtAccType = tgtAccType;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	
	
}
