<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transaction History</title>
<link rel = "stylesheet" href = "External.css"></link>
</head>
<body>
			
				<% String username = (String)session.getAttribute("un"); %>
				<div style = "float : right;">
				<strong><%= username%></strong>
				<br></br>
				<form action = "LogoutController" method = "get" style = "margin-top : -10px;">
				<input type = "submit" value = "LOGOUT" style = "height : 80px;width : 180px;border-radius : 40px;
				margin-left : 40px;margin-top : 10px;"></input>
				</form>
				</div>
				
				<form action="DisplayName.jsp">
				<input type = "Submit" value = "HOME" style = "border-radius : 30px; height : 80px;"></input>
				</form>
					
				<center>
					<h1 style = "margin-top : 100px;">VIEW TRANSACTION HISTORY</h1>
					<form method="post" action="ViewStatementController">
						<table style = "margin-top : 100px;margin-left : 50px;">
						<tr>
							<td><label>StartDate(YYYY-MM-DD) : </label></td>
							<td><input name = "std"></input></td>
						</tr>
						<tr>
							<td><label>EndDate(YYYY-MM-DD) : </label></td>
							<td><input name = "end"></input></td>
						</tr>
						<tr>
							<td></td>
							<td><input type = "submit" value = "VIEW"></input></td>
						</tr>
						</table>
					</form>
					<%
					String message = (String)request.getAttribute("msg");
					if(message != null)
					{
				%>
					<center>
							<strong style = "margin-left :100px;"><%= message%></strong>
					</center>
				<%
					}
					%>
				</center>
</body>
</html>