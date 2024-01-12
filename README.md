# Distributed System with Microservices
## Overview

This project implements a distributed system based on microservices and containers using Spring Boot and Docker. The system is designed for tracking temperature and humidity readings with additional services for aggregation, configuration, and registration.

## Used Technologies

- **Spring Boot:** Java-based framework for building microservices.
- **Docker:** Containerization platform for packaging, distributing, and running applications.
- **Spring Cloud Config:** Configuration server for managing configuration of temperature unit.
- **Spring Cloud Netflix Eureka:** Service registration and discovery for microservices.
- **H2 Database:** In-memory database for development and testing.
- **Postman:** API development and testing tool.

## How to Run
**IP Address Configuration**: Set up your own IP address in the project code.

### 1. Run Configuration and Registration Servers

```
   docker-compose -f docker-compose-infrastructure.yml up -d
```
 - Configuration Server: http://localhost:8888/application/default
 - Registration Server (Eureka): http://localhost:8761/

### 2. Run Microservices
   
```
docker-compose -f docker-compose-services.yml up -d
```
   Readings are stored in a database to simulate actual sensor readings: 
 - Temperature Microservice Database: http://localhost:8090/h2-console
 - Humidity Microservice Database: http://localhost:8091/h2-console <br/>

### 3. Testing with Postman:
   Send a GET request to the Aggregator Microservice:
   http://localhost:8092/api/aggregator

### 4. Change temperature unit configuration
   Update config file (Temperature units: K/C) on GitHub. Restart Aggregator Microservice container. <br/>
```
docker stop projekt3code-aggregator-service-1
docker start projekt3code-aggregator-service-1
```
### 5. Stopping the System
```
docker-compose -f docker-compose-services.yml down
docker-compose -f docker-compose-infrastructure.yml down
```
   

