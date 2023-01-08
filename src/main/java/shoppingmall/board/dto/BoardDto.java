package shoppingmall.board.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDto {
    private int boardNo;
    private String boardWriter;
    private String boardTitle;
    private String boardContent;
    private String boardCategory;
    private String boardPostDate;
    private String boardViewCount;
    private String boardStatus;
    private String boardReGroup;
    private String boardReStep;
    private String boardReLevel;
    private String boardIpAddress;
}
