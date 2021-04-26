FROM openjdk:11.0.11-jre
ARG JAR_FILE=target/*.jar
ENV DB_USERNAME=user
ENV DB_PASSWORD=password
ENV DB_HOST=localhost
ENV DB_PORT=3306
ENV DB_DATABASE=database
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 3000 3000
