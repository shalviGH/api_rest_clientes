FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/gestion-clientes-rest-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} gestion-clientes-rest.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "gestion-clientes-rest.jar"]