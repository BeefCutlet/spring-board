package shoppingmall.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import shoppingmall.board.dto.BoardDto;
import shoppingmall.board.service.BoardService;

import java.util.List;

@Controller
public class IndexController {

    private final BoardService boardService;

    @Autowired
    public IndexController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/")
    public String indexMapping(Model model) {
        List<BoardDto> boardList = boardService.getBoardList();
        model.addAttribute("boardList", boardList);
        return "index";
    }
}
