package com.example.board.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// @Entity는 Member 클래스가 DB 테이블과 연결되는 Entity임을 의미한다.
// JPA는 이 클래스를 기준으로 member 테이블을 생성하거나 매핑한다.
@Entity
public class Member {

    // 회원 번호를 의미하는 기본키(PK)
    @Id

    // 회원 번호가 자동으로 증가하도록 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 로그인할 때 사용할 아이디
    private String username;

    // 로그인할 때 사용할 비밀번호
    // 현재는 학습용으로 평문 저장하지만, 실제 서비스에서는 반드시 암호화해야 한다.
    private String password;

    // 회원 이름
    private String name;

    // JPA가 Entity 객체를 생성할 때 필요한 기본 생성자
    public Member() {
    }

    // id 값을 가져오는 getter
    public Long getId() {
        return id;
    }

    // id 값을 설정하는 setter
    public void setId(Long id) {
        this.id = id;
    }

    // username 값을 가져오는 getter
    public String getUsername() {
        return username;
    }

    // username 값을 설정하는 setter
    public void setUsername(String username) {
        this.username = username;
    }

    // password 값을 가져오는 getter
    public String getPassword() {
        return password;
    }

    // password 값을 설정하는 setter
    public void setPassword(String password) {
        this.password = password;
    }

    // name 값을 가져오는 getter
    public String getName() {
        return name;
    }

    // name 값을 설정하는 setter
    public void setName(String name) {
        this.name = name;
    }
}

