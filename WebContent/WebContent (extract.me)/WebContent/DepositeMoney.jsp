<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ include file = "header2.jsp" %>
<div class="container">
    
    <h2 class="mt-3 text-center">Deposit Money</h2>

    <div class = "text-center mt-5">
        <form method="post" action="" onsubmit="return deposit_money()">
            <table style="width:35%" align="center" class="table_form text-left">
                <tr>
                    <td><label>Customer ID</label></td>
                    <td><label>Use jsp expression</label></td>
                    
                </tr>
                <tr>
                  <td><label>Account ID</label></td>
                  <td><label>Use jsp expression</label></td>
                  
                </tr>
                <tr>
                  <td><label>Account Type</label></td>
                  <td>
                      
                    <label>use jsp expression</label>
                
                  </td>
                  
                </tr>
                <tr>
                  <td><label>Balance</label></td>
                  <td>
                      
                    <label>use jsp expression</label>
                
                  </td>
                  
                
				</tr>
                <tr>
                    <td><label>Deposit Amount</label></td>
                    <td><input type="text" id="damount" name="deposit_amount" required></td>
                    
                </tr>


                  <tr>
                  <td> </td>
                    <td><button type ="Submit" class="button_custom">Submit</button></td>
                    
                  </td>
                </tr>
                
              </table>

        </form>
    </div>
</div>
<!-- The page goes to the selvlet and adds the deposit amount to current amount. 
	 When the amount is added then "DepositedAmount.jsp" is returned else return an
	 error page.
 -->

<%@ include file = "footer2.jsp" %>