# OrangeHRM Enterprise Automation Framework

A professional-grade test automation framework designed for the OrangeHRM Open Source platform. This framework implements the Page Object Model (POM) design pattern using Java, Selenium WebDriver, and TestNG, providing a scalable and maintainable solution for regression and end-to-end testing.

## Overview

This project provides a robust automation suite covering critical modules of the OrangeHRM application, including Admin, PIM, Leave, Time, Recruitment, My Info, Performance, Directory, Claim, and Buzz. It is built with a focus on reliability, clear reporting, and cross-browser compatibility.

## Core Features

- **Page Object Model (POM):** Enhances code reusability and minimizes maintenance efforts by separating UI elements from test logic.
- **Advanced Reporting:** Integrated with ExtentReports 5 (Spark) for detailed, interactive HTML reports including system environment details and execution logs.
- **Automated Evidence Collection:** Captures high-resolution screenshots automatically upon test failure, embedded directly into the Extent Report.
- **Data-Driven Testing:** Utilizes Apache POI for externalizing test data into Excel spreadsheets, enabling exhaustive testing with multiple datasets.
- **Cross-Browser Compatibility:** Support for Chrome, Firefox, and Microsoft Edge with configurable execution via TestNG parameters.
- **Headless Execution:** Fully supported for CI/CD environments (Jenkins/GitHub Actions) via Chrome, Firefox, and Edge headless modes.
- **Thread-Safe Execution:** Implements ThreadLocal for ExtentTest instances to ensure reporting integrity during parallel execution.
- **Wait Strategies:** Combines Implicit and Explicit (WebDriverWait) strategies to handle asynchronous web elements effectively.

## Technology Stack

- **Language:** Java 11 (LTS)
- **Automation:** Selenium WebDriver 4.25.0
- **Test Management:** TestNG 7.9.0
- **Reporting:** ExtentReports 5.1.1 (Spark Reporter)
- **Build Tool:** Apache Maven
- **Driver Management:** WebDriverManager 5.7.0
- **Data Handling:** Apache POI 5.2.5
- **Logging:** SLF4J and Log4j 2

## Project Architecture

```text
src/test/java/
├── base/
│   ├── BaseClass.java          # WebDriver initialization and lifecycle management
│   ├── ExcelUtils.java         # Utilities for Excel data-driven testing
│   ├── ExtentManager.java      # Configuration for ExtentReports 5
│   └── Listeners.java          # TestNG Listeners for reporting and screenshots
├── pages/                      # Page Object Classes (UI Locators & Actions)
│   ├── AdminPage.java
│   ├── LoginPage.java
│   ├── PIMPage.java
│   └── ... (Module-specific pages)
└── tests/                      # Test Implementation Classes
    ├── LoginTest.java
    ├── AdminTest.java
    ├── EndToEndTest.java
    └── ... (Module-specific tests)
```

## Prerequisites

- **Java Development Kit (JDK):** version 11 or higher.
- **Apache Maven:** version 3.6.0 or higher.
- **Browsers:** Latest versions of Chrome, Firefox, or Microsoft Edge.
- **IDE:** IntelliJ IDEA, Eclipse, or VS Code (with Java extensions).

## Installation and Setup

1. Clone the repository:
   ```bash
   git clone <repository-url>
   ```
2. Navigate to the project root:
   ```bash
   cd selenium_and_testNG
   ```
3. Install Maven dependencies:
   ```bash
   mvn clean install
   ```

## Configuration

### Browser Selection
Browser selection is controlled via the `testng.xml` file. Update the `browser` parameter:
```xml
<parameter name="browser" value="chrome"/> <!-- Options: chrome, firefox, edge -->
```

### Headless Mode
To run tests without a visible browser window (ideal for servers), set the `headless` parameter to `true`:
```xml
<parameter name="headless" value="true"/>
```

## Running Tests

### Via Maven
Execute the entire suite defined in `testng.xml`:
```bash
mvn test
```

### Via Batch File
For quick execution on Windows environments, use the provided batch file:
```bash
run_tests.bat
```

### Via TestNG (IDE)
Right-click on `testng.xml` and select **Run '...\testng.xml'**.

## Reporting and Artifacts

### Extent Reports
Professional HTML reports are generated after every execution in the `reports/` directory.
- **Path:** `reports/AutomationReport_yyyyMMdd_HHmmss.html`
- **Features:** Dashboard view, category filters, exception logs, and failure screenshots.

### Screenshots
Screenshots of failed test cases are stored in the `screenshots/` directory with a timestamp for traceability.
- **Format:** `testMethodName_timestamp.png`

### Test Data
External test data is managed in `src/test/resources/TestData.xlsx`.

## Test Coverage

The suite covers the following modules of OrangeHRM:

| Module | Test Coverage Highlights |
| :--- | :--- |
| **Login** | Credential validation, logout, and session management. |
| **Admin** | User search, role management, and system configuration. |
| **PIM** | Employee lifecycle: addition, search, and profile updates. |
| **Leave** | Leave entitlement, request submission, and tracking. |
| **Time** | Timesheet management and project activity tracking. |
| **Recruitment** | Candidate management and vacancy tracking. |
| **My Info** | Personal detail updates and document management. |
| **Performance** | Key Performance Indicators (KPIs) and reviews. |
| **Directory** | Corporate directory search and contact viewing. |
| **Claim** | Expense claim submission and status monitoring. |
| **Buzz** | Social feed interactions and status updates. |
| **End-to-End** | Multi-module workflows simulating real-user journeys. |

## Manual Testing Documentation

In addition to automation, the project includes structured manual testing artifacts (referenced in `Project plan.txt`):
- Test Plan and Strategy
- Test Scenarios and Cases
- Requirements Traceability Matrix (RTM)
- Defect Reports and Test Summary
