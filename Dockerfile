FROM gradle:8.5-alpine AS builder
WORKDIR /app
COPY . .
RUN gradle clean bootJar

FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app
COPY --from=builder /app/build/libs/*.jar /app/spring-app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/spring-app.jar"]