package shoppingmall.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shoppingmall.board.dao.BoardDao;
import shoppingmall.board.dto.BoardDto;

import java.util.List;

@Service
public class BoardService {

    private final BoardDao boardDao;

    @Autowired
    public BoardService(BoardDao boardDao) {
        this.boardDao = boardDao;
    }

    public List<BoardDto> selectBoardList() {
        List<BoardDto> boardList = boardDao.findAll();
        return boardList;
    }
}
