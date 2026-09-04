---
kind: dependency_management
name: Maven POM-based Dependency Management for a Minimal Java Project
category: dependency_management
scope:
    - '**'
source_files:
    - pom.xml
---

## What system/approach is used

This repository uses **Apache Maven** as its build and dependency management tool, declared via the standard `pom.xml` at the project root. It follows the conventional Maven layout (`src/main/java`, `src/test/java`) and declares dependencies declaratively in the `<dependencies>` section of the POM. No vendoring (e.g., no `lib/` directory), no lockfile (no `maven-dependency-tree` snapshot), and no private registry configuration are present — all artifacts resolve from Maven Central by default.

## Key files and packages

- **`pom.xml`** — The single source of truth for project coordinates (`groupId: com.example`, `artifactId: test-ai-project`, `version: 1.0-SNAPSHOT`), Java version properties, runtime/test dependencies, and build plugins.
- Declared runtime/test dependency:
  - `org.junit.jupiter:junit-jupiter:5.10.0` with `<scope>test</scope>`.
- Build plugins pinned to explicit versions:
  - `maven-compiler-plugin 3.11.0` (source/target 17).
  - `maven-surefire-plugin 3.1.2` (JUnit 5 test execution).

## Architecture and conventions

- **Single-module project**: There is no parent POM and no multi-module structure; all dependency declarations live in one POM.
- **Java version pinning**: Java 17 is enforced through both `<properties>` (`maven.compiler.source` / `maven.compiler.target`) and the compiler plugin `<configuration>` block, ensuring consistent compilation across environments.
- **Dependency scoping**: Test-only libraries use `<scope>test</scope>` so they do not leak into the compiled artifact.
- **Plugin version pinning**: Both build plugins are pinned to exact versions rather than relying on Maven's default or BOM-driven versions, which improves reproducibility.
- **No dependency management layer**: There is no `<dependencyManagement>` section, no BOM import, and no parent POM inheriting managed versions — every dependency and plugin version is declared inline.
- **No custom repositories or mirrors**: The POM contains no `<repositories>` or `<pluginRepositories>` elements, so resolution falls back to Maven Central.
- **No dependency analysis or update tooling**: There are no `versions-maven-plugin`, `depgraph`, or CI steps visible in this minimal starter project to track or enforce updates.

## Conventions and constraints

Observed conventions (descriptive):
- Third-party libraries are added directly under `<dependencies>` with explicit `groupId`, `artifactId`, and `version`.
- Testing frameworks are scoped to `test` so they are excluded from the packaged JAR.
- Build toolchain versions (compiler, surefire) are pinned explicitly in the POM.

Constraints enforced by the project setup:
- The project compiles against and targets Java 17, enforced by both properties and the compiler plugin configuration.
- Only JUnit Jupiter 5.x is permitted as a testing framework in this module (other test libraries would require an additional `<dependency>` entry).

Because this is a minimal starter project, there is no advanced dependency-management strategy such as a parent POM, BOM, dependency convergence checks, or automated update policies.