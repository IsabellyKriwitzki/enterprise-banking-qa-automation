# Test Cases

## 1. Purpose

This document defines the functional test cases covered by the Enterprise Banking QA Automation Framework.

The test cases provide traceability between functional scenarios and automated tests implemented in the framework.

---

# 2. Login Test Cases

## TC-LOGIN-001 — Successful Login

| Field            | Description                  |
| ---------------- | ---------------------------- |
| **Test Case ID** | TC-LOGIN-001                 |
| **Module**       | Authentication               |
| **Scenario**     | Login with valid credentials |
| **Priority**     | High                         |
| **Severity**     | Critical                     |
| **Test Type**    | Functional / UI              |
| **Automation**   | Automated                    |
| **Tag**          | regression                   |

### Preconditions

* Application is available.
* User has valid credentials.
* Browser is available.

### Test Data

Valid username and password from the external login test data file.

### Steps

1. Open the login page.
2. Enter a valid username.
3. Enter a valid password.
4. Click the login button.
5. Verify the resulting application state.

### Expected Result

The user is successfully authenticated and the application displays the authenticated state.

### Automation

Implemented in:

```text
LoginTest
```

---

## TC-LOGIN-002 — Login With Invalid Credentials

| Field            | Description                    |
| ---------------- | ------------------------------ |
| **Test Case ID** | TC-LOGIN-002                   |
| **Module**       | Authentication                 |
| **Scenario**     | Login with invalid credentials |
| **Priority**     | High                           |
| **Severity**     | Major                          |
| **Test Type**    | Negative / UI                  |
| **Automation**   | Automated                      |
| **Tag**          | regression                     |

### Preconditions

* Application is available.
* Login page is accessible.

### Test Data

Invalid authentication credentials from the external login test data file.

### Steps

1. Open the login page.
2. Enter invalid credentials.
3. Click the login button.
4. Inspect the authentication response.

### Expected Result

The authentication attempt is rejected and an authentication error message is displayed.

### Automation

Implemented in:

```text
LoginTest
```

---

## TC-LOGIN-003 — Parameterized Login Validation

| Field            | Description                                               |
| ---------------- | --------------------------------------------------------- |
| **Test Case ID** | TC-LOGIN-003                                              |
| **Module**       | Authentication                                            |
| **Scenario**     | Execute multiple login scenarios using external test data |
| **Priority**     | High                                                      |
| **Severity**     | Major                                                     |
| **Test Type**    | Data-Driven / UI                                          |
| **Automation**   | Automated                                                 |
| **Tag**          | regression                                                |

### Preconditions

* Login test data file is available.
* Application is available.

### Steps

1. Load login scenarios from the CSV test data file.
2. Execute the login workflow for each dataset.
3. Evaluate the expected result defined by the dataset.
4. Validate the resulting application behavior.

### Expected Result

Each dataset produces the expected authentication behavior defined in the test data.

### Automation

Implemented using:

```text
JUnit 5 ParameterizedTest
MethodSource
CsvReader
LoginTestData
```

---

# 3. API Test Cases

## TC-API-001 — Retrieve Users

| Field            | Description      |
| ---------------- | ---------------- |
| **Test Case ID** | TC-API-001       |
| **Module**       | Users API        |
| **Scenario**     | Retrieve users   |
| **Priority**     | High             |
| **Severity**     | Major            |
| **Test Type**    | API / Functional |
| **Automation**   | Automated        |
| **Tag**          | api              |

### Preconditions

* API endpoint is available.
* API base URL is correctly configured.

### Steps

1. Send a `GET` request to `/users`.
2. Validate the HTTP response status.
3. Validate the response body.
4. Validate that the returned collection is not empty.

### Expected Result

The API returns:

```text
HTTP 200 OK
```

The response contains a non-empty collection of users.

### Automation

Implemented in:

```text
ApiTest.shouldRetrieveUsersSuccessfully()
```

---

## TC-API-002 — Create User

| Field            | Description       |
| ---------------- | ----------------- |
| **Test Case ID** | TC-API-002        |
| **Module**       | Users API         |
| **Scenario**     | Create a new user |
| **Priority**     | High              |
| **Severity**     | Major             |
| **Test Type**    | API / Functional  |
| **Automation**   | Automated         |
| **Tag**          | api               |

### Preconditions

* API endpoint is available.
* API base URL is correctly configured.

### Test Data

```json
{
  "name": "Isabelly QA",
  "job": "QA Automation Engineer"
}
```

### Steps

1. Create a `UserRequest` object.
2. Send a `POST` request to `/users`.
3. Deserialize the response into `UserResponse`.
4. Validate the returned user information.
5. Validate that an ID was generated.

### Expected Result

The API returns a valid user response containing:

* Expected name
* Expected job
* A generated user ID

### Automation

Implemented in:

```text
ApiTest.shouldCreateUserSuccessfully()
```

---

# 4. Smoke Test Cases

## TC-SMOKE-001 — Banking QA Framework Execution

| Field            | Description                  |
| ---------------- | ---------------------------- |
| **Test Case ID** | TC-SMOKE-001                 |
| **Module**       | Framework                    |
| **Scenario**     | Validate framework execution |
| **Priority**     | Critical                     |
| **Severity**     | Critical                     |
| **Test Type**    | Smoke                        |
| **Automation**   | Automated                    |
| **Tag**          | smoke                        |

### Preconditions

* Java 17 is installed.
* Maven dependencies are available.
* Browser environment is available.
* Application/test environment is accessible.

### Steps

1. Start the test execution.
2. Initialize the WebDriver.
3. Execute the smoke scenario.
4. Validate that the test completes successfully.
5. Close the browser.

### Expected Result

The smoke test completes successfully without errors.

### Automation

Implemented in:

```text
SmokeTest
```

---

# 5. Test Case Summary

| ID           | Module         | Type           | Automation | Priority |
| ------------ | -------------- | -------------- | ---------- | -------- |
| TC-LOGIN-001 | Authentication | Functional UI  | Automated  | High     |
| TC-LOGIN-002 | Authentication | Negative UI    | Automated  | High     |
| TC-LOGIN-003 | Authentication | Data-Driven UI | Automated  | High     |
| TC-API-001   | Users API      | Functional API | Automated  | High     |
| TC-API-002   | Users API      | Functional API | Automated  | High     |
| TC-SMOKE-001 | Framework      | Smoke          | Automated  | Critical |

---

# 6. Traceability

The test cases are mapped to automated implementation classes.

| Test Case    | Automated Test                              |
| ------------ | ------------------------------------------- |
| TC-LOGIN-001 | `LoginTest`                                 |
| TC-LOGIN-002 | `LoginTest`                                 |
| TC-LOGIN-003 | `LoginTest`                                 |
| TC-API-001   | `ApiTest.shouldRetrieveUsersSuccessfully()` |
| TC-API-002   | `ApiTest.shouldCreateUserSuccessfully()`    |
| TC-SMOKE-001 | `SmokeTest`                                 |

---

# 7. Automation Status

Current implementation status:

```text
Login UI Tests          → Automated
Parameterized Testing   → Automated
Users GET API           → Automated
Users POST API          → Automated
Smoke Test              → Automated
Screenshot on Failure   → Automated
CI Execution            → Automated
Allure Results          → Integrated
```

---

# 8. Future Test Coverage

The following scenarios are candidates for future automation:

### Authentication

* Empty username
* Empty password
* Both fields empty
* Account lockout
* Session timeout
* Logout
* Password reset

### API

* Invalid request payload
* Missing required fields
* Invalid endpoint
* Unauthorized request
* Response schema validation
* Boundary values
* Error response validation
* API contract validation

### Security

* Authentication token validation
* Authorization testing
* Input validation
* Sensitive data exposure checks

### Performance

* API response time validation
* Concurrent API requests
* Load testing
* Stress testing

---

# 9. Test Execution Evidence

Automated execution is integrated into GitHub Actions.

The CI pipeline executes the Maven test suite in a Linux environment and publishes test artifacts for further analysis.

The framework also captures screenshots when UI tests fail, providing additional evidence for defect investigation.
