FROM openjdk:17

WORKDIR /app

COPY . .

RUN mvn clean package

CMD ["java", "-jar", "target/notes-0.0.1-SNAPSHOT.jar"]
