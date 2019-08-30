<%@ page import="java.sql.*,java.util.*,com.example.demo.entity.*,com.example.demo.repository.*"
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of employees</title>
</head>
<style>
body {
	border-style: solid;
	border-width: medium;
	background-color: powderblue;
}

h1 {
	text-align: center;
	color: Tomato
}
</style>
<body>
	<h1>List of Leaves</h1>
	<br>
	<br>
	<form>
		<table border="1" align="center">
			<thead>
				<tr>
				    <th>Employee id</th>
				    <th>Name</th>
					<th>Start date</th>
					<th>End date</th>
					<th>Reason</th>
					<th>Status</th>
				</tr>
			</thead>
			<%
			List<Leaves> list =(List<Leaves>) request.getAttribute("list1");
			for(Leaves e: list){
				%>
				<tr>
					<td><%= e.getLeaveid()%></td>
					<td><%= e.getName() %></td>
					<td><%= e.getStartdate()%></td>
					<td><%= e.getEnddate()%></td>
					<td><%= e.getReason()%></td>
					<td><%= e.getStatus()%></td>
					<td><a href="/accept?id=<%=e.getLeaveid()%>">Accept</a></td>
					<td><a href="/reject?id=<%=e.getLeaveid()%>">Reject</a></td>
				</tr>
				<%
			}
			%>
		</table>
	</form>
	<center><a href="ManagerOperations.jsp">Back</a></center>
	<a href="login.jsp">Logout</a>
</body>
</html>