# Test Scenarios & Test Cases: User Login Module

This document outlines high-level Test Scenarios and detailed Positive/Negative Test Cases for a standard web application Login module.

---

## 1. High-Level Test Scenarios

| Scenario ID | Module | Test Scenario Description |
| :--- | :--- | :--- |
| **TS_LOGIN_01** | Authentication | Verify user login functionality with valid credentials (Positive). |
| **TS_LOGIN_02** | Authentication | Verify system behavior when invalid credentials are entered (Negative). |
| **TS_LOGIN_03** | Authentication | Verify mandatory field validation when login fields are left empty (Negative). |
| **TS_LOGIN_04** | Authentication | Verify password masking and visibility toggle functionality (UI/Security). |

---

## 2. Detailed Test Cases

| Test Case ID | Scenario ID | Test Case Title | Pre-conditions | Test Steps | Test Data | Expected Result | Status |
| :--- | :--- | :--- | :--- | :--- | :--- | :--- | :--- |
| **TC_LOGIN_001** | TS_LOGIN_01 | Verify login with valid email and valid password | User has a registered active account and is on the Login page. | 1. Enter valid email.<br>2. Enter valid password.<br>3. Click the 'Login' button. | Email: `kashmira@example.com`<br>Password: `ValidPass@123` | User is authenticated and redirected to the Dashboard. | Pass |
| **TC_LOGIN_002** | TS_LOGIN_02 | Verify login with valid email and invalid password | User is on the Login page. | 1. Enter valid email.<br>2. Enter incorrect password.<br>3. Click the 'Login' button. | Email: `kashmira@example.com`<br>Password: `WrongPass@99` | Login fails; error message `"Invalid email or password"` is displayed. | Pass |
| **TC_LOGIN_003** | TS_LOGIN_02 | Verify login with unregistered email address | User is on the Login page. | 1. Enter unregistered email.<br>2. Enter any password.<br>3. Click the 'Login' button. | Email: `unknown@example.com`<br>Password: `Test@123` | Login fails; error message `"Invalid email or password"` is displayed. | Pass |
| **TC_LOGIN_004** | TS_LOGIN_03 | Verify login when both email and password fields are empty | User is on the Login page. | 1. Leave email field blank.<br>2. Leave password field blank.<br>3. Click the 'Login' button. | Email: `""`<br>Password: `""` | Validation errors `"Email is required"` and `"Password is required"` are displayed. | Pass |
| **TC_LOGIN_005** | TS_LOGIN_04 | Verify password field masks characters by default | User is on the Login page. | 1. Click on the password input field.<br>2. Type a password. | Password: `Secret@123` | Typed characters are masked with dots/asterisks (`••••••••••`). | Pass |