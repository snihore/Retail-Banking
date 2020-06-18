<%@page import="com.banking.tcs.bean.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Delete Customer</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/styles.css">
</head>

<body id="delcus">
    
    <nav  class="navbar navbar-light navbar-expand-md bg-secondary ">
        <div class="container-fluid"><a class="navbar-brand text-center" href="#" style="margin: auto;margin-left: 45%;">Delete Customer</a><button data-toggle="collapse" class="navbar-toggler" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
            <div
                class="collapse navbar-collapse" id="navcol-1">
                <ul class="nav navbar-nav">
                    <li class="nav-item" role="presentation"></li>
                    <li class="nav-item" role="presentation"></li>
                    <li class="nav-item" role="presentation"></li>
                </ul>
        </div>
        </div>
    </nav>


    <div class = "text-center mt-5">
        <form method="post" action="delete_customer">
        	<% 
            		Customer cust = (Customer)request.getAttribute("customer_details"); 
            %>
            <table style="width:35%" align="center" class="text-left">
                <tr>
                    <td><label>SSN Id</label></td>
                    <td><input class="form-control" type="text" name="ssnid" value=<%= cust.getSsn() %> readonly></td>
                    
                  </tr>
               
                <tr>
                  <td><label>Customer Name</label></td>
                  <td><input class="form-control" name="cust_name" type="text" value=<%= cust.getName() %> readonly></td>
                  
                </tr>
                <tr>
                    <td><label>Age</label></td>
                    <td><input class="form-control" name="cust_age" type="text" value=<%= cust.getAge() %> readonly></td>
                    
                  </tr>




                  <tr>
                    <td><label>Address</label></td>
                    <td><input class="form-control" name="cust_add" type="text" value=<%= cust.getAddress() %> readonly></td>
                    
                  </tr>







                 
                  <tr>
                    <td><button type ="Submit" class="button_del">Delete</button></td>
                    <td class="text-right">
                      <button class="button_can">Cancel</button>
                      
                    </td>
                  </tr>
                
              </table>

        </form>
    </div>


    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
</body>

</html>