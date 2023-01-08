package shoppingmall.board.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDto {
    private String id;
    private String nickname;
    private String password;
    private String email;
    private String profileImg;
    private String joinDate;
    private String lastLogin;
    private int status;
}
