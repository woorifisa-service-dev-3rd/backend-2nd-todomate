<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Todo Form</title>
</head>
<body>
<section>
    <h2>${todo.id == null ? 'Add Todo' : 'Update Todo'}</h2>

    <!-- todo 객체가 빈 객체인지 아닌지에 따라 form의 action URL을 결정 -->
    <form action="${todo.id == null ? '/todos/add' : '/todos/update'}" method="post">

        <label for="title">Title:</label>
        <input type="text" id="title" name="title" value="${todo.title}" required>

        <label for="summary">Summary:</label>
        <input type="text" id="summary" name="summary" value="${todo.summary}" required>

        <label for="option">Category:</label>
            <select name="option" id="option">
                <option value="TO_DO" ${todo.option == 'TO_DO' ? 'selected' : ''}>TODO</option>
                <option value="ON_PROGRESS" ${todo.option == 'ON_PROGRESS' ? 'selected' : ''}>PROGRESS</option>
                <option value="DONE" ${todo.option == 'DONE' ? 'selected' : ''}>DONE</option>
            </select>

        <button type="submit">${todo.id == null ? 'Add Todo' : 'Update Todo'}</button>
    </form>
</section>
</body>
</html>