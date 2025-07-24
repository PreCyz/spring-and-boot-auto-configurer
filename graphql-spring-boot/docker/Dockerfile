FROM openjdk:21-jdk-slim

COPY target/*.jar app.jar

ENV SERVER_PORT=8080
ENV SERVER_SERVLET_CONTEXT_PATH="/"
ENV	SPRING_PROFILES_ACTIVE=h2

EXPOSE 8080 8443

ENTRYPOINT ["java","-jar","/app.jar", "prod"]
