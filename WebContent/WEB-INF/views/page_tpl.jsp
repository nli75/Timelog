<% String content = (String)request.getAttribute("content"); %>
<jsp:include page="/WEB-INF/views/header.jsp" />

<%-- put an if session on this --%>
<jsp:include page="/WEB-INF/views/home.jsp" />
<%-- end if --%>

<jsp:include page="/WEB-INF/views/${content}.jsp" />

<jsp:include page="/WEB-INF/views/footer.jsp" />