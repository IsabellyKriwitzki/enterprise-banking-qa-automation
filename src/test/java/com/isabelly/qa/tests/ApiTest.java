package com.isabelly.qa.tests;

import com.isabelly.qa.api.LoginApiClient;
import com.isabelly.qa.models.UserRequest;
import com.isabelly.qa.models.UserResponse;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Tag("api")
@Feature("User API")
class ApiTest {

    private final LoginApiClient apiClient =
            new LoginApiClient();

    @Test
    @Story("Retrieve Users")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Validates that the API successfully retrieves the list of users.")
    void shouldRetrieveUsersSuccessfully() {

        Response response = apiClient.getUsers();

        assertEquals(
                200,
                response.getStatusCode()
        );

        assertNotNull(response.getBody());

        assertFalse(
                response.jsonPath()
                        .getList("$")
                        .isEmpty()
        );
    }

    @Test
    @Story("Create User")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Validates that a new user can be successfully created through the API.")
    void shouldCreateUserSuccessfully() {

        UserRequest userRequest =
                new UserRequest(
                        "Isabelly QA",
                        "QA Automation Engineer"
                );

        UserResponse response =
                apiClient.createUserAsObject(userRequest);

        assertNotNull(response);

        assertEquals(
                "Isabelly QA",
                response.name()
        );

        assertEquals(
                "QA Automation Engineer",
                response.job()
        );

        assertTrue(
                response.id() > 0
        );
    }
}