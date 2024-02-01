#Start with a base image containing Java runtie
FROM openjdk:17-jdk-slim

#Information around who maintains the image
MAINTAINER watchflix.com

#add the application,s jar to the image
COPY target/ContentDataCore-0.0.1-SNAPSHOT.jar ContentDataCore-0.0.1-SNAPSHOT.jar

#execute the application
ENTRYPOINT["java", "-jar","ContentDataCore-0.0.1-SNAPSHOT.jar"]