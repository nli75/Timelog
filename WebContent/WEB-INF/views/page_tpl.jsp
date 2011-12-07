<% String content = (String)request.getAttribute("content"); %>
<jsp:include page="/WEB-INF/views/header.jsp" />

<%-- TODO put an if session on this --%>
<div id="logout">
	<jsp:include page="/WEB-INF/views/home.jsp" />
</div>
<div id="menu_search">
	<div id="menu">
		<jsp:include page="/WEB-INF/views/menu.jsp" />
	</div>
	<div id="search">
		<jsp:include page="/WEB-INF/views/search.jsp" />
	</div>
</div>
<%-- TODO end if --%>

<jsp:include page="/WEB-INF/views/${content}.jsp" />

<jsp:include page="/WEB-INF/views/footer.jsp" />