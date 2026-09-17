<br />
<div >
<h3 >PERSON API</h3>
  <p >
   A Spring Boot REST API for storing and querying people.
  </p>
</div>

### Built With

* ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white) 26
* ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge&logo=spring&logoColor=white) 4.1.0
* ![Gradle](https://img.shields.io/badge/Gradle-02303A.svg?style=for-the-badge&logo=Gradle&logoColor=white)
* ![PostgreSQL](https://img.shields.io/badge/PostgreSQL-4169E1?style=for-the-badge&logo=postgresql&logoColor=white)

### Dependencies

* Spring Boot Starter Web `4.1.0`
* Spring Boot Starter Data JPA `4.1.0`
* Spring Boot Starter Validation `4.1.0`
* Spring Boot DevTools `4.1.0` (development only)
* Spring Boot Starter Test `4.1.0` (test)
* PostgreSQL JDBC Driver `42.7.13` (runtime)
* H2 Database `2.4.240` (test)
* MapStruct `1.6.3`
* Lombok `1.18.48`
* Lombok-MapStruct Binding `0.2.0`
* springdoc-openapi-starter-webmvc-ui `3.1.1`
* Spring Dependency Management Plugin `1.1.7`
* Jacoco (test coverage)


<!-- GETTING STARTED -->
## Getting Started

To get a local copy up and running follow these steps.

### Prerequisites

* JDK 26 [https://jdk.java.net/26/](https://jdk.java.net/26/)
* Gradle [https://gradle.org/install/](https://gradle.org/install/)
* PostgreSQL [https://www.postgresql.org/download/](https://www.postgresql.org/download/)

### Recommended Tools
* IntelliJ Community [https://www.jetbrains.com/idea/download/](https://www.jetbrains.com/idea/download/)
* Postman [https://www.postman.com/downloads/](https://www.postman.com/downloads/)

### Installation

1. Clone the repo
2. Change directory
   ```sh
  cd person-api
   ```
3. Create a new database in PostgreSQL called `person`
4. Update the database connection settings (defaults shown below can be overridden with environment variables)
   ```yml
   # src/main/resources/application.yml
   spring:
     datasource:
       url: jdbc:postgresql://${DB_HOST:localhost}:${DB_PORT:5432}/${DB_NAME:person}
       username: ${DB_USERNAME:postgres}
       password: ${DB_PASSWORD:postgres}
   ```

<!-- USAGE -->
## Usage

1. Right-click the class PersonApiApplication and choose Run
2. Open [http://localhost:8081/swagger-ui/index.html](http://localhost:8081/swagger-ui/index.html) in your web browser

### Endpoints

- `POST /api/v1/person` stores a person with `identificationNumber`, `name`, and `email`.
- `GET /api/v1/person` returns all stored people.

<!-- ROADMAP -->
## Tests

- Right-click the test folder and choose Run tests with coverage


