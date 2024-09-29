FROM openjdk:21
COPY "./target/apps-empresariales-0.0.1-SNAPSHOT.jar" "apps-empresariales.jar"
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "apps-empresariales.jar"]