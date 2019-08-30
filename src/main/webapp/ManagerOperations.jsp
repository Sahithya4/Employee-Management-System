<%@ page import="com.bank.entity.*" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Operations</title>

<style type="text/css">
#an{
align:center;

}
td{
padding:10px;
border:none;
}
#f2{
width:400px;
height:450px;
background-color:lightgrey;
}
body {text-align: center;background-color:lightgrey;}
</style>
</head>
<body>
<%
session=request.getSession();
String name=(String)session.getAttribute("name");
String status=(String) session.getAttribute("status");
if(status==null)
status="Not Applied yet";
else if(status.equals("pending"))
{
	%><a href="/cancel">Cancel Leave</a>
<%
}
%>
<h3 id="an"><a href="Apply_Leave.jsp">Apply for Leave</a></h3>
<h3 id="an"><a href="/viewleave">View Leaves</a></h3>
<h3 id="an"><a href="/statusofmanager">Leave Status</a></h3>

<a href="login.jsp">Logout</a>
</body>
</html>