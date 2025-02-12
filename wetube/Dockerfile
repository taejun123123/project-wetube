# 1. Java 이미지를 베이스로 설정
FROM openjdk:17-jdk-slim AS build

# 2. 작업 디렉토리 설정
WORKDIR /app

# 3. Maven Wrapper 스크립트를 포함하여 Maven을 설치하고 프로젝트 파일 복사
COPY ../pom.xml .
COPY ../src ./src

# 4. Maven을 사용하여 빌드 (JAR 파일 생성)
RUN ./mvnw clean package -DskipTests

# 5. 실행할 JAR 파일을 컨테이너에 복사
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

# 6. JAR 파일 실행
ENTRYPOINT ["java", "-jar", "app.jar"]
