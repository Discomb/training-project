package guru.qa.tests;

import guru.qa.dtos.todos.Post;
import org.junit.jupiter.api.Test;

import java.util.List;

import static guru.qa.helpers.PostsRequestHelper.getPosts;
import static org.apache.http.HttpStatus.SC_OK;

public class PostTests extends BaseTest{

    @Test
    public void getAllPosts() {

        List<Post> allPosts = getPosts(SC_OK);
    }
}
