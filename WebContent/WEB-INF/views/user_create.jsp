<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    
%><%@ page import="java.util.ArrayList"%><%
	ArrayList<String> error =  (ArrayList<String>)request.getAttribute("errors");

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create User</title>
</head>
<body>

<h1>Create user</h1>
	<div>
		<% if(error != null){ %>
			<h4>Errors</h4>
				<ul>
					<%
					for (int i=0; i < error.size(); i++) {
						%>
						<li>
						<%= error.get(i) %>
						</li>
						<%
					}
					%>
				</ul>		
		<% } %>
	</div>
	<form action="" method="post">
		<p>
			<label for="firstname">First name: </label>
			<input type="text" name= "firstname" id="firstname" />
		</p>
		<p>
			<label for="lastname">Last name: </label>
			<input type="text" name= "lastname" id="lastname" />
		</p>
		<p>
			<label for="email">Email as username: </label>
			<input type="text" name= "email" id="email" />
		</p>
		<p>
			<label for="password">Password: </label>
			<input type="text" name= "password" id="password" />
		</p>
		<p>
		<input type="submit" value="Submit" />
		</p>
	</form>


</body>
</html>