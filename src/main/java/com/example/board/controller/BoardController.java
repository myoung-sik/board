package com.example.board.controller;

import com.example.board.entity.Board;
import com.example.board.service.BoardService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

// @Controller는 이 클래스가 웹 요청을 처리하는 Controller임을 의미한다.
// 게시판 관련 요청을 담당한다.
@Controller
public class BoardController {

    // BoardService는 게시판 기능의 실제 로직을 처리한다.
    private final BoardService boardService;

    // 생성자 주입
    // Spring이 BoardService 객체를 자동으로 넣어준다.
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    // 글쓰기 화면을 보여주는 요청
    // 브라우저에서 /write로 접속하면 write.html을 보여준다.
    @GetMapping("/write")
    public String writeForm(HttpSession session) {

        // 세션에 로그인 정보가 있는지 확인
        Object loginMember = session.getAttribute("loginMember");

        // 로그인 안 한 경우
        if (loginMember == null) {
            // 로그인 페이지로 이동
            return "redirect:/login";
        }

        // 로그인한 경우
        return "write";
    }

    // 글쓰기 처리 요청
    // write.html의 form에서 POST 방식으로 전달된 title, content를 받는다.
    @PostMapping("/write")
    public String write(@RequestParam String title,
                        @RequestParam String content) {

        // 입력받은 제목과 내용을 Service로 전달하여 저장 처리
        boardService.save(title, content);

        // 저장 후 목록 페이지로 이동
        // redirect는 브라우저에게 /list 주소로 다시 요청하라고 지시한다.
        return "redirect:/list";
    }

    // 게시글 목록 조회
    // /list?page=0 형태로 페이지 번호를 받을 수 있다.
    @GetMapping("/list")
    public String list(@RequestParam(defaultValue = "0") int page,
                       Model model,
                       HttpSession session) {

        // PageRequest.of(현재 페이지 번호, 한 페이지당 게시글 수)
        // Page는 0부터 시작한다.
        Pageable pageable = PageRequest.of(page, 5);

        // Service를 통해 페이지 단위 게시글 목록 조회
        Page<Board> boards = boardService.findAll(pageable);

        // 조회한 게시글 목록을 "boards"라는 이름으로 HTML에 전달
        model.addAttribute("boards", boards);

        // 세션에 저장된 로그인 회원 정보 가져오기
        Object loginMember = session.getAttribute("loginMember");

        // loginMember라는 이름으로 HTML에 전달
        model.addAttribute("loginMember", loginMember);

        // teplates/list.html 화면 반환
        return "list";
    }

    // 게시글 상세 조회
    // /detail?id=1 형태로 id 값을 전달받는다.
    @GetMapping("/detail")
    public String detail(Long id, Model model) {

        // id를 기준으로 게시글 하나 조회
        Board board = boardService.findById(id);

        // 조회한 게시글을 "board"라는 이름으로 HTML에 전달
        model.addAttribute("board", board);

        // templates/detail.html 화면 반환
        return "detail";
    }

    // 수정 화면 보여주기
    // 기존 게시글 데이터를 조회해서 edit.html에 전달한다.
    @GetMapping("/edit")
    public String editForm(Long id, Model model) {

        // 수정할 게시글 조회
        Board board = boardService.findById(id);

        // edit.html에서 기존 제목과 내용을 보여주기 위해 전달
        model.addAttribute("board", board);

        return "edit";
    }

    // 수정 처리
    // edit.html에서 POST 방식으로 전달된 id, title, content를 받는다.
    @PostMapping("/edit")
    public String edit(Long id,
                       @RequestParam String title,
                       @RequestParam String content) {

        // Service에서 기존 게시글을 찾아 새 값으로 수정
        boardService.update(id, title, content);

        // 수정 후 해당 게시글 상세 페이지로 이동
        return "redirect:/detail?id=" + id;
    }

    // 게시글 삭제
    // /delete?id=1 형태로 id를 받아 해당 게시글을 삭제한다.
    @GetMapping("/delete")
    public String delete(Long id) {

        // Service를 통해 게시글 삭제
        boardService.delete(id);

        // 삭제 후 목록 페이지로 이동
        return "redirect:/list";
    }

}
