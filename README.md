# E-commerce Microservices

## Overview
This project is a **microservices-based e-commerce application** built using **Spring Boot**. It consists of three core services:

- **User Service**: Handles user registration, authentication, and profile management.
- **Product Service**: Manages product details, inventory, and catalog.
- **Order Service**: Processes orders, tracks order status, and manages payments.

## Technologies Used
- **Spring Boot** (REST APIs, MVC)
- **Spring Security** (for authentication and authorization)
- **JWT** (for secure authentication)
- **Spring Data JPA** (for database interactions)
- **MySQL** (as the relational database)
- **Eureka Service Registry** (for service discovery)
- **Docker** (for containerization)
- **Apache Kafka** (for event-driven communication)

## Microservices Architecture

1. **User Service**
   - Manages user authentication and roles.
   - Uses **BCrypt** for password hashing.

2. **Product Service**
   - Stores product details and inventory.
   - Exposes REST APIs for product listing and search.

3. **Order Service**
   - Manages orders, tracks payments, and order statuses.
   - Ensures transactional consistency with a distributed approach.

## Setup and Installation

### Prerequisites
- Java 17+
- Maven
- Docker (optional, for containerization)
- MySQL database
- Eureka Service Registry (for microservices discovery)

### Steps to Run
1. Clone the repository:
   ```sh
   git clone https://github.com/007-Tushar/ecommerce.git
   ```
2. Navigate to each service and build the application:
   ```sh
   cd UserService
   mvn clean install
   ```
   Repeat for `ProductService` and `OrderService`.
3. Run each service:
   ```sh
   mvn spring-boot:run
   ```
4. Access APIs via **Postman** or a browser.

## API Documentation
The project provides RESTful APIs. The full API documentation can be found in the `swagger-ui` when the services are running:
```
http://localhost:<PORT>/swagger-ui/index.html
```

## License
This project is licensed under the **Apache License 2.0**. See the LICENSE file for details.

```
Licensed under the Apache License, Version 2.0 (the "License");
You may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
Distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

