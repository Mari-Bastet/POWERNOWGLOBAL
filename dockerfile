# Use uma imagem base do OpenJDK
FROM openjdk:17-oracle

WORKDIR /app

ADD https://github.com/Mari-Bastet/POWERNOWGLOBAL/releases/download/global/powernow-0.0.1-SNAPSHOT.jar /app/powernow-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "/app/powernow-0.0.1-SNAPSHOT.jar"]

EXPOSE 8080
