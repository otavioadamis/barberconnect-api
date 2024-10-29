FROM maven:3.9.8-eclipse-temurin-21 AS build

WORKDIR /app
COPY pom.xml .
COPY src ./src

RUN mvn clean install -DskipTests

FROM openjdk:21

COPY --from=build /app/target/barberconnect-project.jar /app/barberconnect-project.jar

WORKDIR /app

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "barberconnect-project.jar"]