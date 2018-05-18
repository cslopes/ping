FROM java:openjdk-8-alpine
MAINTAINER Claudio Soares

COPY target/ping-0.0.1-SNAPSHOT.jar /app/service.jar

ENTRYPOINT ["java","-jar","/app/service.jar"]