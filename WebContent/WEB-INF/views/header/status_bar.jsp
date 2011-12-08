<% String username = (String)request.getSession().getAttribute("username"); %>
<div id="status_bar">
	<div class="centrilize">
		<p>Inloggad som <b><%= username %></b></p>
		<!--
		<form action="" method="post">
			<p><input type="submit" value="Logout" /></p>
		</form>
		-->
		<a href="/Timelog/logout"><b>Logout</b></a>
	</div>
</div>