FROM openjdk:8-jre
MAINTAINER Data61 <cdr-data61@csiro.au>

ENTRYPOINT ["/usr/bin/java", "-jar", "/opt/cds-holder/holder.jar"]
EXPOSE 8080/tcp

ADD payloads           /payloads

ARG JAR_FILE
ADD target/${JAR_FILE} /opt/cds-holder/holder.jar

