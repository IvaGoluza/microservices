FROM openjdk:17-jdk-slim-buster
WORKDIR /app
COPY build/libs/aggregator-microservice-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8092
ENTRYPOINT ["java", "-jar", "app.jar"]