<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ include file = "header2.jsp" %>

<div class="container">
    
    <h2 class="mt-3 text-center">Select Account</h2>

    <div class = "text-center mt-5">
        <form method="post" action="">
            <table style="width:35%" align="center" class="table_form text-left">
                <tr>
                  <td><label>Account ID</label></td>
                  <td>
                      
                    <select name="cust_acc_id" id="cust_acc">
                        <option value="Select">123456789</option>
                        <option value="Savings">987654321</option>
                        
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