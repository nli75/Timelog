<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
%>
<%
    
	String errors = (String)request.getAttribute("namn");
	
%>
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
			<label for="estimated_time">Estimated Time</label>
			<input type="text" id="estimated_time" name="estimated_time" />
		</p>
		<p>
			<label for="customer">Customer</label>
			<select id="customer" name="customer">
				<option value=""></option>
				<option value="Kalle">Kalle</option>
				<option value="Ragnar">Ragnar</option>
				<option value="Mikael">Mikael</option>
			</select>
		</p>
		<p>
			<input type="submit" value="Submit" />
		</p>
	</form>
</body>
</html>