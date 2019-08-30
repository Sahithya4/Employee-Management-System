<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete employee</title>
<style type="text/css">
body {background-color:light grey}
  h1 {text-align: center;color:blue;}
  </style>
</head>
<script type="text/javascript">
	function msg() {
		if (document.getElementById("id").value.length == 0) {
			alert("please enter empid!!");
			return false;
		}
	}
</script>
<body>
<h3>Employee Deletion</h3>
<form method="post" action="/delete" onsubmit="return msg()">
		<table align="center">
			<tr>
				<td>Employee Id:</td>
				<td><input type="text" size=25 name="id" id="id"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit"></td>
			</tr>
		</table>
	</form>
	<a href="AdminOperations.jsp">Back</a>
	<a href="login.jsp">Logout</a>
</body>
</html>