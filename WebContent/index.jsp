<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/view/header.jsp" />

<h1>Twitter-like TOP</h1>

<form action="/twitter-like-using-db/LoginServlet" method="post">
<table>
<tr>
<th>NAME</th>
<td><input type="text" name="name"></td>
</tr>
<tr>
<th>PASSWORD</th>
<td><input type="password" name="pass"></td>
</tr>
</table>
<br>
<input type="submit" value="LOGIN">
</form>

<jsp:include page="/WEB-INF/view/footer.jsp" />