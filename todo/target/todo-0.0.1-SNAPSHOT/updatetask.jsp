<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Task</title>
</head>
<body>
    <h1>Update Task</h1>
    <form action="TodoServlet" method="post">
        <input type="hidden" name="action" value="update">
        Task ID to update: <input type="number" name="id" required><br>
        New Task: <input type="text" name="task" required>
        <button type="submit">Update Task</button>
    </form>
</body>
</html>
