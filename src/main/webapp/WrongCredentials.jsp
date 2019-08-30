<%@ page import="com.example.demo.repository.*,com.example.demo.entity.*" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Success page</title>
</head>
<body>
${login.name}
${login.password}
are wrong credentials.

<a href="login.jsp">Back</a>
</body>
</html>