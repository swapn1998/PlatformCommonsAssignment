# Rest API for Student Management System
- Developed Rest API for Student Management System Application.This API perform all the fundamental
CRUD operations of any Student Management System with user validation at every step.

## Tech Stack
- Java
- Spring Framework
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL

## Modules
- Login, Logout Module
- Admin Module
- Student Module
- Course Module

## Admin Features
- Admin can add students, Course to main Database
- Admin can assign course to student
- Admin can get student by StudentName or by CourseName

## Student Features
- update profile details such as (email, mobile number , parents name,address)
- Can search for topics/courses he assigned
- Can leave a course

## Installation & Run
- Before running the API server, you should update the database config inside the application.properties file.
- Update the port number, username and password as per your local database config.
    server.port=8886

 Spring.datasource.url=jdbc:mysql://localhost:3306/student spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver spring.datasource.username=root spring.datasource.password=root

API Root Endpoint
https://localhost:8886/

http://localhost:8886/swagger-ui/

# ER DIAGRAM OF Student Management System

![ER Diagram of Plant Nursery Project]()
