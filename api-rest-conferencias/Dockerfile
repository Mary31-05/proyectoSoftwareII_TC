FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} api-rest-conferencias.jar
ENTRYPOINT ["java","-jar","api-rest-conferencias.jar"]