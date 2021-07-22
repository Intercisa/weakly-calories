FROM openjdk:11
COPY target/ /tmp
WORKDIR /tmp
CMD java -jar weekly-kalorie-0.0.1-SNAPSHOT.jar