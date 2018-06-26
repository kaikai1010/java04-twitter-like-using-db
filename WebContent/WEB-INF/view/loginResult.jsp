<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/view/header.jsp" />

<h1>Twitter-like LOGIN RESULT</h1>

<c:choose>
<c:when test="${empty u}">
<p>Your login is failed.</p>
<a href="/twitter-like-using-db/">Back to TOP</a>
</c:when>
<c:otherwise>
<p>Your login is Successful. Welcome back, Mr./Ms. <c:out value="${u.name}" />.</p>
<a href="/twitter-like-using-db/LoginServlet">Start Twittering</a>
</c:otherwise>
</c:choose>
<br>

<jsp:include page="/WEB-INF/view/footer.jsp" />