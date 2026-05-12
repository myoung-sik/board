package com.example.board.service;

import com.example.board.entity.Board;
import com.example.board.repository.BoardRepository;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Service
public class BoardService {

    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public void save(String title, String content) {
        Board board = new Board();
        board.setTitle(title);
        board.setContent(content);

        boardRepository.save(board);
    }

    public Page<Board> findAll(Pageable pageable) {
        return boardRepository.findAll(pageable);
    }

    public Board findById(Long id) {
        return boardRepository.findById(id).get();
    }

    public void update(Long id, String title, String content) {
        Board board = boardRepository.findById(id).get();

        board.setTitle(title);
        board.setContent(content);

        boardRepository.save(board);
    }

    public void delete(Long id) {
        boardRepository.deleteById(id);
    }
}
