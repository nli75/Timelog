<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.ArrayList"%>
<%
	ArrayList<String> errorList = (ArrayList<String>)request.getAttribute("errorList");
%>

<h1>Create Timelog</h1>
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
		<label for="title">Title</label>
		<input type="text" id="title" name="title" />
	</p>
	<p>
		<label for="comment">Comment</label>
		<input type="text" id="comment" name="comment" value="a value" />
	</p>
	<p>
		<label for="start">Start Date</label>
		<input type="text" id="start" name="start" value="2011-10-10 15:55:55" />
	</p>
	<p>
		<label for="duration">Duration</label>
		<input type="text" id="duration" name="duration" value="1" />
	</p>
	<p>
		<label for="projectId">Project ID</label>
		<input type="text" id="projectId" name="projectId" value="1" />
	</p>
	<p>
		<input type="submit" value="Submit" />
	</p>
</form>