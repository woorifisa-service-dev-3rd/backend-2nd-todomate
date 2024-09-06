<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Index Page</title>
</head>
<body>

<h1>Welcome!</h1>

<!-- Todo 리스트 보러가기 버튼 -->
<form action="/todos/list" method="get">
    <input type="submit" value="Todo 리스트 보러가기">
</form>

<br>

<!-- 다이어리 리스트 보러가기 버튼 -->
<form action="/diaries/list" method="get">
    <input type="submit" value="다이어리 리스트 보러가기">
</form>

</body>
</html>