<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
<head>
    <title>Todos</title>
    <script>
        // 클릭 시 수정 페이지로 리다이렉트하는 함수
        function redirectToEdit(todoId) {
            window.location.href = '/todos/createOrUpdateTodoForm?id=' + todoId;
        }
    </script>
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
            <li onclick="redirectToEdit(${todo.id})" style="cursor: pointer;">
                ${todo.title} - ${todo.summary} - ${todo.option}
            </li>
        </c:forEach>
    </ul>

</body>
</html>
