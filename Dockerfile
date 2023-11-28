#FROM openjdk:18-jdk AS build
#WORKDIR /app
#COPY . /app
#RUN chmod +x ./gradlew && ./gradlew bootjar
#ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -jar /app/build/libs/gomoku-0.0.1-SNAPSHOT.jar"]

# 1. Jasypt 를 적용한 프로젝트
# 필요한 종속 항목 설치 및 jar 파일 생성
#FROM openjdk:17-jdk AS build
#WORKDIR /tmp
#COPY . /tmp
#RUN yum update && yum install -y findutils
#RUN chmod +x ./gradlew && ./gradlew clean bootJar
#
#FROM openjdk:17-jdk
#WORKDIR /tmp
#COPY --from=build /tmp/build/libs/gomoku.jar /tmp/gomoku.jar
#ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -jar /tmp/gomoku.jar"]

# Build Stage
FROM amazonlinux:2 AS build
WORKDIR /tmp
COPY . /tmp
RUN yum update -y && yum install -y java-17-openjdk findutils
RUN chmod +x ./gradlew && ./gradlew clean bootJar

# Final Stage
FROM openjdk:17-jdk
WORKDIR /tmp
COPY --from=build /tmp/build/libs/gomoku.jar /tmp/gomoku.jar
ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -jar /tmp/gomoku.jar"]



