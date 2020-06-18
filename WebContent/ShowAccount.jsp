<%@page import="com.banking.tcs.bean.Account"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ include file = "header2.jsp" %>
    
    <div class="container">
    
    <h2 class="mt-3 text-center">Account Details</h2>

    <div class = "text-center mt-5">
        <table class="table table-bordered">
            <thead>
              <tr class="bg-warning">
                <th scope="col">Customer ID</th>
                <th scope="col">Account ID</th>
                <th scope="col">Account Type</th>
                <th scope="col">Balance</th>
              </tr>
            </thead>
            <tbody>
              <!-- <tr>
                <td>100000625</td>
                <td>800000019</td>
                <td>Savings</td>
                <td>10000</td>
              </tr>  -->
              <!--These are just demo data, fetch real data and use jsp expression to display them  -->
              
              <%
              	Account acc = (Account) request.getAttribute("account_info");
              
              	if(acc != null){
              		
              		String type = acc.getAccountType();
              		
              		if(type.equals("S")){
              			type = "saving".toUpperCase();
              		}else if(type.equals("C")){
              			type = "current".toUpperCase();
              		}
              		
              		%> 
              		
              		<tr>
		                <td><%= acc.getCustomerID() %></td>
		                <td><%= acc.getAccountNum() %></td>
		                <td><%= type %></td>
		               	<td><%= acc.getBalance() %></td>
		            </tr>
              		
              		<%
              		
              	}
              %>
            </tbody>
          </table>
    </div>
    
    
        <div class = "text-center mt-3">
        <table class="table table-borderless">
            <tbody>
              <tr>
                <td><a href="DepositeMoney.jsp?account_info=<%= acc.toString() %>" class="btn btn-primary button_custom">Deposit Money</a></td>
                <td><a href="WithdrawMoney.jsp?account_info=<%= acc.toString() %>" class="btn btn-primary button_custom">Withdraw Money</a></td>
                <td><a href="TransferMoney.jsp?account_info=<%= acc.toString() %>" class="btn btn-primary button_custom">Transfer Money</a></td>
                
              </tr>
            </tbody>
          </table>
    </div>
    
</div>
    
 <!-- This page has three buttons to deposit, withdraw or transfer money
 	if Deposit money is clicked then this page will redirect to DepositeMoney.jsp
 	if Withdraw money is clicked then this page will redirect to WithdrawMoney.jsp
 	if Transfer money is clicked then this page will redirect to TransferMoney.jsp
 	save Customer ID, Account ID, Account Type and balance in session.
  -->   
<%@ include file = "footer2.jsp" %>