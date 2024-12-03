FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} api-config-server.jar
ENTRYPOINT ["java","-jar","api-config-server.jar"]