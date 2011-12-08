<%
	String content = (String)request.getAttribute("content");
%>

<jsp:include page="/WEB-INF/views/includes/header.jsp" />

<jsp:include page="/WEB-INF/views/header/status_bar.jsp" />
<jsp:include page="/WEB-INF/views/header/main_menu.jsp" />

<div id="content" class="centrilize">
	<jsp:include page="/WEB-INF/views/${content}.jsp" />
</div>

<jsp:include page="/WEB-INF/views/includes/footer.jsp" />