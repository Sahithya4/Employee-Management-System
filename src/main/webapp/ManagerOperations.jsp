<%@ page import="com.employee_management.entity.*" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Operations</title>

<style type="text/css">
body
{
text-align:center;
font-size:20px;
background-image: url("data:image/jpeg;base64,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");
background-repeat:no-repeat;
background-size: cover;
}
#an{
align:center;
}
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