# Bug Report Example

## BR-LOGIN-001 — Authentication Error Message Not Displayed

### 1. Summary

**Authentication error message is not displayed when a user submits invalid login credentials.**

---

## 2. Defect Information

| Field                | Value             |
| -------------------- | ----------------- |
| **Bug ID**           | BR-LOGIN-001      |
| **Module**           | Authentication    |
| **Component**        | Login             |
| **Type**             | Functional        |
| **Priority**         | High              |
| **Severity**         | Major             |
| **Status**           | Open              |
| **Environment**      | QA                |
| **Detected By**      | QA Automation     |
| **Detection Method** | Automated UI Test |

---

## 3. Preconditions

* Application is available.
* Login page is accessible.
* User is not authenticated.
* Invalid credentials are available for testing.

---

## 4. Test Data

```text
Username: invalid-user
Password: invalid-password
```

No production credentials or sensitive customer data should be used.

---

## 5. Steps to Reproduce

1. Open the application login page.
2. Enter an invalid username.
3. Enter an invalid password.
4. Click the login button.
5. Observe the authentication response.

---

## 6. Expected Result

The authentication attempt should be rejected and a clear error message should be displayed to the user.

Example:

```text
Invalid username or password.
```

The message should not expose sensitive information about which credential was incorrect.

---

## 7. Actual Result

The authentication attempt is rejected, but the expected authentication error message is not displayed.

The user receives no clear feedback explaining that authentication failed.

---

## 8. Business Impact

The issue negatively affects the login user experience and may cause users to believe that the application is not responding.

For a banking application, clear authentication feedback is particularly important because login is a critical entry point to protected functionality.

---

## 9. Severity Rationale

**Severity: Major**

The defect affects a critical authentication workflow and prevents appropriate user feedback.

However, the authentication control itself is still rejecting the invalid credentials, so the issue does not necessarily indicate an authentication bypass.

---

## 10. Priority Rationale

**Priority: High**

Authentication is a critical application area and the defect should be addressed before a production release.

---

## 11. Evidence

The automation framework is configured to capture screenshots when UI tests fail.

Evidence should include:

* Screenshot
* Test execution timestamp
* Environment
* Browser version
* Test case ID
* Relevant application logs

Example evidence location:

```text
target/screenshots/
```

---

## 12. Automation Reference

Related automated test:

```text
LoginTest.loginShouldBehaveAsExpected()
```

Related test case:

```text
TC-LOGIN-002
```

---

## 13. Investigation Notes

The QA engineer should investigate:

* Browser console errors
* Network requests
* Authentication API response
* DOM state after login
* Error-message locator
* Application logs
* Backend authentication response

The objective is to determine whether the problem originates from:

```text
Frontend
   ↓
Authentication API
   ↓
Backend
   ↓
Error handling
```

---

## 14. Suggested Regression Coverage

After the defect is fixed, the following scenarios should be executed:

| Scenario          | Expected                           |
| ----------------- | ---------------------------------- |
| Valid credentials | Successful authentication          |
| Invalid username  | Error message displayed            |
| Invalid password  | Error message displayed            |
| Empty username    | Validation message displayed       |
| Empty password    | Validation message displayed       |
| Both fields empty | Validation messages displayed      |
| Account locked    | Appropriate account status message |

---

## 15. Defect Lifecycle

```text
Open
  ↓
Assigned
  ↓
In Progress
  ↓
Fixed
  ↓
Ready for Retest
  ↓
Retest
  ↓
Verified
  ↓
Closed
```

If the issue persists:

```text
Retest
  ↓
Failed
  ↓
Reopened
```

---

## 16. QA Traceability

```text
Requirement
     ↓
Test Case
     ↓
Automated Test
     ↓
Defect
     ↓
Fix
     ↓
Regression Test
     ↓
Verification
```

This traceability model supports structured defect management and provides visibility between requirements, testing and defects.

---

## 17. Note

This document is a **demonstration bug report** created for the portfolio project.

It does not represent a confirmed production defect.
