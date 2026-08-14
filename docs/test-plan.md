# Test Plan

## 1. Project Information

**Project:** Enterprise Banking QA Automation Framework

**Application:** Banking Web Platform

**Document Type:** Test Plan

**QA Engineer:** Isabelly Kriwitzki

**Version:** 1.0

**Status:** Draft

---

# 2. Test Objectives

The main objective of this test effort is to validate the critical authentication flows of the banking web platform and establish a maintainable automation framework.

The test strategy focuses on:

- Functional validation
- Positive and negative authentication scenarios
- Regression protection
- Data-driven testing
- Automated test execution
- Defect evidence through screenshots
- Requirements traceability

---

# 3. Scope

## 3.1 In Scope

The following functionality is currently covered:

- User authentication
- Valid credentials
- Invalid password
- Locked user authentication
- Authentication error messages
- Successful login validation

The automation framework also covers:

- Selenium WebDriver
- Java 17
- JUnit 5
- Maven
- Page Object Model
- Explicit waits
- Parameterized tests
- Externalized test data
- Externalized configuration
- Screenshot capture on test failure

---

## 3.2 Out of Scope

The following areas are currently outside the scope:

- Payment processing
- Fund transfers
- Account creation
- Password recovery
- API testing
- Performance testing
- Security penetration testing
- Mobile application testing
- Database validation

These areas may be incorporated in future iterations.

---

# 4. Test Strategy

## 4.1 Functional Testing

Functional tests verify that the authentication functionality behaves according to the defined requirements.

---

## 4.2 Positive Testing

Positive scenarios validate that valid users can successfully authenticate.

Example:

```text
Valid username
+
Valid password
=
Successful authentication