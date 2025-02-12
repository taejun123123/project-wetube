# Use an official Java runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the compiled Spring Boot jar file into the container
COPY target/*.jar app.jar

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
