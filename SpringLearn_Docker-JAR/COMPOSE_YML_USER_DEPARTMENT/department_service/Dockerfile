#This is a sample image
FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} department-servicek.jar
ENTRYPOINT [ "java","-jar", "/department-servicek.jar" ]