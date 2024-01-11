FROM openjdk:17-jdk-slim-buster
WORKDIR /app
COPY build/libs/temperature-microservice-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8091
ENTRYPOINT ["java", "-jar", "app.jar"]