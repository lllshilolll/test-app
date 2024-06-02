FROM maven:3.9.4-eclipse-temurin-17 as build

COPY warehouse-api warehouse-api/
COPY api-gateway api-gateway/
COPY warehouse-app warehouse-app/
COPY zoo zoo/
COPY config-cloud config-cloud/

COPY pom.xml .

RUN mvn clean package

FROM bellsoft/liberica-openjdk-debian:17
USER root

WORKDIR /app
COPY --from=build warehouse-app/target/warehouse-app-*.jar ./app.jar
ENTRYPOINT ["java", "-jar", "./app.jar"]

FROM bellsoft/liberica-openjdk-debian:17
USER root

WORKDIR /app
COPY --from=build api-gateway/target/api-gateway-*.jar ./gateway.jar
ENTRYPOINT ["java", "-jar", "./gateway.jar"]