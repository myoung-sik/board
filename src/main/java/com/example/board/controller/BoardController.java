package com.example.board.controller;

import com.example.board.entity.Board;
import com.example.board.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;


@Controller
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/write")
    public String writeForm() {
        return "write";
    }

    @PostMapping("/write")
    public String write(@RequestParam String title,
                        @RequestParam String content) {

        boardService.save(title, content);

        return "redirect:/hello";
    }

    @GetMapping("/list")
    public String list(@RequestParam(defaultValue = "0") int page,
                       Model model) {

        Pageable pageable = PageRequest.of(page, 5);
        Page<Board> boards = boardService.findAll(pageable);

        model.addAttribute("boards", boards);
        return "list";
    }

    @GetMapping("/detail")
    public String detail(Long id, Model model) {

        Board board = boardService.findById(id);

        model.addAttribute("board", board);

        return "detail";
    }

    @GetMapping("/delete")
    public String delete(Long id) {

        boardService.delete(id);

        return "redirect:/list";
    }

    @GetMapping("/edit")
    public String edit(Long id, Model model) {

        Board board = boardService.findById(id);

        model.addAttribute("board", board);

        return "edit";
    }

    @PostMapping("/edit")
    public String edit(Long id,
                       @RequestParam String title,
                       @RequestParam String content) {

        boardService.update(id, title, content);

        return "redirect:/detail?id=" + id;
    }

}
