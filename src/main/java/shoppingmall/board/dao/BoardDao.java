package shoppingmall.board.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import shoppingmall.board.dto.BoardDto;

import java.util.List;
import java.util.Optional;

@Component
public class BoardDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BoardDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int save(BoardDto board) {
        int save = jdbcTemplate.update(
                "INSERT INTO board VALUES (?, ?, ?, ?, ?, sysdate, 0, 1, ?, ?, ?)",
                board.getBoardNo(),
                board.getBoardWriter(),
                board.getBoardTitle(),
                board.getBoardContent(),
                board.getBoardCategory(),
                board.getBoardReGroup(),
                board.getBoardReStep(),
                board.getBoardReLevel());
        return save;
    }

    public int update(BoardDto board) {
        int update = jdbcTemplate.update(
                "UPDATE board " +
                        "SET " +
                        "board_title=?, " +
                        "board_content=?, " +
                        "board_category=? " +
                        "WHERE board_no=?",
                board.getBoardTitle(),
                board.getBoardContent(),
                board.getBoardCategory(),
                board.getBoardNo());
        return update;
    }

    public int updateViewCount(int boardNo) {
        int update = jdbcTemplate.update(
                "UPDATE board " +
                        "SET " +
                        "board_viewcount = board_viewcount + 1" +
                        "WHERE board_no=?",
                boardNo);
        return update;
    }

    public int updateStatus(int boardNo) {
        int result = jdbcTemplate.update("UPDATE board SET board_status=0 WHERE board_no=?", boardNo);
        return result;
    }

    public List<BoardDto> findAll() {
        List<BoardDto> boardList = jdbcTemplate.query("SELECT * FROM board ORDER BY board_no DESC", rowMapper());
        return boardList;
    }

    public Optional<BoardDto> findByNo(int boardNo) {
        List<BoardDto> board = jdbcTemplate.query("SELECT * FROM board WHERE board_no=?", rowMapper(), boardNo);
        return board.stream().findAny();
    }

    public int findBoardSeq() {
        Integer boardNo = jdbcTemplate.queryForObject("SELECT board_seq.nextval FROM DUAL", Integer.class);
        return boardNo;
    }

    private RowMapper<BoardDto> rowMapper() {
        return (rs, rowNum) -> {
            BoardDto board = new BoardDto();
            board.setBoardNo(rs.getInt("board_no"));
            board.setBoardWriter(rs.getString("board_writer"));
            board.setBoardTitle(rs.getString("board_title"));
            board.setBoardContent(rs.getString("board_content"));
            board.setBoardCategory(rs.getString("board_category"));
            board.setBoardPostDate(rs.getString("board_post_date"));
            board.setBoardViewCount(rs.getInt("board_viewcount"));
            board.setBoardStatus(rs.getInt("board_status"));
            board.setBoardReGroup(rs.getInt("board_re_group"));
            board.setBoardReStep(rs.getInt("board_re_step"));
            board.setBoardReLevel(rs.getInt("board_re_level"));
            return board;
        };
    }
}
