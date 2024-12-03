FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} api-rest-articulos.jar
ENTRYPOINT ["java","-jar","api-rest-articulos.jar"]