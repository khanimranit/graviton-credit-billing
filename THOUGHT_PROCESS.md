# Thought Process

- Used CSV for simplicity and readability
- Kept models immutable where possible
- Used HashMap for O(1) lookups
- Introduced Transaction model for auditability
- Avoided over-engineering (no DB, no frameworks)
- CLI-based design keeps focus on core logic