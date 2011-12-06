<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.ArrayList"%>
<% ArrayList<String> errorList = (ArrayList<String>) request.getAttribute("errorList"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create User</title>
</head>
<body>

	<h1>Create User</h1>
	<div>
		<%
			if (errorList != null && errorList.size() > 0) {
				%>
				<h4>Errors</h4>
				<ul>
				<%
				for (int i=0; i < errorList.size(); i++) {
					%>
					<li>
					<%= errorList.get(i) %>
					</li>
					<%
				}
				%>
				</ul>
				<%
			}
		%>
	</div>
	<form action="" method="post">
		<p>
			<label for="name">First Name</label>
			<input type="text" id="firstName" name="firstName" />
		</p>
		<p>
			<label for="name">Last Name</label>
			<input type="text" id="lastName" name="lastName" />
		</p>
		<p>
			<label for="name">E-mail</label>
			<input type="text" id="email" name="email" />
		</p>
		<p>
			<label for="name">Password</label>
			<input type="text" id="password" name="password" />
		</p>
		<p>
			<input type="submit" value="Create User" />
		</p>
	</form>

</body>
</html>