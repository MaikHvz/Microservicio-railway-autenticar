# ============================
# 1) BUILD CONTAINER
# ============================
FROM maven:3.9.4-eclipse-temurin-17 AS build

WORKDIR /app

# Copia todo el proyecto (pom.xml + src/)
COPY . .

# Construcción del JAR
RUN mvn clean package -DskipTests -Pproduction


# ============================
# 2) RUNTIME CONTAINER
# ============================
FROM eclipse-temurin:17-jre

WORKDIR /app

# Copia el JAR ya compilado
COPY --from=build /app/target/*.jar app.jar

# Puerto por defecto (Railway lo ignora y asigna uno propio)
EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
