<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
%><%
	Object error =  request.getAttribute("errors");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create User</title>
</head>
<body>
<div id="create_user_div">
<h1>Create user</h1>
	<form action="" method="post">
	<% if(error != null){ %>
		<p><b>Error! </b><%= error %></p>
		
	<% } %>
	<div id=username>First name: <input type="text" name= "firstname" /></div>
	<div id=username>Last name: <input type="text" name= "lastname" /></div>	
	<div id=username>Email/username: <input type="text" name= "email" /></div>
	<div id=passord>Password: <input type="password" name="password" /></div>
	<div id= login_submit><input type="submit" value="Submit" /></div>
	</form>
</div>

</body>
</html>