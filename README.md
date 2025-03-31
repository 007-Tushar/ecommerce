# Java Spring Boot Microservices Project

## Overview
This project is a microservices-based architecture built using Java and Spring Boot. It consists of multiple independent services that communicate using REST APIs and OpenFeign. The system leverages Spring Cloud for service discovery and management.

## Tech Stack
- **Java**: Backend programming language.
- **Spring Boot**: Framework for building microservices.
- **Spring Cloud**: Provides cloud-native tools for microservices.
- **Eureka Client & Eureka Server**: Service discovery and registration.
- **OpenFeign Client**: For easy inter-service communication.
- **Microservices Architecture**: Independent services interacting seamlessly.

## Microservices
This project consists of the following services:
1. **User Service**: Manages user-related operations.
2. **Product Service**: Handles product details and inventory.
3. **Order Service**: Processes customer orders and interactions.

## Features
- **Service Discovery**: Eureka handles service registration and discovery.
- **Inter-Service Communication**: OpenFeign simplifies API calls between services.
- **Scalability**: Independent services allow flexible scaling.
- **Resilience**: Spring Cloud tools help manage failures effectively.

## Setup Instructions
1. Clone the repository:
   ```sh
   git clone <repository-url>
   ```
2. Navigate to the project directory:
   ```sh
   cd <project-folder>
   ```
3. Build and run each service separately:
   ```sh
   mvn clean install
   mvn spring-boot:run
   ```
4. Ensure the Eureka Server is running before launching other services.

## Current Status
This project is **actively under development**, and new features are being added.

## Future Enhancements
- API Gateway for routing requests.
- Centralized Logging & Monitoring.
- Database integration with each service.

## Contributing
Contributions are welcome! Feel free to fork the repository and create pull requests for improvements.

## License
This project is licensed under the Apache 2.0 License.

