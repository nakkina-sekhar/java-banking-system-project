<%@page import="java.util.List"%>
<%@page import="com.jspiders.dto.SenderDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel = "stylesheet" href = "External.css"></link>
</head>
<body>

<% String username=(String)session.getAttribute("un"); %>

 <%  List<SenderDTO> list=(ArrayList<SenderDTO>)request.getAttribute("list"); 
 %>
 <div style = "float:right">
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
 <center>
 <h1 style = "font-size : 30px; font-family : cursive;margin-left : 200px;margin-top : 100px">
 Your Transaction Between <%=request.getAttribute("startDate") %> And <%=request.getAttribute("endDate") %>
</h1>
</center>
 <center>
 <table border="4" bordercolor="#ffffff" style = "font-size : 30px;margin-top : 100px; font-weight : bold; color :yellow;
 padding:40px;">
		<tr>
			<th>Transaction ID</th>
			<th>Description</th>
			<th>Balance</th>
			<th>Date</th>
		</tr><%if(list!=null){ 
			for (SenderDTO senderdto : list) {
				
		%>	<tr>
		<td><%=senderdto.getTid()%></td>
			<td><%=senderdto.getDescription()%></td>
			<td><%=senderdto.getBalance()%></td>
			<td><%=senderdto.gettDate()%></td>
		</tr>
		<%
			}
		}
		%>
		</table>
</center>	
</body>
</html>