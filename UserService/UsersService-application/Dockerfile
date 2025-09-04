FROM openjdk:21-oracle

LABEL description="user application"
LABEL author="sonns"

WORKDIR /application

# ARG cho file jar ứng dụng
ARG JAVA_FILE=target/*.jar

# Copy file jar ứng dụng
COPY ${JAVA_FILE} user-application.jar

EXPOSE 8080

# Chạy ứng dụng kèm Java Agent
ENTRYPOINT ["java", "-jar", "user-application.jar"]
