# Authentication Test Cases

## TC-AUTH-001 — Successful Customer Login

| Field | Details |
|---|---|
| Test Case ID | TC-AUTH-001 |
| Requirement | REQ-AUTH-001 |
| Title | Successful customer login |
| Priority | Critical |
| Test Type | Functional / Positive |
| Preconditions | Customer account exists and is active |

### Test Data

- Username: valid registered customer
- Password: valid customer password

### Test Steps

1. Open the FinCore Banking Platform login page.
2. Enter a valid username.
3. Enter a valid password.
4. Click the **Login** button.

### Expected Result

The customer is successfully authenticated and redirected to the account dashboard.

---

## TC-AUTH-002 — Login with Invalid Password

| Field | Details |
|---|---|
| Test Case ID | TC-AUTH-002 |
| Requirement | REQ-AUTH-002 |
| Title | Login with invalid password |
| Priority | High |
| Test Type | Functional / Negative |
| Preconditions | Customer account exists and is active |

### Test Data

- Username: valid registered customer
- Password: invalid password

### Test Steps

1. Open the login page.
2. Enter a valid username.
3. Enter an incorrect password.
4. Click the **Login** button.

### Expected Result

Authentication is rejected and an appropriate error message is displayed.

---

## TC-AUTH-003 — Login with Unknown Username

| Field | Details |
|---|---|
| Test Case ID | TC-AUTH-003 |
| Requirement | REQ-AUTH-002 |
| Title | Login with unknown username |
| Priority | High |
| Test Type | Functional / Negative |
| Preconditions | Login page is available |

### Test Data

- Username: unregistered username
- Password: valid-format password

### Test Steps

1. Open the login page.
2. Enter an unregistered username.
3. Enter a password.
4. Click the **Login** button.

### Expected Result

Authentication is rejected and access to the account dashboard is not granted.

---

## TC-AUTH-004 — Login with Empty Mandatory Fields

| Field | Details |
|---|---|
| Test Case ID | TC-AUTH-004 |
| Requirement | REQ-AUTH-003 |
| Title | Login with empty mandatory fields |
| Priority | Medium |
| Test Type | Validation / Negative |
| Preconditions | Login page is available |

### Test Steps

1. Open the login page.
2. Leave the username field empty.
3. Leave the password field empty.
4. Click the **Login** button.

### Expected Result

The system displays validation messages indicating that the mandatory fields must be completed.

---

## TC-AUTH-005 — Account Lockout After Failed Attempts

| Field | Details |
|---|---|
| Test Case ID | TC-AUTH-005 |
| Requirement | REQ-AUTH-004 |
| Title | Account lockout after consecutive failed attempts |
| Priority | Critical |
| Test Type | Security / Negative |
| Preconditions | Customer account is active |

### Test Steps

1. Open the login page.
2. Enter a valid username.
3. Enter an incorrect password.
4. Repeat the failed authentication attempt until the configured threshold is reached.
5. Attempt to authenticate again.

### Expected Result

The account is temporarily locked and further authentication attempts are rejected according to the configured security policy.

---

## TC-AUTH-006 — Session Timeout

| Field | Details |
|---|---|
| Test Case ID | TC-AUTH-006 |
| Requirement | REQ-AUTH-005 |
| Title | Session expiration after inactivity |
| Priority | High |
| Test Type | Security / Functional |
| Preconditions | Customer is successfully authenticated |

### Test Steps

1. Log in with valid credentials.
2. Remain inactive for the configured session timeout period.
3. Attempt to access a protected page.

### Expected Result

The session has expired and the customer is redirected to the authentication page.

---

## TC-AUTH-007 — Successful Logout

| Field | Details |
|---|---|
| Test Case ID | TC-AUTH-007 |
| Requirement | REQ-AUTH-006 |
| Title | Successful customer logout |
| Priority | High |
| Test Type | Functional / Positive |
| Preconditions | Customer is successfully authenticated |

### Test Steps

1. Log in with valid credentials.
2. Navigate to the account dashboard.
3. Select **Logout**.

### Expected Result

The session is terminated and the customer is redirected to the login page.