package com.example.board.service;

import com.example.board.entity.Board;
import com.example.board.repository.BoardRepository;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

// @Service는 이 클래스가 비즈니스 로직을 담당하는 Service 계층임을 의미한다.
// Controller가 직접 Repository를 호출하지 않고 Service를 거치게 하여 역할을 분리한다.
@Service
public class BoardService {

    // BoardRepository는 DB에 접근하는 객체
    // final을 붙여 생성자에서 한 번만 주입받도록 한다.
    private final BoardRepository boardRepository;

    // 생성자 주입 방식
    // Spring이 BoardRepository 객체를 자동으로 넣어준다.
    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    // 게시글 저장 기능
    // Controller에서 전달받은 title, content, writer를 board 객체에 담고 DB에 저장한다.
    public void save(String title, String content, String writer) {
        Board board = new Board();

        // 사용자가 입력한 제목을 Board 객체에 설정
        board.setTitle(title);

        // 사용자가 입력한 내용을 Board 객체에 설정
        board.setContent(content);

        // 로그인한 사용자의 이름을 작성자로 설정
        board.setWriter(writer);

        // save()는 새로운 Entity면 INSERT를 수행한다.
        boardRepository.save(board);
    }

    // 게시글 목록 조회 기능
    // Pageable을 받아 페이지 단위로 게시글을 조회한다.
    public Page<Board> findAll(Pageable pageable) {
        return boardRepository.findAll(pageable);
    }

    // 게시글 상세 조회 기능
    // id를 기준으로 게시글 하나를 조회한다.
    public Board findById(Long id) {
        // findById(id)는 Optional<Board>를 반환한다.
        // 현재는 학습용으로 .get()을 사용하지만, 실제 서비스에서는 예외 처리가 필요하다.
        return boardRepository.findById(id).get();
    }

    // 게시글 수정 기능
    // 기존 게시글을 id로 찾은 뒤 title, content를 새 값으로 변경한다.
    public void update(Long id, String title, String content) {
        Board board = boardRepository.findById(id).get();

        // 기존 제목을 새 제목으로 변경
        board.setTitle(title);

        // 기존 내용을 새 내용응로 변경
        board.setContent(content);

        // save()는 id가 있는 기존 Entity면 UPDATE를 수행한다.
        boardRepository.save(board);
    }

    // 게시글 삭제 기능
    // id를 기준으로 DB에서 게시글을 삭제한다.
    public void delete(Long id) {
        boardRepository.deleteById(id);
    }
}
