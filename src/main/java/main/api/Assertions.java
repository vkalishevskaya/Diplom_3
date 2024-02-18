package main.api;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import static java.net.HttpURLConnection.*;
import static org.hamcrest.Matchers.*;


public class Assertions {
    @Step("Compare response")
    public void userCreatedSuccessfully(Response response) {
        response.then().assertThat()
                .statusCode(HTTP_OK)
                .body("success", is(true), "accessToken", notNullValue(), "refreshToken", notNullValue());
    }
    @Step("Compare response")
    public void deletedSuccessfully(Response response) {
        response.then().assertThat()
                .statusCode(HTTP_ACCEPTED)
                .body(notNullValue());;
    }
    @Step("Compare response and check that accessToken and refrestToken are not null")
    public void loggedInSuccessfully(Response response) {
        response.then().assertThat()
                .statusCode(HTTP_OK)
                .body("accessToken", notNullValue(), "refreshToken", notNullValue())
        ;
    }
}
