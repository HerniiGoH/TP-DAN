FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} ms-usuarios.jar
ENTRYPOINT ["java","-jar","/ms-usuarios.jar"]