# Use the official OpenJDK image from the Docker Hub
FROM openjdk:11-jdk-slim

# Add Maintainer Info
LABEL maintainer="johnouma999@gmail.com"

# Add a volume pointing to /tmp
VOLUME /tmp

# The application's jar file
ARG JAR_FILE=target/b2c-integration-1.0.0.jar

# Add the application's jar to the container
COPY ${JAR_FILE} app.jar

# Run the jar file
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
