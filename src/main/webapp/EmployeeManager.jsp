<%@ page import="java.sql.*,java.util.*,com.employee_management.entity.*,com.employee_management.repository.*"
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
	<h1>List of Employees Reporting To Specific Manager</h1>
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
			ArrayList<String> list = (ArrayList<String>) request.getAttribute("list");//list.readEntity(ArrayList.class);
	            //out.print(list);

				for(String e: list){
				%>
				<tr>
					<td><%= e%></td>
				</tr>
				<%
			}
			%>
		</table>
	</form>
		<a href="Manager.jsp">Back</a>
	<a href="login.jsp">Logout</a>
</body>
</html>