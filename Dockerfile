FROM maven:3.9.6-eclipse-temurin-17 AS builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim
WORKDIR /app

# Copia o jar
COPY --from=builder /app/target/Petshop-api-0.0.1-SNAPSHOT.jar app.jar

# Copia o wait-for-it.sh
COPY wait-for-it.sh /wait-for-it.sh
RUN chmod +x /wait-for-it.sh

EXPOSE 8080

# Espera o Postgres estar disponível na porta 5432 do host 'postgres' (nome do serviço Docker Compose)
ENTRYPOINT ["/wait-for-it.sh", "postgres:5432", "--", "java", "-jar", "app.jar"]



