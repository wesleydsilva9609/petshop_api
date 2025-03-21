FROM ubuntu:latest AS build

RUN apt-get update
RUN apt-get install openjdk-17-jdk -y
COPY . .  # Copia o código-fonte

RUN apt-get install maven -y
RUN mvn clean package  # Gera o JAR corretamente

FROM openjdk:17-jdk-slim

EXPOSE 8080

# Copia o JAR para a imagem final
COPY target/Petshop-api-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT [ "java", "-jar", "app.jar" ]
