package com.isabelly.qa.api;

import com.isabelly.qa.config.ConfigReader;
import com.isabelly.qa.models.UserRequest;
import com.isabelly.qa.models.UserResponse;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class LoginApiClient {

    private final String baseUrl =
            ConfigReader.getProperty("api.base.url");


    @Step("Create user and deserialize response")
    public UserResponse createUserAsObject(UserRequest userRequest) {

        Response response = createUser(userRequest);

        System.out.println("API RESPONSE:");
        System.out.println(response.asPrettyString());

        return response.as(UserResponse.class);
    }

   @Step("Get users from API") 
   public Response getUsers() {

        return given()
                .baseUri(baseUrl)
                .header("Accept", "application/json")
                .when()
                .get("/users");
    }

    @Step("Create user: {userRequest.name}")
    public Response createUser(UserRequest userRequest) {

        return given()
                .baseUri(baseUrl)
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .body(userRequest)
                .when()
                .post("/users");
    }

    @Step("Get invalid API endpoint")
    public Response getInvalidEndpoint() { return given()
            .baseUri(baseUrl)
            .header("Accept", "application/json")
            .when()
            .get("/invalid-endpoint");

    }
 
    @Step("Create user with invalid payload")
    public Response createUserWithInvalidPayload() {

        return given()
                .baseUri(baseUrl)
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .body("{}")
                .when()
                .post("/users");
    }


}

