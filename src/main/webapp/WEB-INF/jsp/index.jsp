<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Index Page</title>
</head>
<body>

<h1>Welcome! TodoMate</h1>

<%
    // 세션에서 로그인 여부 확인
    String userName = (String) session.getAttribute("username");
%>

<% if (userName == null) { %>
    <h1>로그인</h1>
    <form action="/users/login" method="post">
        <label for="username">아이디:</label>
        <input type="text" name="username" required>
        <br>
        <label for="password">비밀번호:</label>
        <input type="password" name="password" required>
        <br>
        <input type="submit" value="로그인">
    </form>
<% } else { %>
    <h1>Welcome, <%= userName %>!</h1>

    <!-- Todo 리스트 보러가기 버튼 (로그인된 경우에만 표시) -->
    <form action="/todos/list" method="get">
        <input type="submit" value="Todo 리스트 보러가기">
    </form>

    <br>

    <!-- 다이어리 리스트 보러가기 버튼 (로그인된 경우에만 표시) -->
    <form action="/diaries/list" method="get">
        <input type="submit" value="다이어리 리스트 보러가기">
    </form>
<% } %>

</body>
</html>
