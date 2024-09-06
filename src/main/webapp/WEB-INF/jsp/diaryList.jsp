<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
<head>
    <title>Diaries</title>
</head>
<body>

<h1>Diaries</h1>

<!-- Add Diary 버튼 -->
<form action="/diaries/add" method="get">
    <input type="submit" value="Add Diary">
</form>

<br>

<%--<!-- Diary 리스트 -->--%>
<%--<ul>--%>
<%--    <c:forEach var="diary" items="${diaries}">--%>
<%--        <li>${diary.title}</li>--%>
<%--        <li>${diary.content}</li>--%>
<%--        <li>${diary.date}</li>--%>
<%--    </c:forEach>--%>
<%--</ul>--%>

<!-- Diary 리스트 -->
<ul>
    <c:forEach var="diary" items="${diaries}">
        <li>
            <a href="/diaries/${diary.id}/edit">${diary.title}</a>
        </li>
        <li>${diary.content}</li>
        <li>${diary.date}</li>
    </c:forEach>
</ul>

</body>
</html>
