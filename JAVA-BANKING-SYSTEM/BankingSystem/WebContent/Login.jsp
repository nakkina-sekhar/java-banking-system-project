<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel = "stylesheet" href = "External.css"></link>
</head>
<body>

			<center>
			<h1>LOGIN IN BANK ACCOUNT</h1>
			<form action = "LoginController" method = "post" id = "login">
				<table id = "l">
					<tr>
						<td><label>Account Number : </label></td>
					    <td><input name = "an"></input></td>
					</tr>
					<tr>
						<td><label>Password :</label></td>
						<td><input type = "password" name = "pwd"></input></td>
					</tr>
					<tr>
						<td></td>
						<td><center></center><input type = "submit" value = "LOGIN"></input></center></td>
					</tr>
				</table>
			</form>
				<a href = "Registration.jsp" id = "log">Not yet Registered?</a>
			</center>
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
</body>
</html>












