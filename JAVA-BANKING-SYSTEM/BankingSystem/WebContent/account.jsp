<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Account Number</title>
</head>
<body style = "background-color : cyan;">

		<h1 style = "font-size : 50px;"><marquee>WELCOME TO BANK OF JSPIDERS!!!</marquee></h1>
		<%
			String accountNumber = (String)request.getAttribute("accNo");
		%>
		<center>
		<h2 style = "color : green;">Your Registration is completed successfully & A/C Number is 
		<mark><%= accountNumber%></mark></h2>
		
		</center>
</body>
</html>