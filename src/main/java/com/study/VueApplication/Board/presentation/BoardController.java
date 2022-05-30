package com.study.VueApplication.Board.presentation;

import com.study.VueApplication.Board.application.BoardService;
import com.study.VueApplication.Board.domain.Board;
import com.study.VueApplication.Board.domain.BoardSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * 1. Presentation Layer (표현 계층) (Controller)
 *
 * 사용자 요청에 대해 해석하고 응답하는 일을 책임지는 계층이다.
 * 사용자에게 UI를 제공하거나 클라이언트에 응답을 다시 보내는 역할을 하는 모든 클래스가 포함된다.
 * Client로부터 request를 받고 response를 return 하는 API 정의
 */

/**
 * 다양한 의존성 주입 방법
 *
 * @Autowired
 * setter
 * 생성자 주입
 * → 이 중 가장 권하는 방식은 생성자로 주입받는 방식이다.  (이유 : 객체 불변성 확보, 테스트 코드 작성 용이)
 */

//@RequiredArgsConstructor // final이 선언된 모든 필드를 인자값으로 생성자를 만든다
@RestController
@RequestMapping( BoardController.URL_PREFIX )
public class BoardController {

    static final String URL_PREFIX = "/api/board";

    private final BoardService boardService;

    public BoardController( BoardService boardService) { this.boardService = boardService; }

    @GetMapping
    public ResponseEntity<?> list(){
        List<Board> list = boardService.findAll();
        return new ResponseEntity<List<Board>>(list, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getBoard(@PathVariable("id") Long id) {
        Optional<Board> posts = boardService.findById(id);
        return new ResponseEntity<Optional<Board>>(posts, HttpStatus.OK);
    }

    @PostMapping("/regist")
    public void regist(@RequestBody BoardSaveRequestDto dto) {
        Board board = Board.builder()
                .title(dto.getTitle())
                .contents(dto.getContents())
                .reg_id(dto.getReg_id())
                .build();

        boardService.save(board);
     }

    @PatchMapping("/modify/{id}")
    public void modify(@PathVariable("id") Long id, @RequestBody BoardSaveRequestDto dto) {

        Optional<Board> board = boardService.findById(id);

        board.ifPresent(selectBoard ->{
            selectBoard.setTitle(dto.getTitle());
            selectBoard.setContents(dto.getContents());
            Long newBoardId = boardService.save(selectBoard);
            System.out.println("newBoardId: " + newBoardId);
        });
    }

}
