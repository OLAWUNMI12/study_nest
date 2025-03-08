FROM openjdk:21-jdk-slim

WORKDIR /app

COPY target/*.jar study_nest_app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/study_nest_app.jar"]