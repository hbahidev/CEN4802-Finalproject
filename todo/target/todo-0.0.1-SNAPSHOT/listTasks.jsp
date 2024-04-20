<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>List Tasks</title>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

   
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
        }
        table {
            margin: 0 auto; /* Center align the table */
            border-collapse: collapse;
            width: 80%; /* Adjust as needed */
        }
        th, td {
            padding: 8px;
            border: 1px solid #ddd;
        }
        th {
            background-color: #f2f2f2;
        }
        tr:hover {
            background-color: #f5f5f5;
        }
        button {
            margin: 5px;
            padding: 8px 16px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <h1>List of Tasks</h1>
    <table>
        <tr>
            <th>ID</th>
            <th>Task</th>
        </tr>
        <c:forEach var="todoItem" items="${todoItems}">
            <tr>
                <td><c:out value="${todoItem.id}"/></td>
                <td><c:out value="${todoItem.task}"/></td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <a href="addTask.jsp"><button>Add Task</button></a>
    <a href="updateTask.jsp"><button>Update Task</button></a>
    <a href="deleteTask.jsp"><button>Delete Task</button></a>
</body>
</html>

