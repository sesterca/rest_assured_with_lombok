import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;
import static org.hamcrest.Matchers.containsString;

public class BaseSpec {
    public static RequestSpecification baseSpec = with()
            .baseUri("http://dummy.restapiexample.com/")
            .basePath("api/v1")
            .log().uri()
            .log().body()
            .contentType(ContentType.JSON);

    public static ResponseSpecification baseResponse = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .expectBody((containsString("success")))
            .build();
}
