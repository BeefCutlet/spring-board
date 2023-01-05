package shoppingmall.board.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("/board")
public class BoardController {

    @GetMapping("/detail/{no}")
    public String boardList(@PathVariable int no) {
        return "";
    }
}
