<%@ page import="java.util.*,com.employee_management.entity.*"
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
	<h1>List of Employees</h1>
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
				</tr>
			</thead>
			<%
			List<Employee> list =(List<Employee>) request.getAttribute("list");
			for(Employee e: list){
				%>
				<tr>

					<td><%= e.getEmployeeid()%></td>
					<td><%= e.getEmployeename() %></td>
					<td><%= e.getEmail()%></td>
					<td><%= e.getDepartmentname()%></td>
					<td><%= e.getReportingmanager()%></td>
					<td><%= e.getSalary()%></td>
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