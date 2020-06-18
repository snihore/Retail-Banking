<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">

<title>Failed</title>
<script type="text/javascript" src="assets/js/sweetalert.min.js"></script>

</head>
<body>

<%

String message = (String)request.getAttribute("message");

if(message == null){
	message = "";
}

%>

<script type="text/javascript">
swal({
	  title: "Task Failed !",
	  text: "<%= message %>",
	  icon: "error",
	  button: "Ok",
	}).then((value) => {
		 
		 window.location.replace('HomePage.jsp');
	});
	


</script>

</body>
</html>