package bhtech.controller;

import bhtech.dao.TodoItemDAO;
import bhtech.dao.TodoItemDAOImpl;
import bhtech.model.TodoItem;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TodoServlet")
public class TodoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private TodoItemDAO todoItemDAO;

    public void init() {
        todoItemDAO = new TodoItemDAOImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<TodoItem> todoItems = todoItemDAO.getAllTodoItems();
        System.out.println("Number of tasks: " + todoItems.size());
        request.setAttribute("todoItems", todoItems);
        request.getRequestDispatcher("/listTasks.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "add":
                    addTask(request, response);
                    break;
                case "delete":
                    deleteTask(request, response);
                    break;
                case "update":
                    updateTask(request, response);
                    break;
                default:
                    response.sendRedirect(request.getContextPath() + "/TodoServlet");
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/TodoServlet");
        }
    }

    private void addTask(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String task = request.getParameter("task");
        TodoItem todoItem = new TodoItem();
        todoItem.setTask(task);
        todoItemDAO.addTodoItem(todoItem);
        response.sendRedirect(request.getContextPath() + "/TodoServlet");
    }

    private void deleteTask(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        todoItemDAO.deleteTodoItem(id);
        response.sendRedirect(request.getContextPath() + "/TodoServlet");
    }

    private void updateTask(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String task = request.getParameter("task");
        TodoItem todoItem = new TodoItem();
        todoItem.setId(id);
        todoItem.setTask(task);
        todoItemDAO.updateTodoItem(todoItem);
        response.sendRedirect(request.getContextPath() + "/TodoServlet");
    }
}
