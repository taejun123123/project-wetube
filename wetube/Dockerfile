# 1. OpenJDK 설치
FROM openjdk:17-jdk-slim

# 2. Maven 설치
RUN apt-get update && apt-get install -y maven

# 3. 작업 디렉토리 설정
WORKDIR /app

# 4. pom.xml과 src 디렉토리 복사
COPY wetube/pom.xml .
COPY wetube/src ./src

# 5. Maven을 사용하여 빌드 (JAR 파일 생성)
RUN mvn clean package -DskipTests

# 6. JAR 파일 복사
COPY target/*.jar app.jar

# 7. Spring Boot 애플리케이션 실행
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
