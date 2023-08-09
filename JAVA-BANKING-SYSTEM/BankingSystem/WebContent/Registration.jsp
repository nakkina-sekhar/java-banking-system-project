<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
<link rel = "stylesheet" href = "External.css"></link>
</head>
<body>
			<center><h1>Registration Process Of Bank Of Jspiders!</h1>
					<form action="RegistrationController" method = "post" >
					<table style = "margin-top : 30px;">
						<tr>
							<td><label>First Name : </label></td>
							<td><input name = "fn"></input></td>
						</tr>
						<tr>
							<td><label>Last Name : </label></td>
							<td><input name = "ln"></input></td>
						</tr>
						<tr>
							<td><label>Mobile : </label></td>
							<td><input name = "mob"></input></td>
						</tr>
						<tr>
							<td><label>Aadhar Card No : </label></td>
							<td><input name = "aadhar"></input></td>
						</tr>
						<tr>
							<td><label>Pan Card : </label></td>
							<td><input name = "pancard"></input></td>
						</tr>
						<tr>
							<td><label>Email-Id : </label></td>
							<td><input type = "email" name = "mail"></input></td>
						</tr>
						<tr>
							<td><label>Address :</label></td>
							<td><textarea name = "addr"></textarea></td>
						</tr>
						<tr>
							<td><label>Date of Birth :</label></td>
							<td><input type = "date" name = "dob"></input></td>
						</tr>
						<tr>
							<td><label>Gender : </label></td>
							<td><input type = "radio" name = "abc" class = "r">&nbsp&nbsp<label>Male</label></input>
							<input type = "radio" name = "abc" class = "r">&nbsp&nbsp<label>Female</label></input></td>
						</tr>
						<tr>
							<td><label>Type of Account</label></td>
							<td><input type = "radio" name = "type" class = "r">&nbsp&nbsp<label>SB</label></input>
							&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
							<input type = "radio" name = "type" class = "r">&nbsp&nbsp<label>FD</label></input></td>
						</tr>
						<tr>
							<td></td>
							<td><input type = "radio" name = "type" class = "r">&nbsp&nbsp<label>CA</label></input>
							&nbsp&nbsp&nbsp&nbsp&nbsp
							<input type = "radio" name = "type" class = "r">&nbsp&nbsp<label>RD</label></input></td>
						</tr>
						<tr>
							<td><label>Amount :</label></td>
							<td><input placeholder=".rs" name = "amt"></input></td>
						</tr>
						<tr>
							<td><label>Password :</label></td>
							<td><input type = "password" name = "pwd"></input></td>
						</tr>
						<tr>
							<td><label>Confirm Password : </label></td>
							<td><input type = "password" name = "cpwd"></input></td>
						</tr>
						<tr>
							<td><input type = "submit" value = "REGISTER"></td>
							<td><input type = "reset" value = "CLEAR"></td>
						</tr>
						</table>
					</form>
					<a href = "Login.jsp" id = "log">Already Register? Login</a>
			</center>
			<%
				String errormsg= (String)request.getAttribute("msg");
				if(errormsg != null)
				{
			%>
			<center><h1 style = "color : green"><%= errormsg%></h1></center>
			<%
				}
			%>
</body>
</html>








