<%@ page import="java.util.List"%>

<%
	List<String> ProjectsList = (List<String>)request.getAttribute("ProjectsList");
%>

<div><p>looping projects...</p>
	<%
		if (ProjectsList != null && ProjectsList.size() > 0) {
			%>
			<ul>
			<%
			for (int i=0; i < ProjectsList.size(); i++) {
				%>
				<li>
				<%= ProjectsList.get(i) %>
				</li>
				<%
			}
			%>
			</ul>
			<%
		}
	%>
</div>