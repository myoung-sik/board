package com.example.board.repository;

import com.example.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

// Repository는 DB에 접근하는 역할을 담당한다.
// JpaRepository를 상속받으면 기본 CRUD 메서드를 직접 만들지 않아도 사용할 수 있다.
// 예: save(), findAll(), findById(), deleteById()
public interface BoardRepository extends JpaRepository<Board, Long> {

    // JpaRepository<Board, Long>의 의미:
    // Board: 이 Repository가 관리할 Entity 클래스
    // Long: Board Entity의 기본키(id) 타입
}
