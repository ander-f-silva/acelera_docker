FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
ARG DB_USERNAME=root
ARG DB_PASSWORD=root
ARG DB_CONNECTION=jdbc:mysql://localhost:3306/module-db?useSSL=false&useUnicode=true&characterEncoding=utf-8
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]