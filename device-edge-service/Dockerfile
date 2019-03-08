FROM openjdk:8u191-jre-alpine

COPY target/device-edge-service-0.0.1-SNAPSHOT.jar /device-edge-service.jar

ENTRYPOINT ["java", "-jar", "/device-edge-service.jar"]