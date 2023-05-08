# PetManager
The project is a web application built with Spring Boot and Angular. The purpose of the application is to manage a list of pets and their details.

The project was built on the following versions of used software: \
Java 20 \
Angular CLI 16 \
Node.js v18.16.0 \
npm 9.5.1

## Project Structure
The project follows the standard Spring Boot and Angular project structures:

```
├── backend/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── com.example.petmanager/
│   │   │   │       ├── controller/
│   │   │   │       ├── model/
│   │   │   │       ├── repository/
│   │   │   │       ├── service/
│   │   │   │       └── PetManagerApplication.java
│   │   │   └── resources/
│   │   │       ├── sql
│   │   │       |   └── data.sql
│   │   │       └── application.properties
│   ├── pom.xml
│   └── Dockerfile
└── frontend/
    ├── src/
    │   ├── app/
    │   ├── assets/
    │   └── environments/
    ├── angular.json
    ├── package.json
    ├── tsconfig.json
    └── Dockerfile
```

The Backend folder contains the Spring Boot application, while the Frontend folder contains the Angular application. 

## Getting Started 
To run the application locally, follow these steps: 

Clone the repository: **git clone https://github.com/RobinPiir/PetManager.git** \
Navigate to the backend folder: **cd Backend** \
Build the Docker container: **docker build -t pet-manager-backend .** \
Run the Docker container: **docker run -p 8080:8080 pet-manager-backend** \
Navigate to the frontend folder: **cd ../frontend** \
Build the Docker container: **docker build -t pet-manager-frontend .** \
Run the Docker container: **docker run -p 4200:4200 pet-manager-frontend** \
The application can then be accessed at http://localhost:4200.

## API Documentation 
The application exposes a REST API with the following endpoints:

GET /api/getAll: Returns a list of all pets. \
GET /api/pet/{id}: Returns the details of a specific pet. \
POST /addPet: Creates a new pet. \
POST /updatePet/{id}: Edits an existing pet 

GET /api/getColors: returns a list of possible pet colors. \
GET /api/getTypes: returns a list of possible pet types. 
