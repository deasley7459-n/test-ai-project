---
kind: build_system
name: Maven-based Java 17 Build with JUnit 5 Tests
category: build_system
scope:
    - '**'
source_files:
    - pom.xml
    - src/main/java/com/example/App.java
    - src/test/java/com/example/AppTest.java
---

## Build System Overview

This is a minimal Maven project using the standard Maven lifecycle. There are no custom Makefiles, shell scripts, Dockerfiles, or CI pipeline definitions — all build configuration lives in `pom.xml`.

## Key Files and Configuration

- **`pom.xml`** — The single source of truth for the build. Declares:
  - Group/artifact/version: `com.example:test-ai-project:1.0-SNAPSHOT`, packaged as a `jar`.
  - Java version: properties `maven.compiler.source` and `maven.compiler.target` set to `17`, mirrored by an explicit `maven-compiler-plugin` (v3.11.0) configuration block.
  - Source encoding: `UTF-8` via `project.build.sourceEncoding`.
  - Test framework: `org.junit.jupiter:junit-jupiter:5.10.0` with `scope=test`.
  - Test execution: `maven-surefire-plugin` v3.1.2 configured (no extra test arguments).
- **`src/main/java/com/example/App.java`** — Application entry point compiled into the jar.
- **`src/test/java/com/example/AppTest.java`** — Unit tests discovered and run by Surefire.
- **`target/`** — Default Maven output directory for compiled classes, test classes, and artifacts.
- **`.gitignore`** — Present but not inspected; typically ignores `target/` in Maven projects.

## Architecture and Conventions

- **Standard Maven layout**: `src/main/java` for production code and `src/test/java` for tests follow Maven's default directory conventions, so no `<sourceDirectory>` overrides are needed.
- **No packaging beyond plain jar**: The project produces a standalone `.jar` artifact (`<packaging>jar</packaging>`). No `maven-shade-plugin`, `maven-assembly-plugin`, or Spring Boot plugin is configured, so the jar is not executable out of the box without specifying the main class on the command line.
- **Dependency management is flat**: All dependencies are declared directly under `<dependencies>` with no `<dependencyManagement>` section or BOM, which is appropriate for a small single-module project.
- **Versioning strategy**: Uses Maven's conventional snapshot versioning (`1.0-SNAPSHOT`). No release profile or CI-driven version bump is present.

## Conventions and Constraints

- **Java 17 baseline**: Enforced both via properties and the compiler plugin configuration; builds will fail if invoked with a JDK older than 17.
- **Tests run via Surefire**: Adding files matching `*Test.java` under `src/test/java` is sufficient for discovery and execution through `mvn test`.
- **No cross-compilation or multi-platform profiles**: Only a single target platform (JDK 17) is configured.
- **No external CI/build server**: There are no GitHub Actions, GitLab CI, Jenkinsfile, or similar files in the repository; building is expected to be done locally with `mvn clean package` (or equivalent IDE invocation).
- **No containerization**: No `Dockerfile` or `docker-compose.yml` exists in the repository root.