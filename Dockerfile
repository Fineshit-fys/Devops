FROM eclipse-temurin:25
COPY target/semApp-0.1.0.2.jar /tmp/semApp-0.1.0.2.jar
ENTRYPOINT ["java", "-jar", "/tmp/semApp-0.1.0.2.jar", "mongo-dbserver:27017"]
WORKDIR /tmp