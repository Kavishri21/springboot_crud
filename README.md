# Spring Boot CRUD API 💻

A simple RESTful API to perform CRUD operations on a user database using:

- 🔧 Spring Boot
- 💽 MySQL
- 📬 Postman
- 📘 Swagger

## 📌 Features

- `GET /api/users` → Get all users
- `POST /api/users` → Create a new user
- `GET /api/users/{id}` → Get user by ID
- `PUT /api/users/{id}` → Update user by ID
- `DELETE /api/users/{id}` → Delete user by ID

## 🛠️ Tools & Tech
- Java 17
- Spring Boot
- Spring Data JPA
- MySQL
- Postman
- Swagger for API docs

## ▶️ Running the Project

1. Clone the repo
2. Create a MySQL DB and configure `application.properties`
3. Run `DemoApplication.java`

```bash
mvn spring-boot:run

Open http://localhost:8080/swagger-ui/index.html for API testing