FROM openjdk:18-jdk AS build
WORKDIR /app
COPY . /app
RUN chmod +x ./gradlew && ./gradlew bootjar
ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -jar /app/build/libs/gomoku-0.0.1-SNAPSHOT.jar"]