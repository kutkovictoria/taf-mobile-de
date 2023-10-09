package by.itacademy.taf.mobile.api;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ApiBaseURLTest {
    final String URL_MOBILE = "https://www.mobile.de/";

    @Test
    public void get200okMobileDE() {
        given().
                header("User-Agent", "PostmanRuntime/7.33.0").
                header("Content-Type", "text/html").
                when().get(URL_MOBILE).
                then().assertThat().
                statusCode(200);
    }
}
