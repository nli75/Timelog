<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%

	String failed =  (String)request.getAttribute("failed");
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login Timelog</title>
<link rel="stylesheet" type="text/css" href="../style/style.css" />
</head>
<body>
		<h1>LOG IN</h1>			
			
	<% if(failed != null){ %>
		<h4>Error </h4>
		<%= failed %>
	<% } %>
	<form action="" method="post">
		<p>
			<label for="username">Username: </label>
			<input type="text" id="username" name="username" />
		</p>
		<p>
			<label for="passord">Password: </label>
			<input type="text" id="passord" name="passord" />
		</p>
		<p>
		</p>
			<input type="submit" value="Submit" />
	</form>
</body>
</html>