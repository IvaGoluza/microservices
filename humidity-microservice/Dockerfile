FROM openjdk:17-jdk-slim-buster
WORKDIR /app
COPY build/libs/humidity-microservice-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8090
ENTRYPOINT ["java", "-jar", "app.jar"]