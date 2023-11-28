#FROM openjdk:18-jdk AS build
#WORKDIR /app
#COPY . /app
#RUN chmod +x ./gradlew && ./gradlew bootjar
#ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -jar /app/build/libs/gomoku-0.0.1-SNAPSHOT.jar"]

## 1. Jasypt 를 적용한 프로젝트
## 필요한 종속 항목 설치 및 jar 파일 생성
#FROM jdk-18.0.2.1 AS build
#WORKDIR /app
#COPY . /app
#RUN chmod +x ./gradlew && ./gradlew clean bootJar
#
## 생성한 jar 파일을 실행함.
#FROM jdk-18.0.2.1
#WORKDIR /app
#COPY --from=build /app/build/libs/gomoku.jar /app/gomoku.jar
#ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -jar /app/build/libs/gomoku-0.0.1-SNAPSHOT.jar"]

# Build stage
FROM jdk-17 AS build
WORKDIR /app
COPY . /app
RUN chmod +x ./gradlew && ./gradlew clean bootJar

# Runtime stage
FROM jdk-17 AS runtime
WORKDIR /app
COPY --from=build /app/build/libs/gomoku.jar /app/gomoku.jar

# Set JAVA_HOME and update PATH
ENV JAVA_HOME=/usr/local/jdk-17
ENV PATH="$JAVA_HOME/bin:${PATH}"

ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -jar /app/gomoku.jar"]

