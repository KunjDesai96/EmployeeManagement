#1. start with a base image containing java runtime
FROM openjdk:8-jdk-alpine

#2. Add maintainer info
LABEL maintainer="kundesai303@gmail.com"

#3. Add volume pointing to /tmp
VOLUME /tmp

#4. Make PORT 9010  available to the outside world
EXPOSE 9010

#5. application jar
ARG JAR_FILE=target/ProductRestAPI-0.0.1-SNAPSHOT.jar

#6. Add jar to the contai ner
ADD ${JAR_FILE} ProductRestAPI.jar

#7. Run the jar file
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/ProductRestAPI.jar"]