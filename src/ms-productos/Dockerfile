FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} ms-productos.jar
ENTRYPOINT ["java","-jar","/ms-productos.jar"]