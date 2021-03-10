# Testing SpringBoot with Java 11 in Visual Studio Code

Using Spring Boot Tutorial from Amigoscode

## Major Commits
1. Initial Commit
2. End of "Simple API with Spring Boot", aka Hello World
3. End of "Student Class" -> Would have been a lot easier with Eclipse or IntelliJ to quickly create Getters/Setters. 
    Only now I remember to check for extensions.
4. End of API Layer
5. End of Business Layer
6. End of Properties File
7. End of Creating and Connecting to Database
8. End of JPA and @Entity
    * End of JPA in Action (Not much happens)
9. End of JPA Repository
10. End of Saving Students
11. End of @Transient
12. End of Post Mapping
13. End of Writing Business Logic and Testing Post Request
14. Deleting Students
15. End of Exercise

## To run in current state
Requires:
* PostgresSQL database named student on localhost:5432
* application.properties file in java source resource folder
* example:
```
spring.datasource.url=jdbc:postgresql://localhost:5432/student 
spring.datasource.username=your-postgres-app-username 
spring.datasource.password=your-postgress-app-password 
spring.jpa.hibernate.ddl-auto=create-drop 
spring.jpa.show-sql=true 
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect 
spring.jpa.properties.hibernate.format_sql=true 
server.error.include-message=always 
```

## Postman Collection
Created in order to do POST/PUT/DELETE requests.
* I'm doing this tutorial in Visual Studio Code, so I don't want to look up every single VSC equivalent for IntelliJ Ultimate features.