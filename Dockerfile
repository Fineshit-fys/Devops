FROM eclipse-temurin:latest
COPY ./target/semApp-0.1.0.2.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "semApp-0.1.0.2.jar"]