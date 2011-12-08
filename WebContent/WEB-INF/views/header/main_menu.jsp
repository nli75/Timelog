<% String path = request.getContextPath(); %>

<div id="main_menu">
	<div class="centrilize">
		<div id="nav">
			<ul>
				<li><a href="/Timelog/project/create" >Projekt</a></li>
				<li><a href="<%= path %>/customer/create" >Kunder</a></li>
				
				<%-- TODO if (check Level in session) --%>
				<li><a href="<%= path %>/user/create" >Användare</a></li>
				<%-- TODO end if --%>
			</ul>
		</div>
		<div id="search">
			<form method="post" action="">
				<p>
					<input type="text" name="search" />
				</p>
			</form>
		</div>
	</div>
</div>