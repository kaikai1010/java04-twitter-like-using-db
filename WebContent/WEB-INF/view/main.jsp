<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/view/header.jsp" />

<h1>Twitter-like MAIN</h1>

<p>Mr./Ms. <c:out value="${u.name}" />, you're Logged-in.
<a href="/twitter-like-using-db/MainServlet">LOGOUT</a></p>
<a href="/twitter-like-using-db/LoginServlet">UPDATE</a>

<form action="/twitter-like-using-db/MainServlet" method="post">
<table>
<tr>
<td><input type="text" name="text"></td>
<td><input type="submit" value="TWITTER"></td>
</tr>
</table>
<br>
</form>

<c:if test="${not empty errorMsg}">
<p>${errorMsg}</p>
</c:if>

<c:forEach var="t" items="${tList}">
<p><c:out value="${t.twitterName}" />:<c:out value="${t.text}" /></p>
</c:forEach>

<jsp:include page="/WEB-INF/view/footer.jsp" />