# 1️⃣ 빌드 스테이지 (Maven 빌드)
FROM maven:3.8.5-openjdk-17 AS build

# 2️⃣ 작업 디렉토리 설정
WORKDIR /app

# 3️⃣ pom.xml과 소스 코드 복사
COPY wetube/pom.xml .
COPY wetube/src ./src

# 4️⃣ Maven으로 패키징 (JAR 파일 생성)
RUN mvn clean package -DskipTests

# 5️⃣ target 폴더 확인 (디버깅용)
RUN ls -al /app/target/

# 6️⃣ 런타임 스테이지 (JDK 환경)
FROM openjdk:17-jdk-slim

# 7️⃣ JAR 파일 복사
COPY --from=build /app/target/wetube-0.0.1-SNAPSHOT.jar /app/app.jar

# 8️⃣ 실행 명령어
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
