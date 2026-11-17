# 📘 REST API Testing — Study Notes & QA Cheat Sheet

A concise reference guide covering core REST API concepts, HTTP methods, status codes, and Postman automation assertions.

---

## 1. What is API Testing?
API (Application Programming Interface) Testing validates the communication layer between the frontend (UI) and backend (server/database) directly at the message level—without relying on a graphical user interface.
- **Faster Execution:** Runs significantly faster than UI end-to-end tests.
- **Early Defect Detection:** Identifies backend logic, data validation, and security issues before UI completion.
- **Language Independent:** Exchanges structured data primarily using **JSON** or **XML**.

---

## 2. Core HTTP Methods (CRUD Operations)
| Method | Operation | Purpose | Idempotent? |
| :--- | :--- | :--- | :---: |
| **`GET`** | Read | Retrieve data from a server without modifying resources. | Yes |
| **`POST`** | Create | Submit new data to the server to create a new resource. | No |
| **`PUT`** | Update (Full) | Replace an existing resource completely with updated data. | Yes |
| **`PATCH`** | Update (Partial) | Modify only specific fields of an existing resource. | No |
| **`DELETE`** | Delete | Remove a specified resource from the server. | Yes |

---

## 3. Essential HTTP Status Codes
### `2xx` — Success
- **`200 OK`**: Request succeeded (`GET`, `PUT`, `DELETE`).
- **`201 Created`**: New resource successfully created (`POST`).
- **`204 No Content`**: Request succeeded, no response body returned.

### `4xx` — Client Errors
- **`400 Bad Request`**: Invalid syntax, missing required fields, or malformed JSON payload.
- **`401 Unauthorized`**: Authentication failed or missing/expired token.
- **`403 Forbidden`**: Authenticated user lacks permission to access the resource.
- **`404 Not Found`**: Requested endpoint or resource ID does not exist.
- **`405 Method Not Allowed`**: HTTP method is not supported for the endpoint.

### `5xx` — Server Errors
- **`500 Internal Server Error`**: Unhandled backend exception or server crash.
- **`502 Bad Gateway`**: Invalid response received from an upstream server.
- **`503 Service Unavailable`**: Server overloaded or undergoing maintenance.

---

## 4. Key API Components to Validate
1. **Status Code:** Verify expected HTTP response code (`200`, `201`, `400`, `404`).
2. **Response Time:** Ensure latency stays within acceptable SLA thresholds (e.g., `< 1000 ms`).
3. **Headers:** Validate `Content-Type: application/json`, caching, and security headers.
4. **Response Body (Schema & Data):** Check field names, data types, and accurate values.
5. **Negative Scenarios:** Test invalid payloads, missing headers, unauthorized tokens, and non-existent IDs.

---

## 5. Postman JavaScript Assertions (Chai BDD Snippets)
```javascript
// 1. Validate HTTP Status Code
pm.test("Status code is 200 OK", function () {
    pm.response.to.have.status(200);
});

// 2. Validate Response Time (< 1000ms)
pm.test("Response time is acceptable", function () {
    pm.expect(pm.response.responseTime).to.be.below(1000);
});

// 3. Validate JSON Body Field Value
pm.test("Verify user name in JSON response", function () {
    const jsonData = pm.response.json();
    pm.expect(jsonData.name).to.eql("Leanne Graham");
});
