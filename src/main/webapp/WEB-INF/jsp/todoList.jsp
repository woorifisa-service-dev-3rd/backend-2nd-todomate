<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page import="java.util.List, java.util.ArrayList" %>

<!DOCTYPE html>
<html>
<head>
    <title>Todos</title>
</head>
<body>

    <h1>Todos</h1>

    <!-- Add Todo 버튼 -->
    <form action="/todos/addTodo" method="get">
        <input type="submit" value="Add Todo">
    </form>
    <br>

    <!-- Todo 리스트 -->
    <ul>
        <c:forEach var="todo" items="${todos}">
            <li>${todo.title} - ${todo.summary} - ${todo.option}</li>
        </c:forEach>
    </ul>

</body>
</html>
