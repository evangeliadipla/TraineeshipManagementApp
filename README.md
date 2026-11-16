# Traineeship Management Application

## About
This is our project for the **MYY803 - Software Engineering** course. We are creating a web application for managing traineeship positions at the University.

The application allows companies to post open traineeship positions, students to search and apply for positions, and the traineeship committee to assign positions. Professors will be assigned to supervise traineeships and provide evaluations.

## Technologies Used
- **Java**
- **Spring Boot**
- **MySQL**
- **JUnit & Mockito** (for testing)

## Key Features
- Companies can post open traineeship positions.
- Students can search and apply for available positions.
- Committee can assign positions based on various criteria.
- Professors supervise traineeships and provide evaluations.

## Getting Started
1. Clone the repository:
   ```bash
   git clone https://github.com/evangeliadipla/TraineeshipManagementApp.git
 
   ```


## Local Configuration

The application uses a local MySQL database named `traineeship_management` and runs on port `9090` by default. The database username defaults to `root` (see `src/main/resources/application.properties`).

Set the `DB_PASSWORD` environment variable to your local MySQL password before starting the application. Do not commit real passwords or other credentials to this repository.

For example, in a terminal with Maven and a compatible JDK installed:

```bash
export DB_PASSWORD="your-local-mysql-password"
mvn spring-boot:run
```

On Windows PowerShell, set the environment variable with `$env:DB_PASSWORD = "your-local-mysql-password"`.