FROM openjdk:11
ADD target/springapplication-0.0.1-SNAPSHOT.jar app.jar
ADD src/main/resources/application.properties app.properties
EXPOSE 9090
ENTRYPOINT ["java","-jar","-Dspring.config.location=/app.properties","/app.jar"]
