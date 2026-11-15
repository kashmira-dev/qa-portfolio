# Black-Box Test Design Techniques

Black-box test design techniques help QA engineers systematically select the most effective test inputs without looking at the internal source code. They ensure maximum defect detection with minimal test cases.

---

## 1. Equivalence Partitioning (EP)

**Definition:**  
Equivalence Partitioning divides input data into logical groups (partitions/classes) where all values within a single group are expected to be processed identically by the system. Instead of testing every possible value, we select **one representative value** from each valid and invalid partition.

* **Purpose:** Reduces the total number of test cases while maintaining high test coverage.
* **Scenario:** User Registration Age Verification Field (Valid Range: `18` to `60` years)

| Partition Type | Condition | Representative Test Value | Expected Result |
| :--- | :--- | :--- | :--- |
| Invalid Partition 1 | Age < 18 | `15` | Validation Error: "Must be at least 18 years old" |
| Valid Partition | 18 ≤ Age ≤ 60 | `30` | Registration Allowed |
| Invalid Partition 2 | Age > 60 | `70` | Validation Error: "Maximum age limit is 60" |

---

## 2. Boundary Value Analysis (BVA)

**Definition:**  
Boundary Value Analysis focuses on testing values at the exact edges (boundaries) of valid and invalid input ranges (`min - 1`, `min`, `min + 1` and `max - 1`, `max`, `max + 1`).

* **Purpose:** Catches "off-by-one" coding errors (e.g., a developer writing `>` instead of `>=`), since defects most frequently occur at boundary edges.
* **Scenario:** User Registration Age Verification Field (Valid Range: `18` to `60` years)

| Boundary Condition | Test Value | Expected Result |
| :--- | :--- | :--- |
| Lower Boundary - 1 | `17` | Invalid (Error message displayed) |
| Lower Boundary | `18` | Valid (Accepted) |
| Lower Boundary + 1 | `19` | Valid (Accepted) |
| Upper Boundary - 1 | `59` | Valid (Accepted) |
| Upper Boundary | `60` | Valid (Accepted) |
| Upper Boundary + 1 | `61` | Invalid (Error message displayed) |

---

## 3. Decision Table Testing

**Definition:**  
Decision Table Testing uses a structured table of **conditions (inputs)** and **actions (expected outputs)** to test complex business logic where different combinations of inputs produce different results.

* **Purpose:** Ensures no combination of business rules is overlooked during testing.
* **Scenario:** E-Commerce Checkout Discount Calculation

| Rule | New Customer? | Valid Coupon? | Expected Discount |
| :--- | :--- | :--- | :--- |
| **Rule 1** | Yes | Yes | 20% |
| **Rule 2** | Yes | No | 10% |
| **Rule 3** | No | Yes | 5% |
| **Rule 4** | No | No | 0% |

---

## 4. State Transition Testing

**Definition:**  
State Transition Testing evaluates how a system transitions from one **state** to another when triggered by specific **events or inputs**, verifying both valid transitions and invalid/blocked transitions.

* **Purpose:** Essential for workflows with finite states (e.g., login lockouts, order statuses, ATM withdrawals).
* **Scenario:** User Login Account Lockout Policy (Max 3 Failed Attempts)

* **State 1 (Active):** Enter Invalid Password $\rightarrow$ Transitions to **State 2 (1 Failed Attempt)**
* **State 2 (1 Failed Attempt):** Enter Invalid Password $\rightarrow$ Transitions to **State 3 (2 Failed Attempts)**
* **State 3 (2 Failed Attempts):** Enter Invalid Password $\rightarrow$ Transitions to **State 4 (Account Locked)**
* **State 4 (Account Locked):** Enter Valid Password $\rightarrow$ Access Denied (Remains Locked)