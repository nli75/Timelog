<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Create Project</h1>
	<form method="post" action="">
		<p>
			<label for="name">Name:</label>
			<input type="text" id="name" name="name" />
		</p>
		<p>
			<label for="budget">Budget:</label>
			<input type="text" id="budget" name="budget" />
		</p>
		<p>
			<label for="estimated_time">Estimated Time:</label>
			<input type="text" id="estimated_time" name="estimated_time" />
		</p>
		<p>
			<input type="submit" value="Submit" />
		</p>
	</form>
</body>
</html>