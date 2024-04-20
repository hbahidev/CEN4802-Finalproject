<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Delete Task</title>
</head>
<body>
    <h1>Delete Task</h1>
    <form action="TodoServlet" method="post">
        <input type="hidden" name="action" value="delete">
        Task ID to delete: <input type="number" name="id" required>
        <button type="submit">Delete Task</button>
    </form>
</body>
</html>
