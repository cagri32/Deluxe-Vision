# Deluxe-Vision E-commerce Website

## Introduction

### Purpose
This project aims to design and create an e-commerce website specializing in the purchase of glasses. The website addresses various user needs, including browsing and purchasing glasses, filtering items by categories, checking out items, registering an account for purchases, and running reports on sales and application usage for administrators.

### Overview
The website solves the following problems:
- Browsing and purchasing glasses
- Filtering items by different categories
- Checking out items
- Registering an account for purchases
- Running reports on sales and application usage as an admin
- Trying on glasses without making a purchase

### References
- [Zeelool](https://www.zeelool.com/)

## Design Patterns, Plan, Test Coverage, Description of Server Side

### a) Design Patterns - MVC and DAO Pattern
Continuing from Section 1.2, the project uses the MVC (Model-View-Controller) and DAO (Data Access Object) patterns. The DAO pattern provides an abstraction layer for separating database access code from the application's business logic. This separation improves flexibility, scalability, and maintainability, and simplifies testing. Angular services connect the backend to the front end for data retrieval.

### b) Activities Plan
The activities in this phase include creating various pages such as Homepage, Page Navigation, Glasses Details, Checkout, Login, setting up the backend and database, testing calls and implementations, and generating reports. The implementation leverages AWS for cloud deployment.

### c) Test Coverage for Server Side
Server-side test coverage ensures correct data collection. Tests include checking responses for non-existent data, sending errors for improper JSON data, and receiving correct responses for valid data. Additional tests will be added as more entities and APIs are developed.

### d) REST Principles
The project follows REST principles for designing web services, ensuring security, a consistent URI structure, caching for performance improvement, and statelessness for complete request information.

## Demo

### Quality Attributes
- **Security:** Leverages built-in security features of Angular and Spring Boot, implementing authentication and authorization mechanisms.
- **Performance:** Optimizes performance using Angular's ahead-of-time (AOT) compilation and lazy loading, coupled with Spring Boot's efficiency.
- **Scalability:** Easily scalable by deploying in clustered environments, load balancing, and following microservices architecture principles.

## Main Pages

All main pages of the website are:
1. Landing Page
2. Shopping Page
3. Glasses Details Page
4. Checkout Page
5. Login Page

### Technologies Used (Client Side)
The client-side implementation involves Angular, TypeScript, Angular Material, FontAwesome, and LocalStorage for a responsive, efficient, and visually appealing web application.

### Strengths
- Developed a user-friendly interface with Angular and Angular Material
- Efficient component development and reuse
- Improved application speed and responsiveness using LocalStorage
- Secure data transfer between client and server with a REST API

### Weaknesses
- System lacks order tracking and history features
- Could enhance user experience with additional search and filter functionalities
- Limitations in LocalStorage for scaling

### Technologies Used:

1. Angular
2. Java
3. MYSQL
4. AWS ( Frontend, Backend & Database Deployment)

### Dependencies:

1. JDK 20
2. Git 
3. Eclipse, IntelliJ
4. Apache Tomcat (version 8)
5. MYSQLSH Command Line Interface (CLI)

### Steps to get the application running:

Run the database:
Open MYSQLH CLI
Run "\connect root@localhost" command
Enter the password

### Run the backend:

Open the project in an IDE (IntelliJ, Eclipse, etc)
Run 'mvn clean install' command in the project directory.
Right-click on "/backend/src/main/java/com/backend/deluxevision/DeluxevisionApplication.java" and choose Run As > Java Application

### Run the frontend:

Open the project in VS Code
1. Right-click 'frontend/src' and Select 'Open In Integrated Terminal'
2. In terminal run 'ng serve'
3. Open localhost 


