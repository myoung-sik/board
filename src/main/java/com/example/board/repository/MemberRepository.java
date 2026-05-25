package com.example.board.repository;

import com.example.board.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// MemberRepository는 Member Entity에 대한 DB 접근을 담당한다.
// interface로 만드는 이유는 Spring Data Jpa가 실행 시점에 구현체를 자동으로 만들어주기 때문이다.
// JpaRepository를 상속받으면 save(), findAll(), findById(), deleteById() 같은 기본 CRUD 기능을 사용할 수 있다.
public interface MemberRepository extends JpaRepository<Member, Long> {

    // JpaRepository<Member, Long>의 의미:
    // Member: 이 Repository가 관리할 Entity
    // Long: Member Entity의 기본키(id) 타입

    // username으로 회원을 조회하는 메서드
    // Spring Data JPA는 메서드 이름을 보고 자동으로 쿼리를 만들어준다.
    // findByUsername -> username 컬럼을 기준으로 회원을 찾는다.
    //
    // Optional<Member>를 사용하는 이유:
    // 해당 username을 가진 회원이 없을 수도 있기 때문에 null 대신 Optional로 감싸서 처리한다.
    Optional<Member> findByUsername(String username);
}
