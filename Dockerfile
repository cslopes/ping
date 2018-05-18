FROM 682129122531.dkr.ecr.us-east-1.amazonaws.com/common/oracle-java
MAINTAINER Claudio Soares

COPY target/ping-0.0.1-SNAPSHOT.jar /app/service.jar

ENTRYPOINT ["java","-jar","/app/service.jar"]