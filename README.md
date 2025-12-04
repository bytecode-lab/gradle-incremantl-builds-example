# Gradle Incremental Builds Demo

This project demonstrates the power of **Gradle Incremental Builds** in a multi-module Android project. It illustrates how modifying a single module triggers recompilation only for that specific module (and its consumers), rather than rebuilding the entire project. This optimization is crucial for maintaining fast build times in large Android applications.

## Project Structure

The project is organized into a main application and multiple feature modules:

*   **app**: The main application entry point that aggregates all feature modules.
*   **features/module-a** to **features/module-k**: 11 independent Kotlin library modules. Each module exposes a simple `Greeting` object.

## Understanding Incremental Builds

Gradle uses input/output tracking to determine if a task needs to run.
*   **Full Build**: When you build for the first time, all tasks across all modules are executed.
*   **Incremental Build**: When you make a change, Gradle detects which files were modified.
    *   If you edit `:module-a`, Gradle recompiles `:module-a`.
    *   Since `:app` depends on `:module-a`, `:app` is also recompiled to ensure integration is correct.
    *   **Crucially**, other independent modules like `:module-b`, `:module-c`, etc., are **not** recompiled. Their tasks remain `UP-TO-DATE`.

## How to Test

Follow these steps to observe incremental builds in action:

1.  **Run a Clean Build**:
    Establish a baseline by building the entire project.
    ```bash
    ./gradlew clean :app:assembleDebug
    ```

2.  **Modify a Single Module**:
    Open `GreetingA.kt` in `features/module-a` and change the message:
    ```kotlin
    // features/module-a/src/main/kotlin/com/example/module/GreetingA.kt
    fun greeting() = "Hello from Module A - (modified)"
    ```

3.  **Run an Incremental Build**:
    Build the project again.
    ```bash
    ./gradlew :app:assembleDebug
    ```

4.  **Observe the Output**:
    Check the Build Output window or console.
    *   You will see tasks for `:module-a` being executed (e.g., `:module-a:compileDebugKotlin`).
    *   You will see tasks for `:app` being executed.
    *   **Verify**: Tasks for `:module-b` through `:module-k` should be marked as `UP-TO-DATE` or skipped, proving that they were not rebuilt.

