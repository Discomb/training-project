package guru.qa.tests;

import guru.qa.dtos.todos.Todo;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static guru.qa.helpers.TodosRequestHelper.*;
import static org.apache.http.HttpStatus.SC_OK;
import static org.junit.jupiter.api.Assertions.*;

public class TodosTests extends BaseTest {

    @Test
    @DisplayName("Get single todo")
    @Description("Get single todo")
    public void demoTest() throws IOException {

        Todo singleTodo = getTodo(1, SC_OK);
    }

    @Test
    @DisplayName("Get list of todos")
    @Description("Get list of todos")
    public void checkAllTodos() {

        List<Todo> todos = getTodosList(SC_OK);
    }

    @Test
    @DisplayName("Check completed todos")
    @Description("Check completed todos")
    public void checkCompletedTodos() {

        List<Todo> todos = getTodosList(SC_OK);

        assertAll(
                () -> assertFalse(todos.isEmpty()),
                () -> assertEquals(
                        90L,
                        todos.stream()
                                .filter(Todo::completed)
                                .count(),
                        "Numbers don't match"));

    }
}
