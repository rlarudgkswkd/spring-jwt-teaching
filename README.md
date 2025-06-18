# Mentor Assignment JWT (Spring Boot + JWT, JDK 11)

간단한 JWT 인증 실습을 위한 Spring Boot 예제 프로젝트입니다.

## 주요 기술
- Java 11 (Corretto 등)
- Spring Boot 2.7.x
- jjwt 0.11.x (JWT 토큰 발급/검증)
- Spring Security (최소 설정)

---

## 프로젝트 구조
```
src/main/java/com/example/jwt/
  ├── AuthController.java   # 로그인 및 인증 API
  ├── JwtUtil.java         # JWT 토큰 생성/파싱/검증 유틸
  ├── SecurityConfig.java  # Security 최소 설정
  └── MentorAssignmentJwtApplication.java # 메인 클래스
src/main/resources/
  └── application.properties
build.gradle
README.md
```

---

## 빌드 및 실행

1. **JDK 11**이 설치되어 있어야 합니다.
2. 의존성 설치 및 빌드:
   ```bash
   gradle clean build
   ```
3. 서버 실행:
   ```bash
   gradle bootRun
   ```
   (포트 8080이 이미 사용 중이면, `src/main/resources/application.properties`에서 `server.port=8081` 등으로 변경)

---

## API 사용법

### 1. 로그인 (JWT 토큰 발급)
- **POST** `/login`
- **Request Body:**
  ```json
  {
    "username": "user",
    "password": "password"
  }
  ```
- **Response:**
  ```json
  {
    "token": "<JWT 토큰>"
  }
  ```

### 2. 인증 테스트
- **GET** `/hello`
- **Header:**
  `Authorization: Bearer <JWT 토큰>`
- **Response:**
  - 성공: `Hello, user!`
  - 실패: `Invalid or missing token`

---

## 참고/주의사항
- JWT 서명 키는 실습용으로 코드 내에서 자동 생성합니다. (운영 환경에서는 반드시 안전하게 관리!)
- 아이디/비밀번호는 "user"/"password"로 고정되어 있습니다.
- Spring Security는 최소 설정만 적용되어 있습니다.
- 불필요한 파일은 `.gitignore`로 관리됩니다.

---

## 문의
- 실습/테스트/학습용으로 자유롭게 사용하세요! 