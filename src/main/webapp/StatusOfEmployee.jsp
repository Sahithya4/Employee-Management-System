<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:include page="UserOperations.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Status Of Employee</title>
</head>
<body>
<%
session=request.getSession();
String status=(String) session.getAttribute("status");
if(status==null)
	status="Not yet applied";
%>
Leave status:<%=status%>
</body>
</html>