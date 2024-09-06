<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Todo App</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
<header>
    <div class="flex justify-center">
        <a href="${pageContext.request.contextPath}/" class="flex">
            <h1 class="py-8 text-red-200 max-w-max text-7xl">todos</h1>
        </a>
    </div>
</header>
<section class="max-w-xl m-4 mx-auto">
    <form action="${pageContext.request.contextPath}/todo/add" method="post">
        <label for="title">Title:</label>
        <input type="text" id="title" name="title" required>

        <label for="summary">Summary:</label>
        <input type="text" id="summary" name="summary" required>

        <label for="category">Category:</label>
        <select name="category" id="category">
            <option value="TODO">TODO</option>
            <option value="PROGRESS">PROGRESS</option>
            <option value="DONE">DONE</option>
        </select>

        <button type="submit">Add Todo</button>
    </form>

    <form action="${pageContext.request.contextPath}/todo/filter" method="get">
        <label for="filter">Filter:</label>
        <select name="category" id="filter" onchange="this.form.submit()">
            <option value="ALL" ${selectedCategory == 'ALL' ? 'selected' : ''}>ALL</option>
            <option value="TODO" ${selectedCategory == 'TODO' ? 'selected' : ''}>TODO</option>
            <option value="PROGRESS" ${selectedCategory == 'PROGRESS' ? 'selected' : ''}>PROGRESS</option>
            <option value="DONE" ${selectedCategory == 'DONE' ? 'selected' : ''}>DONE</option>
        </select>
    </form>

    <ul class="px-0 my-8">
        <c:forEach var="todo" items="${todos}">
            <li class="todo-item" draggable="true" ondragstart="handleDragStart(event, '${todo.id}')" ondragover="handleDragOver(event)" ondrop="handleDrop(event, '${todo.id}')">
                <div>
                    <h3>${todo.title}</h3>
                    <p>${todo.summary}</p>
                    <p>Category: ${todo.category}</p>

                    <form action="${pageContext.request.contextPath}/todo/update" method="post">
                        <input type="hidden" name="id" value="${todo.id}">
                        <input type="text" name="title" value="${todo.title}" required>
                        <input type="text" name="summary" value="${todo.summary}" required>
                        <select name="category">
                            <option value="TODO" ${todo.category == 'TODO' ? 'selected' : ''}>TODO</option>
                            <option value="PROGRESS" ${todo.category == 'PROGRESS' ? 'selected' : ''}>PROGRESS</option>
                            <option value="DONE" ${todo.category == 'DONE' ? 'selected' : ''}>DONE</option>
                        </select>
                        <button type="submit">Update</button>
                    </form>

                    <form action="${pageContext.request.contextPath}/todo/delete" method="post">
                        <input type="hidden" name="id" value="${todo.id}">
                        <button type="submit">Delete</button>
                    </form>
                </div>
            </li>
        </c:forEach>
    </ul>
</section>

<script>
    function handleDragStart(event, id) {
        event.dataTransfer.setData("text", id);
    }

    function handleDragOver(event) {
        event.preventDefault();
    }

    function handleDrop(event, id) {
        event.preventDefault();
        const draggedId = event.dataTransfer.getData("text");
        // 서버에 drag & drop으로 재정렬 요청 보내는 로직 필요
    }
</script>
</body>
</html>
