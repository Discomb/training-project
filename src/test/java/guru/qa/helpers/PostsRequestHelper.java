package guru.qa.helpers;

import guru.qa.dtos.todos.Post;
import guru.qa.dtos.todos.Todo;

import javax.swing.*;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;

public class PostsRequestHelper {

    private static final String POSTS_ENDPOINT = "/posts/";

    public static Post getPost(String id, int statusCode) {

        return given()
                .log().all()
                .log().uri()
                .when()
                .get(POSTS_ENDPOINT + id)
                .then()
                .log().status()
                .log().body()
                .statusCode(statusCode)
                .extract()
                .jsonPath()
                .getObject("", Post.class);
    };

    public static List<Post> getPosts(int statusCode) {

        return given()
                .log().all()
                .log().uri()
                .when()
                .get(POSTS_ENDPOINT)
                .then()
                .log().status()
                .log().body()
                .statusCode(statusCode)
                .extract()
                .body()
                .jsonPath()
                .getList("", Post.class);
    };
}
