<%@ page import="java.util.ArrayList"%>
<% ArrayList<String> errorList = (ArrayList<String>) request.getAttribute("errorList"); %>
<h1>Create Role</h1>
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
		<input type="submit" value="Create Role" />
	</p>
</form>