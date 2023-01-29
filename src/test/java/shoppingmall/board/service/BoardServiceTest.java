package shoppingmall.board.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import shoppingmall.board.dao.BoardDao;
import shoppingmall.board.dto.BoardDto;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class BoardServiceTest {

    private BoardService boardService = new BoardService(new BoardDao(new JdbcTemplate()));

    @Test
    void addBoard() {
    }

    @Test
    void changeBoard() {
    }

    @Test
    void removeBoard() {
    }

    @Test
    void getBoardList() {
    }

    @Test
    void getBoard() {
        BoardDto board = boardService.getBoard(1);
        Assertions.assertThat(board.getBoardWriter()).isEqualTo("user1");
    }
}