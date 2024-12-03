FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} api-rest-usuario.jar
ENTRYPOINT ["java","-jar","api-rest-usuario.jar"]