package com.example.board;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication은 이 클래스가 Spring Boot 프로젝트의 시작점임을 알려준다.
// 내부적으로 @Configuration, @EnableAutoConfiguration, @ComponentScan 기능을 포함한다.
// 즉, 현재 패키지 (com.example.board) 하위에 있는 Controller, Service, Repository 등을 자동으로 찾는다.
@SpringBootApplication
public class BoardApplication {

	public static void main(String[] args) {
		// Spring Boot 애플리케이션을 실행하는 코드
		// 이 코드가 실행되면 내장 톰캣 서버가 실행되고, 웹 요청을 받을 수 있는 상태가 된다.
		SpringApplication.run(BoardApplication.class, args);
	}

}
