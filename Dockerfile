FROM openjdk:17-alpine

RUN addgroup -S spring && adduser -S spring -G spring

USER spring:spring

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} demo-rsocket-1.0.jar

ENTRYPOINT ["java", "-jar", "demo-rsocket-1.0.jar"]