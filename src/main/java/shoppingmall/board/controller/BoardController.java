package shoppingmall.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import shoppingmall.board.dto.BoardDto;
import shoppingmall.board.service.BoardService;

import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/detail/{no}")
    public String boardDetail(@PathVariable("no") int no, Model model) {
        model.addAttribute("board", boardService.getBoard(no));
        return "board/view";
    }

    @GetMapping("/write")
    public String writeBoardForm() {
        return "board/write";
    }

    @PostMapping("/write")
    public String writeBoard(@ModelAttribute BoardDto boardDto) {
        boardService.addBoard(boardDto);
        return "index";
    }
}
