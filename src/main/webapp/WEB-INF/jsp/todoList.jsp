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
    <form action="addTodo.jsp" method="get">
        <input type="submit" value="Add Todo">
    </form>

    <br>

    <!-- Todo 리스트 -->
    <ul>
        <%
            // 가상의 Todo 리스트 (서버에서 가져온 데이터라고 가정)
            List<String> todos = new ArrayList<>();
            todos.add("Learn Java");
            todos.add("Build a Todo App");
            todos.add("Study JSP");

            // 필터 없이 모든 Todo 리스트 출력
            for (String todo : todos) {
                out.println("<li>" + todo + "</li>");
            }
        %>
    </ul>

</body>
</html>
