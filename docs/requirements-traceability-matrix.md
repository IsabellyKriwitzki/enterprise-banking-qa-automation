# Requirements Traceability Matrix

## Project

**Project:** Enterprise Banking QA Automation Framework

**Application:** Banking Web Platform

**QA Engineer:** Isabelly Kriwitzki

---

## Traceability Matrix

| Requirement ID | Requirement | Test Case ID | Automated Test | Test Type | Priority | Status |
|---|---|---|---|---|---|---|
| REQ-AUTH-001 | System shall allow users to log in with valid credentials | TC-AUTH-001 | `loginShouldBehaveAsExpected` | Positive | High | Automated |
| REQ-AUTH-002 | System shall reject invalid credentials | TC-AUTH-002 | `loginShouldBehaveAsExpected` | Negative | High | Automated |
| REQ-AUTH-003 | System shall prevent locked users from logging in | TC-AUTH-003 | `loginShouldBehaveAsExpected` | Negative | High | Automated |

---

## Requirement Details

### REQ-AUTH-001 — Valid Authentication

**Description**

The system shall authenticate a registered user when valid credentials are provided.

**Priority:** High

**Test Case:** TC-AUTH-001

**Automation:** Automated

**Expected Result**

The user should be successfully authenticated and redirected to the products page.

---

### REQ-AUTH-002 — Invalid Password

**Description**

The system shall reject authentication attempts when an incorrect password is provided.

**Priority:** High

**Test Case:** TC-AUTH-002

**Automation:** Automated

**Expected Result**

The system should display an authentication error and prevent access to the protected area.

---

### REQ-AUTH-003 — Locked Account

**Description**

The system shall prevent locked users from accessing the application.

**Priority:** High

**Test Case:** TC-AUTH-003

**Automation:** Automated

**Expected Result**

The system should display an appropriate error message and prevent successful authentication.

---

## Coverage Summary

| Area | Requirements | Automated Tests | Coverage |
|---|---:|---:|---:|
| Authentication | 3 | 3 | 100% |

---

## Test Data

Test data is maintained externally in:

`src/test/resources/test-data/login-data.csv`

This allows multiple authentication scenarios to be executed using JUnit 5 parameterized tests.

---

## Automation Architecture

```text
Requirement
     ↓
Test Case
     ↓
Test Data
     ↓
Parameterized Test
     ↓
Page Object
     ↓
Selenium WebDriver
     ↓
Assertion
     ↓
Test Result
     ↓
Screenshot on Failure