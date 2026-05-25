package com.example.board.controller;

import com.example.board.entity.Member;
import com.example.board.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

// @Controller는 이 클래스가 웹 요청을 처리하는 Controller임을 의미한다.
// 회원가입, 로그인 등 회원 관련 요청을 담당한다.
@Controller
public class MemberController {

    // MemberService는 회원 관련 로직을 처리한다.
    private final MemberService memberService;

    // 생성자 주입
    // Spring이 MemberService 객체를 자동으로 넣어준다.
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // 회원가입 화면 요청
    // 브라우저에서 /join으로 접속하면 join.html을 보여준다.
    @GetMapping("/join")
    public String joinForm() {
        return "join";
    }

    // 회원가입 처리 요청
    // join.html의 form에서 입력한 username, password, name 값이
    // Member 객체에 자동으로 담겨 전달된다.
    @PostMapping("/join")
    public String join(Member member) {

        // 회원 정보를 Service로 전달하여 DB 저장
        memberService.save(member);

        // 회원가입 후 로그인 페이지로 이동
        // 아직 login.html은 만들 예정
        return "redirect:/login";
    }
}
