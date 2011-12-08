<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String path = request.getContextPath(); %>
<% String failed =  (String)request.getAttribute("failed"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link type="text/css" rel="stylesheet" href="<%= path %>/style/style.css" />
<title>Login</title>
</head>
<body>

	<div id="content" class="login">
		<div id="login">
			<h1>LOG IN</h1>			
			<% if(failed != null){ %>
				<h4>Error </h4>
				<%= failed %>
			<% } %>
			<form action="" method="post">
				<p>
					<label for="email">Email: </label>
					<input type="text" id="email" name="email" />
				</p>
				<p>
					<label for="password">Password: </label>
					<input type="password" id="password" name="password" />
				</p>
				<p>
					<input type="submit" value="Login" />
				</p>
			</form>
		</div>
	</div>

</body>
</html>