<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../style/style.css" />
</head>
<body>
<div id="login_div">
<h1>LOGGA IN</h1>
	<form action=/User method="post">
	<div id=username>Användare: <input type="text" name= "username" /></div>
	<div id=passord>Lösenord: <input type="text" name="password" /></div>
	<div id= login_submit><input type="submit" value="Submit" /></div>
	</form>
</div>
</body>
</html>