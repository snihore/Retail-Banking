<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file = "header2.jsp" %>


<div class="container">
    
    <h2 class="mt-3 text-center">Transfer Money</h2>

    <div class = "text-center mt-5">
        <form method="post" action="" onsubmit="return transfer_money()">
            <table style="width:35%" align="center" class="table_form text-left">
                <tr>
                    <td><label>Customer ID</label></td>
                    <td><label>Use jsp expression</label></td>
                    
                </tr>
                <tr>
                  <td><label>Source Account</label></td>
                  <td>
                  		<input type="text" id="saccount" name="source_account" required>
                  </td>
                  
                </tr>
                
                
                <tr>
                  <td><label>Target Account</label></td>
                  <td>
                  		<input type="text" id="Taccount" name="target_account" required>
                  </td>
                  
                </tr>
                
                <tr>
                    <td><label>Transfer Amount</label></td>
                    <td><input type="text" id="Tamount" name="target_amount" required></td>
                    
                </tr>


                  <tr>
                  <td> </td>
                    <td><button type ="Submit" class="button_custom">Transfer</button></td>
                    
                  </td>
                </tr>
                
              </table>

        </form>
    </div>
</div>
<!-- The page goes to the servlet and transfer's the amount from source account to
	 destination account amount with withdraw amount.
	 
	 Status message: “Amount transfer completed successfully” will be generated by TransferedMoney.jsp
	  or in case balance is not enough in source account “Transfer not allowed, please choose smaller amount” 
	 returned as an error page.
 -->


<%@ include file = "footer2.jsp" %>