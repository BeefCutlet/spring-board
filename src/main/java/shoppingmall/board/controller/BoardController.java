package shoppingmall.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import shoppingmall.board.dto.BoardDto;
import shoppingmall.board.service.BoardService;

import java.util.List;

@Controller("/board")
public class BoardController {

    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/detail/{no}")
    public String boardDetail(@PathVariable int no) {

        return "";
    }
}
