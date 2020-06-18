package com.banking.tcs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.banking.tcs.bean.Transaction;
import com.banking.tcs.util.DBConnection;

public class TransactionDAOImpl implements TransactionDAO {
	
	private Connection connection = null;
	private PreparedStatement prst1 = null;
	private PreparedStatement prst2 = null;
	private ResultSet resultSet = null;

	@Override
	public String createTransaction(Transaction trans) {
		// TODO Auto-generated method stub
		
		try {
			connection = DBConnection.getConnection();
			
			String query = "INSERT INTO transactions(ws_trans_id, ws_cust_id, ws_accnt_id, ws_accnt_type, ws_tgt_accnt_id, ws_tgt_typ, ws_amount, ws_description) "
					+ "VALUES('"+trans.getTransID()+"', '"+trans.getCustID()+"', '"+trans.getAccID()+"', '"+trans.getAccType()+"', '"+trans.getTgtAccID()+"', '"+trans.getTgtAccType()+"', '"+trans.getAmount()+"', '"+trans.getDescription()+"');";
			
			prst1 = connection.prepareStatement(query);
			
			prst1.executeUpdate();
			
			String query1 = "SELECT ws_trxn_timestamp FROM transactions WHERE ws_trans_id = '"+trans.getTransID()+"';";
			
			prst2 = connection.prepareStatement(query1);
			
			resultSet = prst2.executeQuery();
			
			String timestamp = null;
			
			while(resultSet != null && resultSet.next()){
				
				timestamp = resultSet.getString("ws_trxn_timestamp");
			}
			
			if(timestamp != null){
				return timestamp;
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

	@Override
	public List<Transaction> getLastTransactions(int accID, int limit) {
		// TODO Auto-generated method stub
		
		try {
			connection = DBConnection.getConnection();
			
			String query = "select * from transactions "
					+ "where ws_accnt_id = '"+accID+"' OR ws_tgt_accnt_id = '"+accID+"' "
							+ "order by ws_trxn_timestamp DESC limit "+limit+";";
			
			prst1 = connection.prepareStatement(query);
			
			resultSet = prst1.executeQuery();
			
			List<Transaction> transactions = new ArrayList<>();
			
			while(resultSet != null && resultSet.next()){
				
				int transID = resultSet.getInt("ws_trans_id");
				int custID = resultSet.getInt("ws_cust_id");
				String accType = resultSet.getString("ws_accnt_type");
				int transAccID = resultSet.getInt("ws_accnt_id");
				String description = resultSet.getString("ws_description");
				int amount = resultSet.getInt("ws_amount");
				String tgtAccType = resultSet.getString("ws_tgt_typ");
				int tgtAccID = resultSet.getInt("ws_tgt_accnt_id");
				String timestamp = resultSet.getString("ws_trxn_timestamp");
				
				transactions.add(
						new Transaction(transID, custID, transAccID, accType, tgtAccID, tgtAccType, amount, description, timestamp)
						);
				
			}
			
			if(transactions.size() > 0){
				return transactions;
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

	@Override
	public List<Transaction> getTransactions(int accID, String start, String end) {
		// TODO Auto-generated method stub
		
		try {
			connection = DBConnection.getConnection();
			
			String query = "select * from transactions "
					+ "where (ws_trxn_timestamp >= '"+start+"' and ws_trxn_timestamp <= '"+end+"') "
					+ "and (ws_accnt_id = '"+accID+"' or ws_tgt_accnt_id='"+accID+"');";
			
			prst1 = connection.prepareStatement(query);
			
			resultSet = prst1.executeQuery();
			
			List<Transaction> transactions = new ArrayList<>();
			
			while(resultSet != null && resultSet.next()){
				
				int transID = resultSet.getInt("ws_trans_id");
				int custID = resultSet.getInt("ws_cust_id");
				String accType = resultSet.getString("ws_accnt_type");
				int transAccID = resultSet.getInt("ws_accnt_id");
				String description = resultSet.getString("ws_description");
				int amount = resultSet.getInt("ws_amount");
				String tgtAccType = resultSet.getString("ws_tgt_typ");
				int tgtAccID = resultSet.getInt("ws_tgt_accnt_id");
				String timestamp = resultSet.getString("ws_trxn_timestamp");
				
				transactions.add(
						new Transaction(transID, custID, transAccID, accType, tgtAccID, tgtAccType, amount, description, timestamp)
						);
				
			}
			
			if(transactions.size() > 0){
				return transactions;
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
