# Board Project

Spring Boot와 JPA를 활용한 게시판 프로젝트입니다.  
게시글 CRUD 기능을 시작으로 회원가입, 로그인, 세션 기반 인증 기능을 구현하며 웹 서비스 개발 과정을 학습하기 위해 제작하였습니다.

---

# 📌 개발 환경

- Java 17
- Spring Boot
- JPA
- MariaDB
- Gradle
- IntelliJ IDEA

---

# 🛠 기술 스택

## Backend
- Java
- Spring Boot
- Spring MVC
- JPA

## Database
- MariaDB

## Frontend
- HTML
- Thymeleaf

## Version Control
- Git
- GitHub

---

# ✨ 구현 기능

### 게시판 기능
- 게시글 작성(Create)
- 게시글 목록 조회(Read)
- 게시글 수정(Update)
- 게시글 삭제(Delete)
- 게시글 페이징 처리

### 회원 기능
- 회원가입
- 로그인
- 로그아웃
- 세션(Session) 기반 로그인 유지
- 로그인 사용자 정보 출력
---

# 📂 프로젝트 구조

```text
src
 ┣ main
 ┃ ┣ java
 ┃ ┃ ┗ com.example.board
 ┃ ┃   ┣ controller
 ┃ ┃   ┣ entity
 ┃ ┃   ┣ repository
 ┃ ┃   ┗ service
 ┃ ┗ resources
 ┃   ┣ templates
 ┃   ┗ static
```
---

# 📖 학습 내용
- Spring MVC 요청 처리 흐름 이해
- Controller-Service-Repository 계층 분리
- JPA를 활용한 CRUD 구현
- Spring Data JPA Repository 활용
- 페이징(Pageable, Page) 구현
- 회원가입 및 로그인 기능 구현
- HttpSession을 활용한 로그인 상태 유지
- Thymeleaf를 활용한 화면 출력 및 조건 처리
- GitHub를 활용한 버전 관리
---

# 🚀 향후 개선 예정
- 로그인하지 않은 사용자의 글쓰기 제한
- 게시글 작성자 기능 추가
- 본인 게시글만 수정/삭제 기능
- 관리자(Admin) 기능 추가
- 비밀번호 암호화(BCrypt)
- 예외 처리 개선

