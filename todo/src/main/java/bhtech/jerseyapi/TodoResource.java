package bhtech.jerseyapi;

import bhtech.dao.TodoItemDAO;
import bhtech.dao.TodoItemDAOImpl;
import bhtech.model.TodoItem;
import java.util.List;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/todo")
public class TodoResource {

    private TodoItemDAO todoItemDAO;

    public TodoResource() {
        todoItemDAO = new TodoItemDAOImpl();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<TodoItem> getAllTodoItems() {
        return todoItemDAO.getAllTodoItems();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addTodoItem(TodoItem todoItem) {
        todoItemDAO.addTodoItem(todoItem);
    }

    @DELETE
    @Path("/{id}")
    public void deleteTodoItem(@PathParam("id") int id) {
        todoItemDAO.deleteTodoItem(id);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateTodoItem(@PathParam("id") int id, TodoItem todoItem) {
        todoItem.setId(id);
        todoItemDAO.updateTodoItem(todoItem);
    }
}
