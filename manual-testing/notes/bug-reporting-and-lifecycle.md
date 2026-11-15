# Bug Reporting & Defect Life Cycle

## 1. Key Definitions
* **Defect / Bug:** Any deviation between the expected result and the actual result in a software application.
* **Severity:** Measures the technical impact of a defect on the system's functionality (determined by the QA Engineer).
  * *Critical / Blocker:* System crashes or blocks core functionality completely with no workaround.
  * *Major:* Major functionality is broken, though a workaround may exist.
  * *Minor:* Minor functional issue that does not significantly disrupt operations.
  * *Trivial / Cosmetic:* UI alignment, color, or spelling issues with zero functional impact.
* **Priority:** Measures how urgently a defect needs to be fixed based on business impact (determined by the Product Manager / Tech Lead) — `High`, `Medium`, `Low`.

---

## 2. Standard Bug Report Template

| Field | Example Entry |
| :--- | :--- |
| **Bug ID** | `BUG_ECOM_001` |
| **Title / Summary** | Application crashes with a white screen upon clicking 'Pay Now' at checkout |
| **Module** | Checkout & Payment |
| **Environment** | Windows 11, Google Chrome v130, Staging Server |
| **Severity** | Critical |
| **Priority** | High |
| **Pre-conditions** | User is logged in and has at least one item in the shopping cart. |
| **Steps to Reproduce** | 1. Navigate to the Shopping Cart.<br>2. Click 'Proceed to Checkout'.<br>3. Enter valid shipping details and select Card Payment.<br>4. Click the 'Pay Now' button. |
| **Expected Result** | Payment is processed and user is redirected to the Order Confirmation page. |
| **Actual Result** | Page crashes and displays a blank white screen (`HTTP 500 Internal Server Error`). |
| **Status** | New |

---

## 3. Defect / Bug Life Cycle

1. **New:** QA identifies and logs a new defect.
2. **Assigned:** Tech Lead reviews and assigns the bug to a developer.
3. **Open:** Developer analyzes and begins fixing the defect.
4. **Fixed:** Developer resolves the code issue and marks it ready for testing.
5. **Retest:** QA verifies the fix in the test environment.
6. **Verified & Closed:** If resolved, QA closes the bug. *(If the bug still persists, QA changes the status to **Reopened** and sends it back to the developer).*