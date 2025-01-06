package guru.qa.helpers;

import com.fasterxml.jackson.databind.ObjectMapper;
import guru.qa.dtos.todos.Todo;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.List;

public class TodosRequestHelper {

    private static final String TODOS_ENDPOINT = "/todos/";

    public static Todo getTodo(int id, int statusCode) throws IOException {

        return given()
                .log().all()
                .log().uri()
                .when()
                .get(TODOS_ENDPOINT + id)
                .then()
                .log().status()
                .log().body()
                .statusCode(statusCode)
                .extract()
                .jsonPath()
                .getObject("", Todo.class);
    }

    public static List<Todo> getTodosList(int statusCode) {

        return given()
                .log().all()
                .log().uri()
                .when()
                .get(TODOS_ENDPOINT)
                .then()
                .log().status()
                .log().body()
                .statusCode(statusCode)
                .extract()
                .body()
                .jsonPath()
                .getList("", Todo.class);
    }
}
