# Build stage
FROM maven:3.9.6-eclipse-temurin-21 AS build

#ENV GEMINI_URL=https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash:generateContent?key=
#ENV GEMINI_KEY=AIzaSyDwN-o93AjVzE55XfvL_ZncQHjCND5uVkw

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src
RUN mvn clean package -DskipTests

# Final stage with the Java image
FROM eclipse-temurin:21-jdk

WORKDIR /app

# Copy the JAR from the build stage to the final stage
COPY --from=build /app/target/snapreply.jar /app/target/snapreply.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/target/snapreply.jar"]
