<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Balance Status</title>
<link rel = "stylesheet" href = "External.css"></link>
</head>
<body>

			<%
				String username = (String)session.getAttribute("un");
			%>
			<div style = "float : right;">
			<strong><%= username%></strong>
			<br></br>
			<form action = "LogoutController" method = "get">
			<input type = "submit" value = "LOGOUT" style = "height : 80px;width : 180px;border-radius : 40px;
			margin-left : 40px;margin-top : 10px;"></input>
			</form>
			</div>
			
			<form action="DisplayName.jsp">
				<input type = "Submit" value = "HOME" style = "border-radius : 30px; height : 80px;"></input>
			</form>
			<%
				double balance = (Double)request.getAttribute("balance");
			%>
			<center>
					<h1 style = "margin-top : 300px;">Your Balance Rs: <%= balance%></h1>
			</center>
</body>
</html>