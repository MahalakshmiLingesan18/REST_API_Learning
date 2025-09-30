# 🌐 REST API Learning – Postman, Newman & REST Assured

This repository is dedicated to learning, practising, and automating **REST API testing** using:
- **Postman** → for manual API exploration and collections
- **Newman (CLI)** → for running Postman collections in the command line & CI
- **REST Assured (Java)** → for automated API testing
- **Jenkins** → for CI/CD integration of API tests

---

## 📌 Objectives
- Understand the fundamentals of **REST APIs**.
- Learn manual API testing with **Postman**.
- Execute Postman collections via **Newman CLI**.
- Automate REST API tests using **REST Assured** (Java + TestNG/JUnit).
- Run API tests via **command line** for CI pipelines.
- Integrate API tests with **Jenkins** for continuous testing.

---

## 🚀 Getting Started

### Prerequisites
- [Java 11+](https://adoptopenjdk.net/) installed  
- [Maven](https://maven.apache.org/) installed  
- [Postman](https://www.postman.com/downloads/) installed  
- [Newman](https://www.npmjs.com/package/newman) (Node.js required)  
- [Jenkins](https://www.jenkins.io/download/) installed (or Docker container)  
- IDE: IntelliJ / Eclipse  

---

## 🧪 Learning Roadmap

### 1. REST Basics
- HTTP Methods (GET, POST, PUT, DELETE, PATCH)  
- HTTP Status Codes (2xx, 3xx, 4xx, 5xx)  
- Headers, Query Params, Request/Response Bodies  

### 2. Manual Testing with Postman
- Create collections & environments  
- Use variables & scripts (Pre-request & Test scripts)  
- Assertions using JavaScript  
- Export collections for CLI/CI use  

### 3. Postman CLI with Newman
- Install Newman globally:
  ```bash
  npm install -g newman

- Run a Postman Collection with Newman
  You can use **Newman** (Postman’s CLI tool) to run collections directly from the command line.
  ```bash
  newman run sample-collection.json -e dev-env.json

- Generate HTML Report with Newman
  You can generate detailed reports while running your Postman collection using the `-r` (reporter) flag.  
  ```bash
  newman run sample-collection.json -reporters cli,htmlextra

### 4. 🤖 Automated Testing with REST Assured

- Add **REST Assured** & **TestNG/JUnit** dependencies via Maven  
- Write test cases to validate:
  - Response codes  
  - Headers  
  - Payloads (JSON/XML)  
- Parameterize tests & implement **data-driven testing**  
- Integrate reporting with **ExtentReports** or **Allure**  

---

### 5. 🔄 Jenkins Integration

You can integrate API testing into your CI/CD pipeline using **Jenkins**.

### ⚙️ Configure Jenkins Job
- Create a **Freestyle Job** or **Pipeline Job**.
- Add build steps to run:
  - **Newman collections (via CLI)**  
    ```bash
    newman run sample-collection.json -e dev-env.json

### 📊 Publish Test Reports
- Configure Jenkins to publish:
  - **HTML Reports** (Newman / Extent Reports)  
  - **Allure Reports** (for REST Assured + TestNG/JUnit)  

### 🔔 Add Build Triggers
- Trigger builds on **Git push (SCM Polling / Webhooks)**  
- Or schedule periodic builds using **CRON expressions**  

---

## 📖 Resources

Here are some useful resources to get started and deepen your knowledge:

- [Postman Learning Centre](https://learning.postman.com/)  
- [Newman Documentation](https://github.com/postmanlabs/newman)  
- [REST Assured Docs](https://rest-assured.io/)  
- [Jenkins Documentation](https://www.jenkins.io/doc/)  
- [HTTP Status Codes](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status)

---

## 🤝 Contributing

Contributions are welcome! 🎉  

If you'd like to improve this project:  
- Add **Postman collections**  
- Share **REST Assured examples**  
- Enhance **Jenkins pipeline configurations**  
- Improve **documentation or learning resources**  

### 🔧 How to Contribute
1. Fork the repository  
2. Create a new branch (`feature/your-feature-name`)  
3. Commit your changes (`git commit -m "Add new feature"`)  
4. Push to your branch (`git push origin feature/your-feature-name`)  
5. Create a **Pull Request**

---

*Happy testing!* 🚀


