#aguardar openjdk:20 ficar disponivel no repository dockerHub
FROM openjdk:20-jdk-alpine

WORKDIR /app

COPY target/*.jar /app/app.jar

EXPOSE 8080

CMD ["java", "-jar", "/app/app.jar"]
