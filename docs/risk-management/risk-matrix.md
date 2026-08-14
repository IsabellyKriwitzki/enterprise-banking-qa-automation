# Authentication Risk Matrix

## 1. Purpose

This risk matrix identifies and prioritizes potential risks related to
the Authentication module of the FinCore Banking Platform.

The objective is to ensure that high-impact and high-probability risks
receive appropriate testing priority.

---

## 2. Risk Assessment Model

Risk Score is calculated using:

**Risk Score = Impact × Probability**

### Impact

| Score | Description |
|---|---|
| 1 | Negligible |
| 2 | Low |
| 3 | Medium |
| 4 | High |
| 5 | Critical |

### Probability

| Score | Description |
|---|---|
| 1 | Very Unlikely |
| 2 | Unlikely |
| 3 | Possible |
| 4 | Likely |
| 5 | Very Likely |

### Risk Classification

| Score | Risk Level |
|---|---|
| 1–4 | Low |
| 5–9 | Medium |
| 10–16 | High |
| 17–25 | Critical |

---

## 3. Authentication Risk Assessment

| Risk ID | Risk | Impact | Probability | Score | Level | Related Test |
|---|---|---:|---:|---:|---|---|
| RISK-AUTH-001 | Unauthorized access to customer accounts | 5 | 4 | 20 | Critical | TC-AUTH-001, TC-AUTH-002, TC-AUTH-003 |
| RISK-AUTH-002 | Authentication failure prevents legitimate customers from accessing accounts | 4 | 3 | 12 | High | TC-AUTH-001 |
| RISK-AUTH-003 | Account lockout mechanism fails | 5 | 3 | 15 | High | TC-AUTH-005 |
| RISK-AUTH-004 | Mandatory authentication fields are not validated | 3 | 3 | 9 | Medium | TC-AUTH-004 |
| RISK-AUTH-005 | User session remains active after timeout | 5 | 3 | 15 | High | TC-AUTH-006 |
| RISK-AUTH-006 | Logout does not properly terminate the session | 5 | 2 | 10 | High | TC-AUTH-007 |

---

## 4. Risk-Based Testing Strategy

Critical and high-risk scenarios shall receive priority during
test execution and automation.

The following areas are considered highest priority:

1. Authentication with valid credentials.
2. Authentication with invalid credentials.
3. Protection against unauthorized access.
4. Account lockout.
5. Session timeout.
6. Secure logout.

These scenarios should be included in the regression test suite
and executed automatically as part of the CI/CD pipeline.

---

## 5. Risk Mitigation

The following measures will be implemented as the automation framework
evolves:

- Automated positive and negative authentication tests.
- API-level authentication validation.
- UI authentication testing.
- Session management testing.
- Regression testing through CI/CD.
- Automated test reporting.
- Traceability between requirements, risks and test cases.

---

## 6. Future Improvements

The risk model may be extended to cover:

- Authorization and role-based access control.
- Transaction security.
- Payment processing.
- Money transfers.
- Sensitive data exposure.
- API security.
- Authentication token management.
- Performance and availability risks.