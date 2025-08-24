# Quiz Management Microservices Project

This is a **microservices-based project** for managing quizzes and questions. The project is built using **Spring Boot** and demonstrates a complete microservices architecture with **service discovery**, an **API Gateway**, and inter-service communication.

---

## Project Overview

The project consists of the following services:

### 1. Question Microservice
- Manages quiz questions.
- Supports **CRUD operations** for questions.
- Provides an endpoint to **generate random questions** based on category and number of questions.
- Provides an endpoint to **calculate quiz scores** based on user responses.
- Handles all question-related business logic for quizzes.

### 2. Quiz Microservice
- Manages quizzes.
- Requests questions from the Question Microservice to create quizzes.
- Handles quiz creation, retrieval, and management.
- Integrates with Question Microservice using **Feign clients**.

### 3. API Gateway (Spring Cloud Gateway)
- Routes requests to the appropriate microservices.
- Enables centralized access to all microservices.
- Provides path-based routing and filters.

### 4. Service Registry (Eureka / Spring Cloud Discovery)
- Maintains a registry of all running microservices.
- Enables dynamic discovery of services, allowing the API Gateway and microservices to communicate without hardcoded URLs.

---

## Features
- **Microservice Architecture:** Separation of concerns with independent services.
- **Service Discovery:** Dynamic service registration and lookup using Eureka.
- **Load-balanced service calls:** Communication between services using Spring Cloud LoadBalancer and Feign.
- **Random Question Generation:** Create quizzes dynamically with random questions from the database.
- **Quiz Functionality:** Endpoints to fetch quiz questions and calculate scores dynamically.
- **RESTful APIs:** Standard CRUD and query endpoints.
- **API Gateway Routing:** Centralized routing and request management.

---

## Technology Stack
- Java 21
- Spring Boot
- Spring Cloud Gateway
- Spring Cloud Netflix Eureka (Service Registry)
- Spring Data JPA / Hibernate
- MySQL (Database)
- Feign Client for inter-service communication

---

## How to Run

1. Start the **Service Registry (Eureka Server)**.
2. Start the **Question Microservice**.
3. Start the **Quiz Microservice**.
4. Start the **API Gateway**.
5. Access APIs through the Gateway endpoints.

Example: http://localhost:8082/quiz/get/1
         http://localhost:8082/question/all


