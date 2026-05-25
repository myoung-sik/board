package com.example.board.controller;

import com.example.board.entity.Member;
import com.example.board.service.MemberService;
import jakarta.servlet.http.HttpSession;
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
        return "redirect:/login";
    }

    // 로그인 화면 요청
    // 브라우저에서 /login으로 접속하면 login.html을 보여준다.
    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    // 로그인 처리 요청
    // login.html에서 입력한 username, password를 받아 로그인 검증을 진행한다.
    @PostMapping("/login")
    public String login(String username,
                        String password,
                        HttpSession session) {

        // Service에서 username/password가 맞는지 확인
        Member loginMember = memberService.login(username, password);

        // 로그인 실패
        // 회원이 없거나 비밀번호가 틀린 경우 다시 로그인 화면으로 이동
        if (loginMember == null) {
            return "redirect:/login";
        }

        // 로그인 성공
        // 세션에 로그인한 회원 정보를 저장한다.
        // 세션은 서버가 사용자별로 로그인 상태를 기억하기 위해 사용하는 저장 공간이다.
        session.setAttribute("loginMember", loginMember);

        // 로그인 성공 후 게시글 목록으로 이동
        return "redirect:/list";
    }

    // 로그아웃 처리
    // 세션을 삭제하여 로그인 상태를 해제한다.
    @GetMapping("/logout")
    public String logout(HttpSession session) {

        // 현재 사용자 세션 전체 삭제
        session.invalidate();

        // 로그아웃 후 목록 페이지로 이동
        return "redirect:/list";
    }
}
