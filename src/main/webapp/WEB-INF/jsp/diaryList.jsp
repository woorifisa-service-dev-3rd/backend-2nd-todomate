<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Diary List</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
<header>
    <div class="flex justify-center">
        <a href="${pageContext.request.contextPath}/" class="flex">
            <h1 class="py-8 text-red-200 max-w-max text-7xl">Diaries</h1>
        </a>
    </div>
</header>
<section class="max-w-xl m-4 mx-auto">
    <!-- 다이어리 추가 폼 -->
    <form action="${pageContext.request.contextPath}/diary/add" method="post">
        <label for="title">Title:</label>
        <input type="text" id="title" name="title" required>

        <label for="content">Content:</label>
        <textarea id="content" name="content" required></textarea>

        <label for="date">Date:</label>
        <input type="date" id="date" name="date" required>

        <button type="submit">Add Diary</button>
    </form>
</section>
</body>
</html>
