<%@page import="java.util.ArrayList"%>
<%@page import="com.banking.tcs.bean.Transaction"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file = "header2.jsp" %>
<div class="container">
    
    <h2 class="mt-3 text-center">Account Statement</h2>

	<%
	
		int accID = 0;
		try{
			accID = (int)request.getAttribute("account_id");
		}catch(Exception e){
			
		}
		
	
		List<Transaction> transactions = (List<Transaction>)request.getAttribute("date_transactions");
		
		if(transactions == null){
			transactions = new ArrayList<>();
		}else{
			accID = transactions.get(0).getAccID();
		}
	
	%>
    <div class = "text-center mt-5">
        <form method="post" action="account_statement" onsubmit="return account_statement2()">
        	<input type="hidden" name="statement_type" value="date_type"> 
            <table style="width:35%" align="center" class="table_form text-left">
                <tr>
                	<input type="hidden" name="account_id" value=<%= accID %>>
                    <td><label>Account ID</label></td>
                    <td><label><%= accID %></label></td>
                    
                  </tr>
                <tr>
                  <td><label class="required">Start Date</label></td>
                  <td>
                  
                  
                  		<input type="date" id="startdate" name="str_date">
                  		
                  </td>
                  
                </tr>
                <tr>
                  <td><label class="required">End Date</label></td>
                  <td>
                      
                    <input type="date" id="lastdate" name="lst_date">
                
                  </td>
                  
                </tr>



                 
                  <tr><td></td><td><span class="text-danger">(*)Fields are Compulsory</span></td></tr>
                  <tr>

                  <td></td>
                    <td><button type ="Submit" class="button_custom">Show</button></td>
                    
                  
                </tr>
                
              </table>

        </form>
        
        
      </div>
      
   <%
      /*  if ("myvalue".equals(request.getParameter("myparam"))) {
        //http://localhost:8001/Banking/AccountStatementWithDate.jsp?myparam=myvalue
        //the upper link displays the table so after fetching the data
        //pass the data through servlet to jsp along with additional paramter "myparam having 
        //  value "myvalue" and the below table will be visible */
   %>
        <div id ="tableWithAccount" class = "text-center mt-5">
        <table id = "mytable" class="table table-bordered">
            <thead>
              <tr class="bg-warning">
                <th scope="col">Transaction ID</th>
                <th scope="col">Description</th>
                <th scope="col">Date (YYYY-MM-DD)</th>
                <th scope="col">Amount</th>
              </tr>
            </thead>
            <tbody>
             <!--  <tr>
                <td>100000625</td>
                <td>Deposite</td>
                <td>2016-08-13</td>
                <td>100</td>
              </tr> -->
              
              <%
               
               	for(int i=0; i<transactions.size(); i++){
               		
               		%> 
               		
               		<tr>
		                <td><%= transactions.get(i).getTransID() %></td>
		                <td><%= transactions.get(i).getDescription() %></td>
		                <td><%= transactions.get(i).getTimestamp() %></td>
		                <td><%= transactions.get(i).getAmount() %></td>
              		</tr>
               		
               		
               		<%
               	}
               
               %>
            
              
          
              
            </tbody>
          </table>
        <div class = "text-center mt-3">
        <table class="table table-borderless">
            <tbody>
              <tr>
                <td><input type="button" id="btnExport" class= "button_custom" value="Download As PDF File" onclick="Exportaspdf()" /></td>
                <td><input type="button" id="btnExport" class= "button_custom" value="Download As Excel File" onclick="exportTableToExcel('mytable')" /></td>                
              </tr>
            </tbody>
          </table>
         </div>
          
    </div>

   <%
        //} 
        
   %>
   	
</div>


<!-- </div> -->

<%@ include file = "footer2.jsp" %>