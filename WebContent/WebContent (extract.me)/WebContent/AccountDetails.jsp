<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file = "header2.jsp" %>

    <div class="container">
    
    <h2 class="mt-3 text-center">Account Details</h2>

    <div class = "text-center mt-5">
        <form method="post" action="" onsubmit="return account_details()">
            <table style="width:35%" align="center" class="table_form text-left">
                <tr>
                  <td><label class="required">Account ID</label></td>
                  <td><input type="text" id="accnid" name="acc_id"></td>
                </tr>


                <tr>
                    <td></td>
                    <td class="text-left" ><h6>OR</h6></td>
                </tr>
                
                
                <tr>
                  <td><label class="required">Enter Customer ID</label></td>
                  <td><input type="text" id="custid" name="cus_id"></td>
                  
                </tr>
                
                  <tr><td><span class="text-danger">(*)Fill either one of the details</span></td>
                  	
                  
                  </tr>
                  <tr>
                  <td></td>
                  <td>
                    <button type ="Submit" class="button_custom">View</button>
                    
                  </td>
                </tr>
                
              </table>

        </form>
    </div>
</div>
<!-- If input account ID is selected then directly display "ShowAccount.jsp" next page but if customer id is 
provided then next will be "SelectAccount.jsp" where user will select account from the list of accounts
then the page will be redirected to "ShowAccount.jsp".
	
 -->

<%@ include file = "footer2.jsp" %>