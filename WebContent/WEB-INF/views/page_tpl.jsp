<% String content = (String)request.getAttribute("content"); %>
<jsp:include page="/WEB-INF/views/header.jsp" />
<jsp:include page="/WEB-INF/views/${content}.jsp" />
<jsp:include page="/WEB-INF/views/footer.jsp" />