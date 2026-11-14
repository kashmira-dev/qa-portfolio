# SDLC & STLC — My Notes

## What is SDLC?
SDLC = Software Development Life Cycle. It's the full process of building software, from idea to retirement.

### The 6 Phases (in order):
1. **Requirements** — What does the user need? (e.g., "I want to buy shoes online")
2. **Design** — How will we build it? (UI mockups, database design)
3. **Development** — Actually writing the code.
4. **Testing** — Finding bugs before users do. ← THIS IS WHERE WE FIT
5. **Deployment** — Releasing it to users (putting it "live")
6. **Maintenance** — Fixing bugs users find, adding new features

## What is STLC?
STLC = Software Testing Life Cycle. It's the testing-specific subset of SDLC.

### The 6 Phases of STLC:
1. **Requirement Analysis** — Read the requirements. What can we test? What's ambiguous?
2. **Test Planning** — Write a plan: what to test, who tests, when, what tools.
3. **Test Case Development** — Write the actual test cases (steps, data, expected results).
4. **Test Environment Setup** — Get the test server, test data, and tools ready.
5. **Test Execution** — Run the tests. Log bugs.
6. **Test Closure** — Write a summary report. What passed? What failed? What's left?

## Agile & Scrum (What I Need to Know)
- **Sprint** = 1–4 week cycle. We build a small, working piece of software each sprint.
- **Daily Standup** = 15-min meeting: "What did I do yesterday? What will I do today? Am I blocked?"
- **Sprint Review** = Demo the work to stakeholders at the end of the sprint.
- **Retrospective** = Team discusses what went well and what to improve.
- **Why it matters for QA:** We test in EVERY sprint, not just at the end. We write test cases during the sprint, not after.

## Key Terms (My Definitions)
| Term | My Definition |
|---|---|
| Backlog | A list of all features/bugs to be worked on |
| User Story | A requirement written as "As a [user], I want [feature] so that [benefit]" |
| Acceptance Criteria | The specific conditions that must be met for a story to be "done" |
| Sprint Goal | The one thing the team is trying to achieve this sprint |
| Velocity | How many story points the team completes per sprint |