<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file = "header2.jsp" %>


<div class="container">
    
    <h2 class="mt-3 text-center">Account Statement</h2>

    <div class = "text-center mt-5">
        <form method="post" action="" onsubmit="return account_statement2()">
            <table style="width:35%" align="center" class="table_form text-left">
                <tr>
                    <td><label>Account ID</label></td>
                    <td><label>Use jsp expression</label></td>
                    
                  </tr>

              </table>

        </form>
        
        </div>
      
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
              <tr>
                <td>100000625</td>
                <td>Deposite</td>
                <td>2016-08-13</td>
                <td>100</td>
              </tr>
              
               <tr>
                <td>100000625</td>
                <td>Deposite</td>
                <td>2016-08-13</td>
                <td>100</td>
              </tr>
              
               <tr>
                <td>100000625</td>
                <td>Deposite</td>
                <td>2016-08-13</td>
                <td>100</td>
              </tr>
              
               <tr>
                <td>100000625</td>
                <td>Deposite</td>
                <td>2016-08-13</td>
                <td>100</td>
              </tr>
              
               <tr>
                <td>100000625</td>
                <td>Deposite</td>
                <td>2016-08-13</td>
                <td>100</td>
              </tr>
              
               <tr>
                <td>100000625</td>
                <td>Deposite</td>
                <td>2016-08-13</td>
                <td>100</td>
              </tr>
              
               <tr>
                <td>100000625</td>
                <td>Deposite</td>
                <td>2016-08-13</td>
                <td>100</td>
              </tr>
              
               <tr>
                <td>100000625</td>
                <td>Deposite</td>
                <td>2016-08-13</td>
                <td>100</td>
              </tr>
              
               <tr>
                <td>100000625</td>
                <td>Deposite</td>
                <td>2016-08-13</td>
                <td>100</td>
              </tr>
              
               <tr>
                <td>100000625</td>
                <td>Deposite</td>
                <td>2016-08-13</td>
                <td>100</td>
              </tr>
              
               <tr>
                <td>100000625</td>
                <td>Deposite</td>
                <td>2016-08-13</td>
                <td>100</td>
              </tr>
              
              <tr>
                <td>100000625</td>
                <td>Deposite</td>
                <td>2016-08-13</td>
                <td>100</td>
              </tr>
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

   
   	
    </div>
</div>

<%@ include file = "footer2.jsp" %>