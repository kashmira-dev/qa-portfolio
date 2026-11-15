# Agile / Scrum Workflow & Essential Testing Types

## 1. Agile & Scrum Basics for QA
* **Sprint:** A time-boxed iteration (usually 1–2 weeks) during which a team completes a set of user stories and delivers a working software increment.
* **User Story:** A short, simple description of a feature told from the perspective of the end user.
* **Acceptance Criteria (AC):** Predefined conditions that a software product must satisfy to be accepted by the user/QA. QA engineers derive test cases directly from Acceptance Criteria.
* **Daily Stand-up:** A brief 15-minute daily sync meeting to discuss yesterday's progress, today's plan, and any blockers.

---

## 2. Standard Jira Board Workflow
1. **To Do:** Backlog items/stories scheduled for the current sprint.
2. **In Progress:** Developer is actively writing code or fixing a defect.
3. **Ready for QA / In Testing:** Feature is deployed to the test environment; QA executes test cases and logs bugs if found.
4. **Done:** All acceptance criteria are met, QA signs off, and the ticket is closed.

---

## 3. Essential Testing Types

| Testing Type | Definition & Purpose | When It Is Performed |
| :--- | :--- | :--- |
| **Smoke Testing** | Broad, shallow testing to verify that critical core functionalities work and the build is stable enough for further testing. | Immediately after a new build is deployed to QA. |
| **Sanity Testing** | Narrow, deep testing focusing on a specific module or bug fix to verify that the targeted functionality works properly. | After receiving a build with minor code changes or bug fixes. |
| **Retesting** | Re-executing failed test cases on a specific defect to confirm that the reported bug has been successfully fixed. | After a developer marks a reported bug as `Fixed`. |
| **Regression Testing** | Re-testing unchanged parts of the application to ensure recent code changes or bug fixes have not introduced new side-effect defects. | After any bug fix, code refactoring, or new feature integration. |