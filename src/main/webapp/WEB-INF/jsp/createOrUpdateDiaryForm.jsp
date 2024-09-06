<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>${diary != null && diary.id != null ? "일기 수정" : "일기 추가"}</title>
</head>
<body>
<h1>${diary != null && diary.id != null ? "일기 수정" : "일기 추가"}</h1>
<form action="${diary != null && diary.id != null ? '/diaries/update' : '/diaries/add'}" method="post">
    <input type="hidden" name="id" value="${diary != null && diary.id != null ? diary.id : ''}" />
    <div>
        <label for="title">제목:</label>
        <input type="text" id="title" name="title" value="${diary != null && diary.title != null ? diary.title : ''}" required />
    </div>
    <div>
        <label for="content">내용:</label>
        <textarea id="content" name="content" required>${diary != null && diary.content != null ? diary.content : ''}</textarea>
    </div>
    <div>
        <input type="submit" value="${diary != null && diary.id != null ? '수정' : '추가'}" />
    </div>
</form>
</body>
</html>
