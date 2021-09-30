FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} proxy-service.jar
ENTRYPOINT ["java","-jar","/proxy-service.jar"]