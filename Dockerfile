FROM eclipse-temurin:17-jdk AS build
WORKDIR /app

# Copy only the Spring Boot app subdirectory
COPY academia-poo/ /app/

RUN chmod +x mvnw
RUN ./mvnw -DskipTests package

FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /app/target/academia-poo-0.0.1-SNAPSHOT.jar /app/app.jar

EXPOSE 8080
CMD ["java", "-jar", "/app/app.jar"]
