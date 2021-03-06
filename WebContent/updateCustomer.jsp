<%@page import="com.banking.tcs.bean.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Update Customer</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Alfa+Slab+One">
    <link rel="stylesheet" href="assets/css/styles.css">
    <script type="text/javascript" src="assets/js/banking.js"></script>
</head>

<body class="text-justify">
  <nav class="navbar navbar-light navbar-expand-md bg-dark" style="height: 130px;margin: auto;">
      <div class="container-fluid"><button data-toggle="collapse" class="navbar-toggler" data-target="#navcol-2"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
          <div class="collapse navbar-collapse" id="navcol-2">
              <ul class="nav navbar-nav">
                  <li class="nav-item" role="presentation"></li>
                  <li class="nav-item" role="presentation"></li>
                  <li class="nav-item" role="presentation"></li>
              </ul>
          </div><a class="navbar-brand" href="#" style="opacity: 1;font-family: 'Alfa Slab One', cursive;color: rgba(248,180,6,0.9);width: 0px;margin: auto;margin-top: 20px;">FedChoice Bank&nbsp;</a>
          <nav class="navbar navbar-light navbar-expand-md bg-warning text-center"
              style="width: 80%;margin: auto;margin-top: 90px;height: 40px;margin-right: 10%;">
              <div class="container-fluid"><button data-toggle="collapse" class="navbar-toggler" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
                  <div class="collapse navbar-collapse" id="navcol-1">
                      <ul class="nav navbar-nav">
                          <li class="nav-item" role="presentation"><a class="nav-link" href="HomePage.jsp"><strong>Home</strong></a></li>

                          <li class="nav-item dropdown">
                              <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <strong>Customer Management</strong>
                              </a>
                              <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="CreateCustomer.html">Create Customer</a>
                                <a class="dropdown-item" href="SearchCustomer.html">Update Customer</a>
                                <a class="dropdown-item" href="SearchCustomerForDelete.html">Delete Customer</a>
                              </div>
                            </li>


                            <li class="nav-item dropdown">
                              <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <Strong>Account Management</Strong>
                              </a>
                              <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="CreateAccount.html">Create Account</a>
                                <a class="dropdown-item" href="SearchAccount.html">Delete Account</a>
                              </div>
                            </li>

                            <li class="nav-item dropdown">
                              <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <strong>Status Details</strong>
                              </a>
                              <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="statusCustomer.jsp">Customer Status</a>
                                <a class="dropdown-item" href="statusAccount.jsp">Account Status</a>
                              </div>
                            </li>


                            <li class="nav-item dropdown">
                              <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <strong>Account Operations</strong>
                              </a>
                              <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="AccountDetails.jsp">Action</a>
                                <a class="dropdown-item" href="AccountStatement.jsp">Another action</a>
                              </div>
                            </li>
                          <li class="nav-item" role="presentation"><a class="nav-link" href="#"><strong>Logout</strong></a></li>
                      </ul>
                  </div>
              </div>
          </nav>
      </div>
  </nav>
  

    <div class="container">
    
    <h2 class="mt-3 text-center">Update Customer</h2>

    <div class = "text-center mt-5">
        <form method="post" action="update_customer" onsubmit="return update_customer()">
        	<% 
            		Customer cust = (Customer)request.getAttribute("customer_details"); 
            %>
        	<input type="hidden" name="cust_ssn" value=<%= String.valueOf(cust.getSsn())%> />
            <table style="width:35%" align="center" class="table_form text-left">
                <tr>
                    <td><label>Customer SSN id</label></td>
                    <td><label><%= cust.getSsn() %></label></td>
                    
                  </tr>
                <!--<tr>
                  <td><label>Customer id</label></td>
                  <td><label>Use jsp expression</label></td>
                  
                </tr>-->
                <tr>
                  <td><label>Old Customer Name</label></td>
                  <td>
                      
                    <label><%= cust.getName() %></label>
                
                </td>
                  
                </tr>

                <tr>
                    <td><label class="required">New Customer Name</label></td>
                    <td><input type="text" id="new_cus_name" name="new_cus_name" required></td>
                    
                  </tr>


                  <tr>
                    <td><label>Old Address</label></td>
                    <td><label><%= cust.getAddress() %></label></td>
                    
                  </tr>

                  <tr>
                    <td><label class="required">New Address</label></td>
                    <td><input type="text" id="new_address" name="new_cus_add" required></td>
                    
                  </tr>

                  <tr>
                    <td><label>Old Age</label></td>
                    <td><label><%= cust.getAge() %></label></td>
                    
                  </tr>

                  <tr>
                    <td><label class="required">New Age</label></td>
                    <td><input type="text" id="new_age" name="new_cus_age" required></td>
                    
                  </tr>

                 
                  <tr><td><span class="text-danger">(*)Fields are Compulsory</span></td></tr>
                  <tr>

                  <td>
                    <td><button type ="Submit" class="button_custom">Update</button></td>
                    
                  </td>
                </tr>
                
              </table>

        </form>
    </div>
</div>
<footer id ="footerborder" class="section footer-classic context-dark bg-image" style="background: #181818;">
  <div class="container mt-4">
    <div class="row row-30">
      <div class="col-md-4 col-xl-5">
        <div class="pr-xl-4 mt-3">
          <h4 style="color: rgba(248,180,6,0.9)">About Us</h4>
          <p>FedChoice Bank was founded on 14th June 2016 with
             the objective of providing with the detai services 
             based on Reatil Banking operations.The Retail internet
             Banking of FedChoice Bank offers a plethora of products
             and services, to cater its customers by providing certai
             animus services with an easy volving offers and ways to do
            the required job without hurdling the process.</p>
        </div>
      </div>
      <div class="col-md-4 col-xl-3 mt-3">
        <h4 style="color:rgba(248,180,6,0.9)";>Services</h4>
        <p>Retail and Consumer Banking<br>
          Personal Internet Banking<br>
          Corporate Internet Banking<br>
          Debit and Credit Cards</p>

      </div>
      <div class="col-md-4 mt-3">
        <h4 style="color:rgba(248,180,6,0.9)";>Contact Us</h4>
        <p>Email:customer.service@fedchoice.com<br>
          Contact No:022-42406778, 022-54567890<br>
          Address: Corporate Office,Madame Cama Road,<br>
          Nariman Point,Mumbai,Maharashtra 400021</p>
      </div>

    </div>
  </div>
  
</footer>


    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    
</body>

</html>