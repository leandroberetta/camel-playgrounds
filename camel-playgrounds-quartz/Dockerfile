FROM openjdk:8

ADD target/camel-playgrounds-quartz.jar /opt/quartz/app.jar

CMD ["java","-jar","/opt/quartz/app.jar","--spring.config.location=file:/opt/quartz/config/application.properties"]
