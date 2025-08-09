FROM openjdk:21-oracle

LABEL description="user application"
LABEL author="sonns"

WORKDIR /application

# ARG cho file jar ứng dụng
ARG JAVA_FILE=target/*.jar

# Copy file jar ứng dụng
COPY ${JAVA_FILE} user-application.jar

# Copy file OpenTelemetry Java Agent jar
COPY opentelemetry-javaagent.jar opentelemetry-javaagent.jar

EXPOSE 8080

# Chạy ứng dụng kèm Java Agent
ENTRYPOINT ["java", "-javaagent:/application/opentelemetry-javaagent.jar", "-Dotel.exporter.otlp.endpoint=http://collector:4318", "-Dotel.resource.attributes=service.name=auth-application", "-jar", "user-application.jar"]
