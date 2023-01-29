package shoppingmall.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shoppingmall.board.dao.BoardDao;
import shoppingmall.board.dto.BoardDto;

import java.util.List;
import java.util.Optional;

@Service
public class BoardService {

    private BoardDao boardDao;

    @Autowired
    public BoardService(BoardDao boardDao) {
        this.boardDao = boardDao;
    }

    public int addBoard(BoardDto board) {
        int boardNo = boardDao.findBoardSeq();
        int result = boardDao.save(board);
        return result;
    }

    public int changeBoard(BoardDto board) {
        int result = boardDao.update(board);
        return result;
    }

    public int removeBoard(BoardDto board) {
        int result = boardDao.update(board);
        return result;
    }

    public List<BoardDto> getBoardList() {
        List<BoardDto> boardList = boardDao.findAll();
        return boardList;
    }

    public BoardDto getBoard(int boardNo) {
        BoardDto board = boardDao.findByNo(boardNo).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다."));
        return board;
    }
}
