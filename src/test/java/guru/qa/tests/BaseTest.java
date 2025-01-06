package guru.qa.tests;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {

    @BeforeAll
    static void beforeAll() {

        RestAssured.baseURI="https://jsonplaceholder.typicode.com";
    }
}
