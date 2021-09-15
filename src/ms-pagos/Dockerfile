FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} ms-pagos.jar
ENTRYPOINT ["java","-jar","/ms-pagos.jar"]