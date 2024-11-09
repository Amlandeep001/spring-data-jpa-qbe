# Spring Data JPA Query By Example Demo

Transform your Spring Data JPA queries from complex boilerplate into elegant, type-safe search operations with [Query By Example](https://docs.spring.io/spring-data/jpa/reference/repositories/query-by-example.html). This project demonstrates how to implement dynamic, flexible queries without the overhead of writing multiple repository methods or complex JPQL statements.

## Overview

Query By Example (QBE) is a user-friendly querying technique that allows you to create dynamic queries using domain object instances as templates. This approach shines when building search functionality with multiple optional parameters, such as advanced search forms or dynamic filters.

## Project Requirements

- Java 21
- Spring Boot 3.3.5
- PostgreSQL
- Docker (for running the database)
- Maven

## Key Features

- Dynamic query generation using domain objects
- Type-safe query construction
- Minimal boilerplate code
- Integration with Spring Data JPA
- Docker-based development environment
- Comprehensive test coverage using TestContainers
