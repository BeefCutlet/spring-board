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
    private int boardViewCount;
    private int boardStatus;
    private int boardReGroup;
    private int boardReStep;
    private int boardReLevel;
}
