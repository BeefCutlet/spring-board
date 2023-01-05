package shoppingmall.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller("/member")
public class MemberController {

    @GetMapping("/join")
    public String joinMemberForm() {
        return "";
    }

    @PostMapping("/join")
    public String joinMember() {
        return "";
    }

    @GetMapping("/login")
    public String loginMemberForm() {

        return "";
    }

    @PostMapping("/login")
    public String loginMember() {
        return "";
    }
}
