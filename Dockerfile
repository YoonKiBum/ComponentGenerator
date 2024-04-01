# Dockerfile for OpenJDK 17
FROM openjdk:17-jdk

# Set the working directory
WORKDIR /app

# (Optional) Copy your application JAR file to the container
COPY your-application.jar /app

# (Optional) Command to run your application
CMD ["java", "-jar", "your-application.jar"]
