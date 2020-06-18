<%@page import="com.banking.tcs.bean.Account"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ include file = "header2.jsp" %>


<div class="container">
    
    <h2 class="mt-3 text-center">Amount Transfer Completed Successfully</h2>

    <div class = "text-center mt-5">
        <form method="post" action="">
            <table style="width:35%" align="center" class="table_form text-left">
            
            	<%
            		Account acc = (Account)request.getAttribute("account_info");
            		int oldBalance = (int)request.getAttribute("old_balance");
            		int targetAccNum = (int)request.getAttribute("target_acc_num");
            	
            		if(acc == null){
            			acc = new Account();
            		}
            		
					String type = acc.getAccountType();
              		
              		if(type.equals("S")){
              			type = "saving".toUpperCase();
              		}else if(type.equals("C")){
              			type = "current".toUpperCase();
              		}
            		
	              
	              %>
                <tr>
                    <td><label>Source Account ID</label></td>
                    <td><label><%= acc.getAccountNum() %></label></td>
                    
                </tr>
                <tr>
                  <td><label>Target Account ID</label></td>
                  <td><label><%= targetAccNum %></label></td>
                  
                </tr>

                <tr>
                  <td><label>Source Old Balance</label></td>
                  <td>
                      
                    <label><%= oldBalance %></label>
                
                  </td>
                  
                
				</tr>
                <tr>
                    <td><label>Current Source Balance</label></td>
                    <td><label><%= acc.getBalance() %></label></td>
                    
                </tr>


                  <tr>
                  <td> </td>
                    <td></td>
                    
                  </td>
                </tr>
                
              </table>

        </form>
    </div>
</div>

<%@ include file = "footer2.jsp" %>