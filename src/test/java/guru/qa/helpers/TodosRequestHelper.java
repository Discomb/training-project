package guru.qa.helpers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import guru.qa.dtos.todos.Todo;

import static io.restassured.RestAssured.given;
import com.fasterxml.jackson.core.*;

import java.io.IOException;
import java.util.List;

public class TodosHTTPFactory {

    public static Todo getTodo(int id, int statusCode) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();

        return given()
                .log().all()
                .log().uri()
                .when()
                .get("/todos/" + id)
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
                .get("/todos")
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
