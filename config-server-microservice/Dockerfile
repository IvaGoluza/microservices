FROM openjdk:17-jdk-slim-buster
WORKDIR /app
COPY build/libs/config-server-microservice-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8888
ENTRYPOINT ["java", "-jar", "app.jar"]