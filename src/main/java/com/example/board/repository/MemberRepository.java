package com.example.board.repository;

import com.example.board.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

// MemberRepository는 Member Entity에 대한 DB 접근을 담당한다.
// interface로 만드는 이유는 Spring Data Jpa가 실행 시점에 구현체를 자동으로 만들어주기 때문이다.
public interface MemberRepository extends JpaRepository<Member, Long> {

    // JpaRepository<Member, Long>의 의미:
    // Member: 이 Repository가 관리할 Entity
    // Long: Member Entity의 기본키(id) 타입

    // 현재는 기본 CRUD만 사용하므로 별도의 메서드를 작성하지 않는다.
    // 이후 로그인 기능에서 username으로 회원을 찾기 위해
    // findByUsername 같은 메서드를 추가할 예정이다.
}
