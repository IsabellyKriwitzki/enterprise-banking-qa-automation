# Enterprise Banking QA Automation Framework

![Java](https://img.shields.io/badge/Java-17-orange)
![Selenium](https://img.shields.io/badge/Selenium-4.38.0-green)
![JUnit](https://img.shields.io/badge/JUnit-5-blue)
![REST Assured](https://img.shields.io/badge/REST%20Assured-5.5.6-blue)
![Maven](https://img.shields.io/badge/Maven-build-red)
![CI](https://img.shields.io/badge/CI-GitHub%20Actions-black)
![Allure](https://img.shields.io/badge/Reports-Allure-purple)

## Overview

The **Enterprise Banking QA Automation Framework** is a Java-based Quality Engineering project designed to demonstrate a scalable approach to automated testing of banking-related applications and services.

The framework combines **UI automation, API testing, parameterized testing, test data management, failure evidence and CI/CD execution**.

The project follows common enterprise QA practices with a focus on:

* Maintainability
* Reusability
* Test isolation
* Clear separation of responsibilities
* Automated regression coverage
* Continuous integration
* Test reporting
* Failure diagnostics

---

## Quality Engineering Approach

The framework is designed around the following testing pyramid:

```text
                 ┌───────────────────┐
                 │     UI Tests      │
                 │   Selenium/Java   │
                 └─────────┬─────────┘
                           │
                 ┌─────────▼─────────┐
                 │   API / Service   │
                 │   REST Assured    │
                 └─────────┬─────────┘
                           │
                 ┌─────────▼─────────┐
                 │   Test Utilities  │
                 │   Data / Config   │
                 └───────────────────┘
```

The strategy prioritizes fast and reliable API validation while maintaining UI coverage for critical user journeys.

---

## Tech Stack

| Technology         | Purpose                            |
| ------------------ | ---------------------------------- |
| Java 17            | Programming language               |
| Maven              | Build and dependency management    |
| JUnit 5            | Test execution and assertions      |
| Selenium WebDriver | UI automation                      |
| REST Assured       | API automation                     |
| Jackson            | JSON serialization/deserialization |
| Allure             | Test reporting                     |
| Git                | Version control                    |
| GitHub             | Source code repository             |
| GitHub Actions     | CI/CD                              |
| Chrome             | Browser automation                 |
| CSV                | External test data                 |

---

## Test Coverage

### UI Testing

Current UI automation includes:

* Login functionality
* Positive authentication scenario
* Negative authentication scenarios
* Parameterized login tests
* Page Object Model implementation
* Screenshot capture on test failure

### API Testing

Current API automation includes:

* GET users
* POST user
* HTTP status validation
* Response body validation
* JSON validation
* Request serialization
* Response deserialization

### Smoke Testing

Smoke tests validate that the framework and critical application functionality can be executed successfully.

### Regression Testing

Parameterized scenarios are used to validate multiple combinations of login test data.

---

## Project Architecture

The framework uses a layered architecture to separate test logic from implementation details.

```text
src/
└── test/
    ├── java/
    │   └── com.isabelly.qa/
    │
    │       ├── api/
    │       │   └── API clients
    │       │
    │       ├── base/
    │       │   └── Test lifecycle
    │       │
    │       ├── config/
    │       │   └── Environment configuration
    │       │
    │       ├── driver/
    │       │   └── WebDriver management
    │       │
    │       ├── extensions/
    │       │   └── JUnit extensions
    │       │
    │       ├── models/
    │       │   └── Request/response models
    │       │
    │       ├── pages/
    │       │   └── Page Objects
    │       │
    │       ├── tests/
    │       │   └── Automated tests
    │       │
    │       └── utils/
    │           └── Reusable utilities
    │
    └── resources/
        └── Test data and configuration

docs/
└── test-strategy.md
```

---

## Design Principles

### Page Object Model

UI interactions are encapsulated inside Page Objects.

This reduces duplication and keeps test scenarios focused on business behavior rather than Selenium implementation details.

### API Client Layer

API requests are centralized in dedicated API client classes.

This improves:

* Reusability
* Readability
* Maintainability
* Separation of concerns

### Data-Driven Testing

Login scenarios use external CSV test data and JUnit parameterized tests.

This allows multiple scenarios to be executed without duplicating test implementation.

### Centralized WebDriver Management

Browser lifecycle management is handled by a dedicated `DriverManager`.

The configuration supports CI environments using headless Chrome.

### Failure Evidence

A JUnit `TestWatcher` extension captures screenshots when UI tests fail.

This provides additional diagnostic information during test investigation.

---

## Test Tags

JUnit tags are used to categorize test suites.

Current tags include:

```text
@Tag("api")
@Tag("smoke")
@Tag("regression")
```

This allows selective execution of specific test categories.

Example:

```bash
mvn test -Dgroups=smoke
```

---

## Running Tests Locally

### Prerequisites

Install:

* Java 17+
* Maven
* Google Chrome
* Git

Verify Java:

```bash
java -version
```

Verify Maven:

```bash
mvn -version
```

### Execute the complete test suite

```bash
mvn clean test
```

### Execute Smoke Tests

```bash
mvn test -Dgroups=smoke
```

### Execute Regression Tests

```bash
mvn test -Dgroups=regression
```

---

## CI/CD Pipeline

The project uses **GitHub Actions** to automatically execute the test suite.

The pipeline is triggered by:

* Push to `main`
* Push to `master`
* Pull requests
* Manual workflow execution

### Pipeline flow

```text
Git Push / Pull Request
          │
          ▼
   Checkout Repository
          │
          ▼
      Java 17 Setup
          │
          ▼
     Maven Dependency
         Cache
          │
          ▼
      Chrome Setup
          │
          ▼
    Browser Verification
          │
          ▼
      Maven Test Suite
          │
          ▼
    JUnit Test Results
          │
          ▼
    Allure Artifacts
```

The CI environment executes the automated tests on **Ubuntu Linux**.

Chrome is configured for headless execution to support browser automation in the CI environment.

---

## CI Quality Gate

The current CI pipeline considers the build successful when the automated test suite completes without failures or errors.

Example successful execution:

```text
Tests run: 6
Failures: 0
Errors: 0
Skipped: 0

BUILD SUCCESS
```

The CI pipeline therefore provides automated feedback on every relevant code change.

---

## Test Reporting

The framework integrates **Allure** for test reporting.

Test execution results are generated during the Maven test execution and uploaded by GitHub Actions as CI artifacts.

The reports can be used to investigate:

* Passed tests
* Failed tests
* Test duration
* Execution history
* Failure evidence

---

## Failure Diagnostics

For UI test failures, the framework uses a JUnit extension to capture screenshots.

The flow is:

```text
UI Test Failure
      │
      ▼
ScreenshotExtension
      │
      ▼
ScreenshotUtils
      │
      ▼
Screenshot Evidence
```

This helps distinguish application failures from automation or environment problems.

---

## Test Data

External test data is used for parameterized login scenarios.

Example structure:

```text
test-data/
└── login-data.csv
```

This approach allows multiple authentication scenarios to be maintained independently from the test implementation.

Sensitive credentials and real customer information must never be committed to the repository.

---

## Documentation

The project includes a dedicated QA Test Strategy covering:

* Test scope
* Test levels
* Test types
* Automation strategy
* Test data strategy
* Environment strategy
* CI/CD strategy
* Entry criteria
* Exit criteria
* Defect management
* Severity classification
* Quality metrics
* Risks and mitigations
* Future improvements

Documentation:

`docs/test-strategy.md`

---

## Current Automation Scope

| Area                        | Status |
| --------------------------- | ------ |
| Java 17                     | ✅      |
| Maven                       | ✅      |
| JUnit 5                     | ✅      |
| Selenium UI Automation      | ✅      |
| REST API Automation         | ✅      |
| Page Object Model           | ✅      |
| Parameterized Tests         | ✅      |
| External Test Data          | ✅      |
| Screenshot on Failure       | ✅      |
| Smoke Tests                 | ✅      |
| Regression Tests            | ✅      |
| Allure Integration          | ✅      |
| GitHub Actions              | ✅      |
| Linux CI Execution          | ✅      |
| Headless Chrome             | ✅      |
| Test Strategy Documentation | ✅      |

---

## Future Improvements

The framework is designed to evolve toward a broader Quality Engineering platform.

Planned improvements include:

* Expand API test coverage
* Add negative API scenarios
* Add JSON schema validation
* Add authentication/token testing
* Expand UI Page Objects
* Improve test data generation
* Add database validation
* Introduce performance testing with k6
* Add security testing
* Improve Allure reporting in CI
* Separate Smoke and Regression CI pipelines
* Introduce parallel execution where appropriate
* Add quality metrics dashboards
* Improve test traceability
* Add automated API contract testing

---

## Project Goals

The main goal of this project is to demonstrate practical Quality Engineering skills across the complete automation lifecycle:

```text
Test Design
     ↓
Test Automation
     ↓
API + UI Validation
     ↓
Test Data Management
     ↓
Failure Diagnostics
     ↓
Reporting
     ↓
CI/CD
     ↓
Continuous Quality Feedback
```

---

## Author

**Isabelly Kriwitzki**

QA Engineer | Quality Assurance | Test Automation

Focus areas:

* Test Automation
* API Testing
* UI Testing
* Java
* Selenium
* REST Assured
* CI/CD
* Quality Engineering

---

## License

This project is intended for educational, portfolio and demonstration purposes.
