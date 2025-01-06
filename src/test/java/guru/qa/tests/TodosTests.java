package guru.qa.tests;

import guru.qa.dtos.todos.Todo;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

public class TodosTests extends BaseTest {

    @Test
    public void demoTest() {

        given()
                .log().all()
                .log().uri()
                .when()
                .get("/todos/1")
                .then()
                .log().status()
                .log().body()
                .statusCode(200);
    }

    @Test
    public void checkAllTodos() {

        given()
                .log().all()
                .log().uri()
                .when()
                .get("/todos")
                .then()
                .log().status()
                .log().body()
                .statusCode(200);
    }

    @Test
    @DisplayName("Check completed todos")
    @Description("Check completed todos")
    public void countCompletedTodos() {

        List<Todo> todos = given()
                .when()
                .get("/todos")
                .then()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath()
                .getList(".", Todo.class);

        assertAll(
                () -> assertEquals(
                        90L,
                        todos.stream()
                                .filter(e -> e.completed())
                                .count(),
                        "Numbers don't match"));
    }
}
