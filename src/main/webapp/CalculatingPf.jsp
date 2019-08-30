<%@ page
	import="java.sql.*,java.util.*,com.example.demo.entity.*,com.example.demo.repository.*"
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of employees pf</title>
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
	<h1>PF of Employees</h1>
	<br>
	<br>
	<form>
		<table border="1" align="center">
			<thead>
				<tr>

					<th>Employee id</th>
					<th>Employee name</th>
					<th>Email</th>
					<th>Department name</th>
					<th>Reporting manager</th>
					<th>Salary</th>
					<th>pf</th>
				</tr>
			</thead>
			<%
			ArrayList<Employee> list = (ArrayList<Employee>) request.getAttribute("list");

				for(Employee e: list){
				%>
			<tr>

				<td><%= e.getEmployeeid()%></td>
				<td><%= e.getEmployeename() %></td>
				<td><%= e.getEmail()%></td>
				<td><%= e.getDepartmentname()%></td>
				<td><%= e.getReportingmanager()%></td>
				<td><%= e.getSalary()%></td>
				<td><%= (e.getSalary()/100)*5%></td>
			</tr>
			<%
			}
			%>
		</table>
	</form>
	<a href="AdminOperations.jsp">Back</a>
	<a href="login.jsp">Logout</a>
</body>
</html>