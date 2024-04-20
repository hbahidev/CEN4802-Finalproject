package bhtech.dao;

import bhtech.model.TodoItem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TodoItemDAOImpl implements TodoItemDAO {
    // JDBC connection parameters
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/todo_db";
    private static final String JDBC_USERNAME = "root";
    private static final String JDBC_PASSWORD = "Testing123456";

    // SQL queries
    private static final String SELECT_ALL_QUERY = "SELECT * FROM mytablelist";
    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM mytablelist WHERE id = ?";
    private static final String INSERT_QUERY = "INSERT INTO mytablelist (task) VALUES (?)";
    private static final String UPDATE_QUERY = "UPDATE mytablelist SET task = ? WHERE id = ?";
    private static final String DELETE_QUERY = "DELETE FROM mytablelist WHERE id = ?";

    // Establish database connection
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
    }

    @Override
    public List<TodoItem> getAllTodoItems() {
        List<TodoItem> todoItems = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_QUERY);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                TodoItem todoItem = new TodoItem();
                todoItem.setId(resultSet.getInt("id"));
                todoItem.setTask(resultSet.getString("task"));
                todoItems.add(todoItem);
            }
            
            System.out.println("Retrieving todo items from the database..."); 
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return todoItems;
    }

    @Override
    public TodoItem getTodoItemById(int id) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID_QUERY)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    TodoItem todoItem = new TodoItem();
                    todoItem.setId(resultSet.getInt("id"));
                    todoItem.setTask(resultSet.getString("task"));
                    return todoItem;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean addTodoItem(TodoItem item) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_QUERY)) {
            statement.setString(1, item.getTask());
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateTodoItem(TodoItem item) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, item.getTask());
            statement.setInt(2, item.getId());
            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteTodoItem(int id) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_QUERY)) {
            statement.setInt(1, id);
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
