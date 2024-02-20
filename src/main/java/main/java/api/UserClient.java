package main.java.api;

import io.qameta.allure.Step;
import io.restassured.response.Response;


public class UserClient extends Client {
    static final String REG_PATH = "/auth/register";
    static final String DELETE_PATH = "/auth/user";
    static final String LOGIN_PATH = "/auth/login";

    @Step("Send POST request to /api/auth/register")
    public Response createUser(User user) {
        return spec()
                .body(user)
                .when()
                .post(REG_PATH);
    }
    @Step("Send DELETE request to /api/auth/user")
    public Response deleteUser(String token) {
        return spec()
                .header("Authorization", token)
                .when()
                .delete(DELETE_PATH);
    }

    public Response open(String token) {
        return spec()
                .header("Authorization", token)
                .when()
                .get(BASE_URI);
    }
}
