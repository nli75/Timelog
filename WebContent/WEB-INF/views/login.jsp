<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%

	String failed =  (String)request.getAttribute("failed");
	
%>

<h1>LOG IN</h1>			
		
<% if(failed != null){ %>
	<h4>Error </h4>
	<%= failed %>
<% } %>
<form action="" method="post">
	<p>
		<label for="username">Username: </label>
		<input type="text" id="username" name="username" />
	</p>
	<p>
		<label for="passord">Password: </label>
		<input type="text" id="passord" name="passord" />
	</p>
	<p>
	</p>
		<input type="submit" value="Submit" />
</form>