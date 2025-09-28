FROM maven:3.9.9-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline -B
COPY src ./src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jdk-jammy AS runtime
WORKDIR /app
COPY --from=build /app/target/config-server-0.0.1-SNAPSHOT.jar ./config-server.jar
COPY src/main/resources/config ./config
EXPOSE 8888
ENTRYPOINT ["java", "-jar", "config-server.jar"]