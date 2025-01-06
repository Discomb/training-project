package guru.qa.tests;

import guru.qa.dtos.todos.Post;
import org.junit.jupiter.api.Test;

import java.util.List;

import static guru.qa.helpers.PostsRequestHelper.getPost;
import static guru.qa.helpers.PostsRequestHelper.getPosts;
import static org.apache.http.HttpStatus.SC_OK;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class PostTests extends BaseTest{

    @Test
    public void getAllPosts() {

        List<Post> allPosts = getPosts(SC_OK);
    }

    @Test
    public void checkPost() {

        Post post = getPost("1", SC_OK);

        assertAll(
                () -> assertFalse(post.title().isEmpty()),
                () -> assertFalse(post.id() < 0),
                () -> assertFalse(post.userId() < 0),
                () -> assertFalse(post.body().isEmpty())

        );
    }
}
