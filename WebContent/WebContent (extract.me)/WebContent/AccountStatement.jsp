<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file = "header2.jsp" %>


<div class="container">
    
    <h2 class="mt-3 text-center">Account Statement</h2>

    <div class = "text-center mt-5">
        <form method="post" action="" onsubmit="return account_statement()">
            <table style="width:35%" align="center" class="table_form text-left">
                <tr>
                    <td><label>Account ID</label></td>
                    <td><input type="text" id="acc_id" name="account_id" required></td>
                    
                </tr>
                <tr>
                  <td> </td>
                  <td>
                  			<input class="form-check-input" type="radio" name="trans" id="last_trn" value="Last Number of Transactions">
  							<label class="form-check-label" for="exampleRadios2">
    							Last Number of Transactions
  							</label>
                  
                  
                  </td>
                  
                  
                </tr>
                <tr>
                	<td> </td>
                	<td><span class="text-danger">(*) Also Provide Number of &nbsp &nbsp&nbsp&nbsp&nbspTransactions</span></td>
                
                </tr>
                
                
                <tr>
                  <td> </td>
                  <td>
                  			<input class="form-check-input" type="radio" name="trans" id="str_end_date" value="Start-End Dates">
  							<label class="form-check-label" for="exampleRadios2">
    							Start-End Dates
  							</label>
                  
                  
                  </td>
                  
                </tr>

                <tr>
                  <td><label>Number of Transactions</label></td>
                  <td>
                      
                    <select name="num_of_trans" id="no_of_tr">
                          <option value="0">0</option>
                          <option value="1">1</option>
                          <option value="2">2</option>
                          <option value="3">3</option>
                          <option value="4">4</option>
                          
                          
                          <option value="5">5</option>
                          <option value="6">6</option>
                          <option value="7">7</option>
                          <option value="8">8</option>
                          <option value="9">9</option>
                          <option value="10">10</option>
                        </select>
                
                  </td>
                  
                
				</tr>
                


                  <tr>
                  <td> </td>
                    <td> <button type ="Submit" class="button_custom">Submit</button> </td>
                    
                  
                </tr>
                
              </table>

        </form>
    </div>
</div>
<!-- If Number of Number of Transaction is selected then it will display last n number of 
     transactions via "lastntransaction.jsp", else It will be redirected to AccountStatementWithDate.jsp, also save the
     AccountID in session object or pass it through url to AccountStatementWithDate.jsp
-->

<%@ include file = "footer2.jsp" %>