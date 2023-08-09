<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transfer Money</title>
<link rel = "stylesheet" href = "External.css"></link>
</head>
<body>
		<div style = "float:right">
			<form action = "LogoutController" method = "get">
			<input type = "submit" value = "LOGOUT" style = "height : 80px;width : 180px;border-radius : 40px;
			margin-left : 40px;margin-top : 10px;"></input>
			</form>
			</div>
		<form action="DisplayName.jsp">
				<input type = "Submit" value = "HOME" style = "border-radius : 30px; height : 80px;"></input>
			</form>
		
		<% String name = (String)session.getAttribute("un"); %>
		
		<center>
			<h1>UserName : <%= name%></h1>
			<marquee scrollamount = "20"><h1 style = "color : mediumspringgreen; font-family : cursive;">
			Money Transfer Service</h1></marquee>
			<form action="MoneyTransferController" method = "post" style = "margin-top : 30px;">
			<table style = "margin-top : 70px; margin-left : 100px;">
				<tr>
					<td><label>To Account No : </label></td>
					<td><input name = "an"></input></td>
				</tr>
				<tr>
					<td><label>Amount : </label></td>
					<td><input name = "amt"></input></td>
				</tr>
				<tr>
					<td><label>Description :</label></td>
					<td><textarea name = "description"></textarea></td>
				</tr>
				<tr>
					<td></td>
					<td><input type = "submit" value = "Transfer"></input></td>
				</tr>
			</table>
			</form>
		</center>
		
		<%
			String message = (String)request.getAttribute("msg");
			String validMsg = (String) request.getAttribute("valid");
			if(message != null)
			{
		%>
			<center>
			<h1 style = "color : red;"><%= message%></h1>
			</center>
			
		<%
			}
			if(validMsg != null)
			{
		%>
			<center>
			<h1 style = "color:lime;">Money Transfer Successful!!!</h1>
			<h1>Transaction ID : <%= validMsg%></h1>
			</center>
		<%
			}
		%>
</body>
</html>

















