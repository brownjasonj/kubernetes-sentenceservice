FROM openjdk:jre-alpine
# if we want to install via apt
COPY build/libs/SentenceService-0.0.1-SNAPSHOT.jar /tmp
EXPOSE 8080
WORKDIR /tmp
CMD ["java", "-jar", "SentenceService-0.0.1-SNAPSHOT.jar"]