package by.itacademy.taf.mobile.api;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class ApiTest {
    final String URL_MOBILE = "https://www.mobile.de/";
    private String headerText = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJjaWQiOiJmZDM5MWZjMS00YmI3LTRkZjQtYTUxMS04YWIxNTJkOTRiZDIiLCJpYXQiOjE2Nzg4OTg3OTh9.4i0QiqIXw9FZOhuJQNs38I2pUL99pQgmEaOjwkCO4NY";

    @Test
    public void get200okMobileDE() {
        when().get(URL_MOBILE).
                then().assertThat().
                statusCode(200);
    }

    @Test
    public void check201okAndCarId() {
        String requestBody = "{\n" +
                "    \"adId\": \"365741523\",\n" +
                "    \"ref\": \"null\"\n" +
                "    \"refId\": \"null\"\n" +
                "}";
        given().body(requestBody).
                header("x-mobile-vi", headerText).
                when().post(URL_MOBILE).
                then().assertThat().
                statusCode(201).
                body("adId", equalTo("365741523"));
    }
}
