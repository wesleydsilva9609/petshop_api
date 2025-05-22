# Etapa 1: Build com Maven
FROM maven:3.9.6-eclipse-temurin-17 AS builder
WORKDIR /app
COPY . .

RUN mvn clean package -DskipTests

# Etapa 2: Executar o .jar gerado
FROM openjdk:17-jdk-slim
WORKDIR /app

# Copia o jar gerado
COPY --from=builder /app/target/Petshop-api-0.0.1-SNAPSHOT.jar app.jar

# Copia o wait-for-it.sh para o container
COPY wait-for-it.sh /wait-for-it.sh
RUN chmod +x /wait-for-it.sh

EXPOSE 8080

# Use o wait-for-it para aguardar o Postgres antes de iniciar a aplicação
ENTRYPOINT ["/wait-for-it.sh", "postgres:5432", "--", "java", "-jar", "app.jar"]





