package shoppingmall.board.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDto {
    private int commentNo;
    private String commentContent;
    private String commentNickname;
    private String commentPostDate;
    private String commentBoardNo;
    private String commentReStep;
    private String commentReLevel;
    private String commentIpAddress;
}
