FROM openjdk:8

ADD target/camel-playgrounds-idempotent-consumers.jar /opt/idemcon/app.jar

VOLUME /opt/idemcon/files

CMD ["java","-jar","/opt/idemcon/app.jar","--spring.config.location=file:/opt/idemcon/config/application.properties"]
