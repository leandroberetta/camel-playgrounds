FROM openjdk:8-jdk-alpine

ADD target/camel-playgrounds-idempotent-consumers.jar app.jar

CMD ["java","-jar","/app.jar","--spring.config.location=file:/opt/config/application.properties"]

