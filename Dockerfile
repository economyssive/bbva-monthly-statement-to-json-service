#### Build Image

FROM maven:3.8-openjdk-16 as builder

WORKDIR /build
COPY src src
COPY bbva-monthly-statement-pdf-to-csv bbva-monthly-statement-pdf-to-csv
COPY pom.xml pom.xml

RUN mvn -f pom.xml clean package

#### Final Image

FROM openjdk:16-jdk-alpine
COPY --from=builder /build/target/bbva.pdfparser-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]