# Testing Guide for Health Diagnostic System

## Prerequisites

Before you begin testing, ensure you have the following installed:
- Java JDK 17 or higher
- Maven 3.6 or higher
- An IDE of your choice (IntelliJ IDEA, Eclipse, etc.)
- Postman or any other API testing tool (for manual API testing)

## Getting Started

To get started with testing, you need to first clone the repository and navigate to the project directory:

```
git https://github.com/soukainabenchekroun/health.git
cd health
```

## Running Automated Tests

This project uses JUnit and Mockito for unit testing and Spring Boot Test for integration testing.

### Running Tests Through Maven

If you are using Maven, you can run the tests through the following command:

```
mvn clean test
```

## Manual Testing

For manual testing, especially for the REST API endpoints, follow the steps below:

1. **Start the Application**
    - Run the application using your IDE or through the command line by the following Maven command:
      ```
      mvn spring-boot:run
      ```

2. **Use Postman for API Testing**
    - Open Postman and configure it to send requests to `http://localhost:8080/`.
    - Test the following endpoints:
        - **GET /diagnostic**
            - Parameter: `code` (int)
            - Expected response: JSON object describing the diagnostic result.
            - Examples:
              ```http
              GET /diagnostic?code=33
              GET /diagnostic?code=55
              GET /diagnostic?code=15
              ```