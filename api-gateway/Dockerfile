FROM openjdk:21-oracle

LABEL description="api gateway application"
LABEL author="sonns"

WORKDIR /application

ARG JAVA_FILE=target/*.jar

COPY ${JAVA_FILE} api-gateway.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "api-gateway.jar"]