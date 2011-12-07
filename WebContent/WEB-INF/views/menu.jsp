<% String path = request.getContextPath(); %>
<ul>
	<li><a href="<%= path %>/project/create" >Projekt</a></li>
	<li><a href="<%= path %>/customer/create" >Kunder</a></li>
	<%-- TODO if (check Level in session) --%>
	<li><a href="<%= path %>/user/create" >Användare</a></li>
	<%-- TODO end if --%>
</ul>
