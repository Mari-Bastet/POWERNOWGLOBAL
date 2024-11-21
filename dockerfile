# Use uma imagem base do OpenJDK
FROM openjdk:17-oracle


WORKDIR /app

ADD https://github.com//Mari-Bastet/JAVACHALLENGEFINAL/releases/download/oracle/challenge-0.0.1-SNAPSHOT.jar /app/challenge-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "/app/challenge-0.0.1-SNAPSHOT.jar"]

EXPOSE 8080
