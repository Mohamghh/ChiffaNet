FROM openjdk:17-oracle
VOLUME /tmp
COPY target/medecin-disponibilite-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar", "app.jar"]