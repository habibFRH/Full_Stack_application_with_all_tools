# Software Engineering Learning Repository

This repository is a collection of projects and examples that I am using to learn and practice various software engineering concepts and technologies. The focus is on using Spring Boot and related tools to build robust and maintainable applications.

## Table of Contents

- [Technologies](#technologies)
- [Setup Instructions](#setup-instructions)
- [Usage](#usage)
- [Running Tests](#running-tests)
- [Docker Setup](#docker-setup)
- [Database Migrations](#database-migrations)
- [Contributing](#contributing)
- [License](#license)

## Technologies

This repository includes projects and examples using the following technologies:

- **Spring Boot**: For building robust Java applications.
- **Spring MVC**: For designing web applications with Model-View-Controller architecture.
- **Spring Data JPA**: Simplifies database access using JPA.
- **Spring JDBC Template**: For JDBC-based database interactions.
- **Flyway**: For database version control and migrations.
- **JUnit**: For writing and running unit tests.
- **Docker**: For containerizing applications.
- **PostgreSQL**: As the database management system.

## Setup Instructions

1. **Clone the repository**:
   ```sh 
   git clone https://github.com/habibFRH/Software_Engineering_learning.git
   cd Software_Engineering_learning
   
2.Install dependencies:
Ensure you have the following dependencies installed on your system:

Java: Make sure to have Java 17 or newer installed.
Maven: For project build and dependency management.
Docker: For containerization.
PostgreSQL: As the database for storing project data.

3.Configure the database:
Set up your PostgreSQL database by creating a new database instance. After that, update the application properties in application.yml with your PostgreSQL database credentials (username, password, database name, and URL).

4.Run the application:
1. **Clone the repository**:
   ```sh
   ./mvnw spring-boot:run
   
## Usage
Once the application is up and running, you can access the different endpoints for each project and experiment with the functionality provided by Spring Boot, database interactions, and other technologies used. These endpoints are designed to demonstrate various aspects of web development using Spring Boot, security, and database interactions.

## Running Tests
Run unit tests using Maven: ./mvnw test


## Docker Setup
1.If you want to containerize the application and run it using Docker, you can follow these steps:
Build and run the Docker container: docker-compose up --build

2.This will create the containers as per the configuration in docker-compose.yml and run the application within the Docker environment.

## Database Migrations
Flyway will automatically handle database migrations when the application starts. Make sure your PostgreSQL connection is set up correctly in application.yml. Flyway will apply any pending database changes to ensure your schema is up-to-date.

## Contributing
Feel free to contribute to this repository by creating issues, submitting pull requests, or suggesting improvements. Whether it's fixing bugs, enhancing documentation, or adding new features, your contributions are always welcome!
