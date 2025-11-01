# 🧾 Experiment 3.1 – Java Servlet & JSP Web Applications

This repository contains **two web applications (Part A & Part B)** demonstrating the use of **Java Servlets**, **JSP**, and **MySQL** for building dynamic web-based systems.

---

## 📘 Overview

| Part | Title | Description |
|------|--------|-------------|
| **A** | Student Details Web App | A web app that takes student details through a form and displays them using Servlet. |
| **B** | Employee Records Web App | A web app that fetches and displays employee details from a MySQL database using JDBC and Servlet. |

Both parts are developed using **Eclipse IDE** and run on **Apache Tomcat Server (v10 or higher)**.

---

## 🧩 Technologies Used

| Category | Tools |
|-----------|-------|
| **Frontend** | HTML5, CSS |
| **Backend** | Java Servlets (Jakarta EE) |
| **Database** | MySQL (for Part B) |
| **Server** | Apache Tomcat v10.1 |
| **IDE** | Eclipse IDE for Enterprise Java Developers |
| **Version Control** | Git + GitHub |

---

## 🧠 Learning Objectives

- Understand the **Servlet lifecycle** (`init()`, `service()`, `destroy()`)
- Handle **HTTP requests and responses**
- Use **JDBC** for database connectivity
- Apply **MVC architecture** in web applications
- Deploy and test apps on **Apache Tomcat**

---

## 🅰️ Part A – Student Details Servlet

### 📄 Description
A simple web application that collects student details via an HTML form and displays them dynamically using a Servlet.

### 📁 Project Structure

### 🧪 How It Works
1. The user fills out the **studentForm.html** with details like Name, Roll Number, and Department.  
2. The form sends data to `StudentServlet` using the `POST` method.  
3. The servlet reads the request parameters and displays them dynamically in HTML format.

### 🌐 Run Steps
1. Open in Eclipse → **Run on Server**
2. Visit:  
# 🧾 Employee Records Web Application

A simple **Java EE (Jakarta EE)** web application built using **Servlets**, **JSP**, and **MySQL** to manage and view employee details.  
This project demonstrates CRUD-like operations, servlet handling, and JDBC connectivity using the **Model-View-Controller (MVC)** design approach.

---

## 🚀 Features

- View all employees stored in the database  
- Search employee details by ID  
- Display employee name, ID, and salary  
- Error handling for invalid or missing input  
- JDBC connection utility for database access  
- Deployed on **Apache Tomcat v10+**

---

## 🏗️ Project Structure

EmployeeRecordsApp/
│
├── src/main/java/
│ └── com/employee/
│ ├── EmployeeServlet.java # Main servlet to fetch and display employee data
│ └── util/
│ └── DBUtil.java # JDBC utility class for database connection
│
├── src/main/webapp/
│ ├── employeeSearch.html # Search page for employees
│ ├── WEB-INF/
│ │ ├── web.xml # Servlet mapping configuration
│ │ └── lib/ # MySQL connector JAR file
│ └── META-INF/
│
├── pom.xml / build files (if applicable)
└── README.md
