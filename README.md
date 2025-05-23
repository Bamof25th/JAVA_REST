# Products Backend Services

A collection of Spring Boot microservices for various business applications.

## Project Structure

The repository contains the following microservices:

- **prodrestapis**: Products Management REST APIs
- **restorant_rest_apis**: Restaurant Management System APIs
- **tasks**: Task Management Service
- **users_vehicles**: User and Vehicle Management Service
- **Tasks-frontend**: Frontend application for the Tasks service

## Technology Stack

- Java with Spring Boot 3.x
- Maven for dependency management
- RESTful APIs
- Multiple independent microservices architecture

## Getting Started

### Prerequisites

- Java JDK 17 or higher
- Maven 3.6+
- Your favorite IDE (Spring Tool Suite, IntelliJ IDEA, or VS Code recommended)

### Building the Projects

Each microservice can be built independently using Maven:

```bash
cd <service-directory>
mvn clean install
```

### Running the Services

Navigate to each service directory and run:

```bash
mvn spring-boot:run
```

## Services Overview

### Products Management (prodrestapis)
- REST APIs for product management
- Handles product catalog and inventory

### Restaurant Management (restorant_rest_apis)
- Restaurant management system
- Handles menu, orders, and restaurant operations

### Task Management (tasks)
- Task tracking and management system
- Includes task creation, assignment, and status tracking

### Users and Vehicles (users_vehicles)
- User management system
- Vehicle tracking and management

### Tasks Frontend
- Web interface for the task management system
- Connects to the tasks backend service

## Contributing

1. Fork the repository
2. Create your feature branch
3. Commit your changes
4. Push to the branch
5. Create a new Pull Request

## License

This project is proprietary software. All rights reserved.

## Last Updated

2025-05-14
