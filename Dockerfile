# 베이스 이미지로 OpenJDK 사용
FROM openjdk:17-jdk-alpine

# 애플리케이션 jar 파일을 /app 디렉토리로 복사
COPY build/libs/hr-auto-assign-api-0.0.1-SNAPSHOT.jar /app/app.jar

# 애플리케이션을 실행
ENTRYPOINT ["java", "-jar", "/app/app.jar"]

# 기본적으로 8080번 포트를 사용
EXPOSE 8080