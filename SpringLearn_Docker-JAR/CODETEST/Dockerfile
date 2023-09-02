#Base image is alpine(build with tree using This file)
FROM alpine:latest
LABEL maintainer="kreshanR"
RUN apk update
RUN apk add tree

#compain comand
#RUN apk update && apk add tree

#CMD with run, when Stating the container
CMD echo "Welcome to DockerFile testing K..............."

# copy file into container(/bin/sh)
COPY testFile.txt ./

#ENV variable set only last CMD printed
#ENV JAVA_HOME=./etc
#CMD echo "java_home is:" ${JAVA_HOME}

#Expose expose_port:container_port
EXPOSE 8081

# workdir home folder
#WORKDIR ./app/java

#ENTRYPOINT when deploy app, start cmd [java -jar app.jar]
#ENTRYPOINT [ "executable" ]

