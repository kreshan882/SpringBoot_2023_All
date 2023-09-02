#This is a sample image, versiopn passed from yml file
ARG JDK_VERSION
FROM openjdk:${JDK_VERSION}
#FROM openjdk:17

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} user-servicek.jar
ENTRYPOINT [ "java","-jar", "/user-servicek.jar" ]