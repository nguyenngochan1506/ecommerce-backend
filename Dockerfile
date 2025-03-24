FROM openjdk:17

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} ecommerce-backend.jar

ENTRYPOINT ["java", "-jar", "ecommerce-backend.jar"]

EXPOSE 8080