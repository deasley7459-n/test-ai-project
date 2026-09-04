---
kind: external_dependency
name: Maven build & test runner
slug: maven
category: external_dependency
category_hints:
    - framework_behavior
scope:
    - '**'
source_files:
    - pom.xml
---

### Maven build & test runner
- Project is a standard Maven project (`pom.xml`, `src/main/java`, `src/test/java`, `target/`).
- A surefire `.dumpstream` file in `target/` indicates a test crash rather than a compile failure — when diagnosing "Java program won't run" failures, inspect surefire reports and dumpstreams under `target/surefire-reports` or `target/` before assuming code issues.