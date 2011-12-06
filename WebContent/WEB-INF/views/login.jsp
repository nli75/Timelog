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
<div id="login_div">
<h1>LOG IN</h1>
	<form action="" method="post">
	<% if(failed != null){
		out.println(failed);
	} %>
	<div id=username>Username (email): <input type="text" name= "username" /></div>
	<div id=passord>Password: <input type="text" name="password" /></div>
	<div id=repeat_passord>Repeat password: <input type="text" name="password" /></div>
	
	<div id= login_submit><input type="submit" value="Submit" /></div>
	</form>
</div>
</body>
</html>