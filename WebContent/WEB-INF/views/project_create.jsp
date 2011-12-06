<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.ArrayList"%>
<% ArrayList<String> errorList = (ArrayList<String>) request.getAttribute("errorList"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Create Project</title>
<style type="text/css">
	label { display:inline-block; width:150px; }
</style>
</head>
<body>
	<h1>Create Project</h1>
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
	<form method="post" action="">
		<p>
			<label for="name">Name</label>
			<input type="text" id="name" name="name" />
		</p>
		<p>
			<label for="budget">Budget</label>
			<input type="text" id="budget" name="budget" />
		</p>
		<p>
			<label for="estimatedTime">Estimated Time</label>
			<input type="text" id="estimatedTime" name="estimatedTime" />
		</p>
		<p>
			<input type="submit" value="Submit" />
		</p>
	</form>
</body>
</html>