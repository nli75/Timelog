<%@ page import="java.util.ArrayList"%>
<%
	ArrayList<String> errorList = (ArrayList<String>)request.getAttribute("errorList");
%>


<h1>Create Project</h1>
<div id="user1">
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
</div>