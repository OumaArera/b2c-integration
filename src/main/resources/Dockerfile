FROM openjdk:21-jdk-slim

WORKDIR /app

COPY . /app

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "target/b2c-integration-0.0.1-SNAPSHOT.jar"]
