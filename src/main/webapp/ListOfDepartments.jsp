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
	<h1>List of Departments</h1>
	<br>
	<br>
	<form>
		<table border="1" align="center">
			<thead>
				<tr>
					<th>Department name</th>
				</tr>
			</thead>
			<%
			List<Employee> list =(List<Employee>) request.getAttribute("list");
			for(Employee e: list){
				%>
				<tr>
					<td><%= e.getDepartmentname()%></td>
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