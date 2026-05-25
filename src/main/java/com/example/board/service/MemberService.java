package com.example.board.service;

import com.example.board.entity.Member;
import com.example.board.repository.MemberRepository;
import org.springframework.stereotype.Service;

// @Service는 이 클래스가 회원 관련 비즈니스 로직을 담당한다는 의미이다.
@Service
public class MemberService {

    // MemberRepository는 회원 데이터를 DB에 저장하거나 조회하는 역할을 한다.
    private final MemberRepository memberRepository;

    // 생성자 주입
    // Spring이 MemberRepository 객체를 자동으로 주입해준다.
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // 회원가입 처리 메서드
    // Controller에서 전달받은 Member 객체를 DB에 저장한다.
    public void save(Member member) {
        memberRepository.save(member);
    }
}
