# 📘 Web UI Test Automation Notes (Selenium + Java + TestNG)

## 1. Page Object Model (POM) Design Pattern
* **What is POM?** A design pattern in test automation that creates an Object Repository for web UI elements. Each web page in the application has a corresponding Java class (`LoginPage`, `InventoryPage`, `CheckoutPage`).
* **Why use POM?**
  * **Maintainability:** If a UI locator changes on a page, we only update it in one Page class instead of every test script.
  * **Code Reusability:** Page actions (e.g., `login(user, pass)`) can be reused across multiple test cases.
  * **Readability:** Separates test logic (`SauceDemoE2ETest`) from element locators (`pages/`).

---

## 2. Selenium Locator Strategy (Priority Order)
1. **`By.id()`** — Fastest and most unique locator.
2. **`By.name()`** — Reliable when ID is not available.
3. **`By.cssSelector()`** — Faster than XPath and cleaner for complex attributes (e.g., `h3[data-test='error']`).
4. **`By.xpath()`** — Used when traversing parent/child DOM nodes or matching visible text.

---

## 3. Synchronization (Waits in Selenium)
* **Implicit Wait:** Tells WebDriver to poll the DOM for a set duration (`Duration.ofSeconds(10)`) before throwing a `NoSuchElementException`. Applied globally across the driver session.
* **Explicit Wait (`WebDriverWait`):** Waits for a specific condition (`ExpectedConditions.visibilityOfElementLocated(...)`) to occur before proceeding. Best for dynamic elements (AJAX/React renders).
* **Fluent Wait:** An explicit wait that defines polling frequency and ignores specific exceptions.

---

## 4. TestNG Annotations & Assertions
* **`@BeforeMethod`:** Runs before each `@Test` method (used in `BaseTest` to launch Chrome and open SauceDemo).
* **`@Test`:** Marks a method as an automated test case (supports `priority` and `description`).
* **`@AfterMethod`:** Runs after each `@Test` method (used to safely call `driver.quit()`).
* **Hard Assert (`Assert.assertEquals`):** Immediately stops test execution if the assertion fails.
* **Soft Assert (`SoftAssert`):** Collects all assertion failures during a test and reports them at the end via `assertAll()`.

---

## 5. Selenium WebDriver vs. Cypress
| Feature | Selenium (Java + TestNG) | Cypress (JavaScript) |
| :--- | :--- | :--- |
| **Architecture** | Communicates via W3C WebDriver protocol outside the browser | Runs directly inside the browser event loop |
| **Language Support** | Java, Python, C#, JS, Ruby | JavaScript / TypeScript only |
| **Browser Support** | Chrome, Firefox, Edge, Safari | Chromium, Firefox, Electron |
| **Multi-Tab / Domain** | Full native support | Limited cross-origin / multi-tab support |