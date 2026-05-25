package com.example.board.service;

import com.example.board.entity.Member;
import com.example.board.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    // 로그인 처리 메서드
    // username과 password를 받아서 DB에 저장된 회원 정보와 비교한다.
    public Member login(String username, String password) {

        // username으로 회원 조회
        Optional<Member> optionalMember = memberRepository.findByUsername(username);

        // 해당 username을 가진 회원이 없으면 로그인 실패
        if (optionalMember.isEmpty()) {
            return null;
        }

        // Optional 안에 들어있는 Member 객체 꺼내기
        Member member = optionalMember.get();

        // DB에 저장된 비밀번호와 사용자가 입력한 비밀번호 비교
        // 현재는 학습용이라 평문 비교를 사용한다.
        // 실제 서비스에서는 BCrypt 같은 방식으로 비밀번호를 암호화해야 한다.
        if (member.getPassword().equals(password)) {
            return member;
        }

        // 비밀번호가 다르면 로그인 실패
        return null;
    }
}
