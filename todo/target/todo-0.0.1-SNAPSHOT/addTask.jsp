<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Task</title>
</head>
<body>
    <h1>Add Task</h1>
    <form action="TodoServlet" method="post">
        <input type="hidden" name="action" value="add">
        Task: <input type="text" name="task" required>
        <button type="submit">Add Task</button>
    </form>
</body>
</html>

