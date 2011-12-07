<%

	String failed =  (String)request.getAttribute("failed");
	
%>

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
	</p>
		<input type="submit" value="Login" />
</form>