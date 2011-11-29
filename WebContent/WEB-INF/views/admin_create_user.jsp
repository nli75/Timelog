<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
%><%
    
	String namn1 = (String)request.getAttribute("namn");
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create User</title>
</head>
<body>
<p>Jag är en admin och vill skapa en user.</p>
<p><%= namn1 %></p>
</body>
</html>