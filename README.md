# QA Automation Framework – Java + Selenium + Cucumber

End-to-end test automation framework built with **Java**, **Selenium WebDriver**, **Cucumber (BDD)** and **Maven**, following best practices used in real QA teams.

This project automates key user flows of the demo application **DemoBlaze**, focusing on maintainability, readability, and professional reporting.

---

## 🚀 Tech Stack

- **Java 17**
- **Selenium WebDriver**
- **Cucumber (BDD)**
- **JUnit**
- **Maven**
- **WebDriverManager**

---

## 🧱 Framework Architecture

The framework follows a clean and scalable structure, separating responsibilities clearly:

- **Pages** → Page Object Model (POM)
- **Steps** → Cucumber step definitions
- **Core** → Driver management, configuration, hooks
- **Utils** → Waits and reusable utilities
- **Resources** → Feature files and configuration

### 📁 Project Structure

<img width="588" height="994" alt="folder-structure" src="https://github.com/user-attachments/assets/ae807720-1af2-4423-bc52-510028ab9500" />

---

## 🧪 Automated Scenarios

### 🔐 Authentication
- Successful login (happy path)
- Negative login scenarios (invalid credentials)

### 🛒 Shopping Cart
- Add product to cart
- Validate alert messages
- Verify product presence in cart
- Validate cart total

---

## 🏷️ Tag Strategy

Tags are used to control execution and keep pipelines clean:

- `@smoke` → Critical happy path scenarios
- `@negative` → Validation and error handling scenarios
- `@auth` → Authentication features
- `@cart` → Shopping cart features

### Examples:
```gherkin
@auth @smoke
Scenario: Successful login

@cart @negative
Scenario: Add product without selection
```

---

## ▶️ How to Run Tests

Run all smoke tests
```gherkin
mvn test -Dcucumber.filter.tags=@smoke
```

Run only negative tests
```gherkin
mvn test -Dcucumber.filter.tags=@negative
```

Run all tests
```gherkin
mvn test
```

---

## 📊 Reporting & Evidence

- Automatic HTML report generated after execution
- Screenshots captured automatically on test failure
- Screenshots are embedded directly into the Cucumber report

### Example – Failed Scenario Evidence

<img width="1920" height="1453" alt="cucumber-report-failure" src="https://github.com/user-attachments/assets/e95fe8de-4161-4dca-92b6-c1bd0994faae" />

---

## 📌 Key Features

- Page Object Model (POM) implementation
- Explicit waits for stability
- Centralized configuration
- Reusable step definitions
- Automatic screenshots on failure
- Clean tag-based execution strategy
- CI/CD ready (Maven-based)

---

## 🧑‍💻 Author

Jonatan Huens - QA Automation Engineer
Focused on building reliable, maintainable, and scalable automation solutions.

---

## 📄 License

This project is for learning and portfolio purposes.

---
