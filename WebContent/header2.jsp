<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Cashier</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Alfa+Slab+One">
    <link rel="stylesheet" href="assets/css/styles.css">
    <script type="text/javascript" src="assets/js/banking.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.22/pdfmake.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/html2canvas/0.4.1/html2canvas.min.js"></script>
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
						  <li class="nav-item" role="presentation"><a class="nav-link" href="AccountDetails.jsp"><strong>Account Details</strong></a></li>
						  <li class="nav-item" role="presentation"><a class="nav-link" href="AccountStatement.jsp"><strong>Account Statement</strong></a></li>
                          <li class="nav-item" role="presentation"><a class="nav-link" href="#"><strong>Logout</strong></a></li>
                      </ul>
                  </div>
              </div>
          </nav>
      </div>
  </nav>

