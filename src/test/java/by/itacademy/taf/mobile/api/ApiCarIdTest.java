package by.itacademy.taf.mobile.api;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ApiCardIdTest {

    final String URL_CARDID = "https://suchen.mobile.de/fahrzeuge/svc/my/parkings/365741523";
    private String headerText = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJjaWQiOiJmZDM5MWZjMS00YmI3LTRkZjQtYTUxMS04YWIxNTJkOTRiZDIiLCJpYXQiOjE2Nzg4OTg3OTh9.4i0QiqIXw9FZOhuJQNs38I2pUL99pQgmEaOjwkCO4NY";


    @Test
    public void check201okAndCarId() {
        String requestBody = "{\n" +
                " \"adId\": \"365741523\",\n" +
                " \"ref\": null,\n" +
                " \"refId\": null\n" +
                "}";
        given().
                header("User-Agent", "PostmanRuntime/7.33.0").
                header("Content-Type", "application/json; charset=utf-8").
                header("x-mobile-vi", headerText).
                body(requestBody).
                when().post(URL_CARDID).
                then().assertThat().
                statusCode(201).
                body("adId", equalTo("365741523"));
    }
}
