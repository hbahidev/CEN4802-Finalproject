package bhtech.dao;

import bhtech.model.TodoItem;
import java.util.List;

public interface TodoItemDAO {
    List<TodoItem> getAllTodoItems();
    TodoItem getTodoItemById(int id);
    boolean addTodoItem(TodoItem item);
    boolean updateTodoItem(TodoItem item);
    boolean deleteTodoItem(int id);
}
