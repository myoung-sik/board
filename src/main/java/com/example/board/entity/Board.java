package com.example.board.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// @Entity는 이 클래스가 DB 테이블과 연결되는 클래스임을 의미한다.
// JPA는 이 클래스를 기준으로 board 테이블을 생성하거나 매핑한다.
@Entity
public class Board {

    // @Id는 이 필드가 테이블의 기본키(PK)임을 의미한다.
    @Id

    // @GeneratedValue는 id 값을 DB가 자동으로 증가시키도록 설정한다.
    // GeneratedType.IDENTITY는 MariaDB의 AUTO_INCREMENT 방식과 유사하다.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 게시글 제목을 저장하는 필드
    private String title;

    // 게시글 내용을 저장하는 필드
    private String content;

    // JPA는 Entity 객체를 생성할 때 기본 생성자를 필요로 한다.
    // 그래서 매개변수가 없는 생성자를 반드시 작성한다.
    public Board() {
    }

    // id 값을 가져오는 getter
    public Long getId() {
        return id;
    }

    // id 값을 설정하는 setter
    public void setId(Long id) {
        this.id = id;
    }

    // title 값을 가져오는 getter
    public String getTitle() {
        return title;
    }

    // title 값을 설정하는 setter
    public void setTitle(String title) {
        this.title = title;
    }

    // content 값을 가져오는 getter
    public String getContent() {
        return content;
    }

    // content 값을 설정하는 setter
    public void setContent(String content) {
        this.content = content;
    }
}
