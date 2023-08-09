<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Banking System</title>
<link rel = "stylesheet" href = "External.css"></link>
</head>
<body>
			<div style = "float:right">
			<form action = "LogoutController" method = "get">
			<input type = "submit" value = "LOGOUT" style = "height : 80px;width : 180px;border-radius : 40px;
			margin-left : 40px;margin-top : 10px;"></input>
			</form>
			</div>
			<br></br>
			<%
				String username = (String)session.getAttribute("un");
			%>
			
			<center><h1 style = "margin-left : 300px;">UserName : <em style = "background-color : blue;"><%= username%></em></h1>
			<table>
			<tr>
			<td style = "padding-right : 100px;">
			<form action="ViewBalanceController" method = "post">
				<input type = "submit" value = "VIEW BALANCE"></input>
			</form>
			</td>
			<td  style = "padding-right : 100px;">
			<form action = "Transaction.jsp" method = "post">
				<input type = "submit" value = "MONERY TRANSFER"></input>
			</form>
			</td>
			<td  style = "padding-right : 100px;">
			<form action = "TransactionHistroy.jsp">
				<input type = "submit" value = "VIEW STATEMENTS"></input>
			</form>
			</td>
			<tr>
			</table>
			</center>
</body>
</html>