# Transaction Simplified - A Robust Backend Solution with Spring Boot & Kafka

## Description

This project presents a simplified yet fully functional backend system inspired by core Transaction features, focusing on user management and money transfers. Designed to address the Transaction Backend Challenge, it incorporates best practices in code organization, error handling, and integration with external services.

## Goals

- **User Management:**  
  Handles registration and ensures data integrity for both common users and merchants, enforcing unique NIF and email.

- **Transactions:**  
  Implements secure, atomic transactions between users and merchants, including balance verification to maintain financial accuracy.

- **External Services Integration:**  
  Seamlessly interacts with mock authorization and notification services, with built-in resilience for handling potential service downtimes.

- **RESTful API:**  
  Exposes a well-defined RESTful API for seamless client interaction, ensuring intuitive and efficient use.

- **Error Handling & Rollback:**  
  Guarantees data consistency with comprehensive error management and transaction rollback mechanisms.

- **Clean Code & Architecture:**  
  Focuses on maintainable, readable code adhering to SOLID principles and best practices in software design.

## Technologies

- **Framework:** Spring Boot  
  Leverages rapid development capabilities, built-in features, and a vast ecosystem for efficient backend development.

- **Language:** Java 17  
  Utilizes modern Java features for cleaner, more expressive code.

- **Database:** H2 (in-memory database)  
  Simplifies setup and testing during development, making it easy to manage and reset the state between tests.

- **Data Structures:** Records  
  Enhances code clarity and conciseness when representing immutable data.

- **Messaging:** Kafka (running in Docker)  
  Facilitates asynchronous communication and decoupling for scalability and fault tolerance, particularly for notifications. Docker is used to simplify the setup and management of the Kafka environment.

- **Containerization:** Docker  
  Containerizes the entire application, including the Kafka instance, ensuring consistent environments and easy deployment.

- **Web Server:** Apache Tomcat (Embedded in Spring Boot)  
  Handles HTTP requests, providing a robust platform for serving the application.

- **Testing:** JUnit & Mockito  
  Implements automated testing to ensure code correctness and maintainability throughout the development lifecycle.

## Getting Started

### Prerequisites

- **Java 17**  
  Ensure that you have Java 17 installed on your machine.

- **Docker**  
  Required to run Kafka and other services in containers.

### Running the Project

1. **Clone the Repository**  
   ```bash
   git clone https://github.com/Leupesquisa/transaction-simplified.git
   cd Transaction-simplified-backend
