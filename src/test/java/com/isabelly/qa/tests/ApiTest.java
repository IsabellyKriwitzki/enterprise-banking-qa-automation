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

    @Test @Story("Invalid Endpoint")
    @Severity(SeverityLevel.NORMAL)
    @Description("Validates that an invalid API endpoint returns HTTP 404.")
    void shouldReturnNotFoundForInvalidEndpoint() {

        Response response =
                apiClient.getInvalidEndpoint();

        assertEquals(
                404, response.getStatusCode(),
                "Expected HTTP 404 for an invalid endpoint" );
    }

    @Test
    @Story("Invalid User Payload")
    @Severity(SeverityLevel.NORMAL)
    @Description("Validates the API behavior when an empty user payload is submitted.")
    void shouldHandleInvalidUserPayload() {

        Response response =
                apiClient.createUserWithInvalidPayload();

        assertNotNull(response);

        System.out.println(
                "Invalid payload HTTP status: " +
                        response.getStatusCode()
        );
    }

    @Test
    @Story("API Response Validation")
    @Severity(SeverityLevel.NORMAL)
    @Description("Validates response headers and response time for the users endpoint.")
    void shouldReturnValidResponseMetadata() {

        Response response =
                apiClient.getUsers();

        assertEquals(
                200,
                response.getStatusCode(),
                "Expected HTTP 200"
        );

        assertNotNull(
                response.getHeader("Content-Type"),
                "Content-Type header should be present"
        );

        assertTrue(
                response.getHeader("Content-Type")
                        .contains("application/json"),
                "Response should be JSON"
        );

        assertTrue(
                response.getTime() < 3000,
                "API response time should be below 3 seconds"
        );
    }

}