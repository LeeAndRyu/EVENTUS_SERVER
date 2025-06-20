# 🔹 1단계: gradle:8.12-jdk17를 띄워서 해당 이미지를 사용할 수 있는 Docker Container를 띄운다.
FROM gradle:8.12-jdk17 AS build
WORKDIR /home/gradle/project

# gradle 명령 실행에 필요한 전체 소스 복사
# (Dockerfile의 . 위치 -> docker container의 . 위치로 이동)
COPY --chown=gradle:gradle . .

# Gradle 빌드 (Spring Boot plugin이 적용되어 있어야 함)
RUN gradle clean bootJar --no-daemon

# 🔹 2단계: 실행용 이미지
FROM eclipse-temurin:17-jdk AS runtime
WORKDIR /app

# 빌드된 jar 복사
COPY --from=build /home/gradle/project/build/libs/*.jar app.jar

# 환경 변수 설정 (필요 시 SPRING_PROFILES_ACTIVE 변경 가능)
ENV JAVA_OPTS="-Duser.timezone=Asia/Seoul" \
    SPRING_PROFILES_ACTIVE=dev

# 포트 노출
EXPOSE 8080

# 비루트 사용자로 실행
USER 1001

# ENTRYPOINT - JAVA_OPTS를 확장 가능하게
ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -jar app.jar"]