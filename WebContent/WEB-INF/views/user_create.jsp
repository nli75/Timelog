<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
%><%
    
	String namn1 = (String)request.getAttribute("namn");
	String url1 = (String)request.getAttribute("url");
	
	
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
<h1>Skapa Användare</h1>
	<form action="" method="post">
	<div id=username>Förnamn: <input type="text" name= "firstname" /></div><%= error %>

	<div id=username>Efternamn: <input type="text" name= "lastname" /></div>	
	<div id=username>Email/användarnamn: <input type="text" name= "email" /></div>
	<div id=passord>Lösenord: <input type="text" name="password" /></div>
	<div id= login_submit><input type="submit" value="Submit" /></div>
	</form>
</div>

</body>
</html>