<%@page import="java.util.ArrayList"%>
<%@page import="com.banking.tcs.bean.Account"%>
<%@page import="java.util.List"%>
<%@page import="com.banking.tcs.service.AccountService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ include file = "header2.jsp" %>

<div class="container">
    
    <h2 class="mt-3 text-center">Select Account</h2>

    <div class = "text-center mt-5">
        <form method="post" action="get_account_detail">
        	
        
        	<%
        		AccountService accountService = new AccountService();
        	
        		String type = (String)request.getAttribute("search_type");
        		int id = (int)request.getAttribute("search_id");
        		
        		List<Account> accounts = null;
        		
        		if(id != 0 && !type.matches("")){
        			accounts =  accountService.searchAccount(type, id);
        			
        		}
        	%>
            <table style="width:35%" align="center" class="table_form text-left">
                <tr>
                  <td><label>Account ID</label></td>
                  <td>
                      
                    <select name="cust_acc_id" id="cust_acc">
                        <!-- <option value="Select">123456789</option>
                        <option value="Savings">987654321</option>  -->
                        
                        <%
                        
	                        if(accounts != null){
	                        	for(int i=0; i<accounts.size(); i++){
	                        		
	                        		%>
	                        		
	                        		 <option value=<%= accounts.get(i).getAccountNum() %>><%= accounts.get(i).getAccountNum() %></option>
	                        		 
	                        		<%
	                        		
	                        	}
	            			}
                        	
                        %>
                        
                    </select>
                    <!--Fetch account details by joining customer and account table and get the account id's of customer
                        and loop through the  <option> tag to print all the accounts in jsp pages, if no account found then 
                        return a simple page saying no account is linked to the customer
                        
                    -->
                </td>
                </tr>

                
                  <tr>
                  <td></td>
                  <td>
                    <button type ="Submit" class="button_custom">Show Account Details</button>                    
                  </td>
                </tr>
                
              </table>

        </form>
    </div>
</div>


<%@ include file = "footer2.jsp" %>