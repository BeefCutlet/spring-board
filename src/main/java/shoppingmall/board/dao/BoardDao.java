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
        int save = jdbcTemplate.update("INSERT INTO board VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        return save;
    }

    public int update(BoardDto board) {
        int update = jdbcTemplate.update("UPDATE board SET ");
        return update;
    }

    public List<BoardDto> findAll() {
        List<BoardDto> boardList = jdbcTemplate.query("SELECT * FROM board ORDER BY board_no DESC", memberRowMapper());
        return boardList;
    }

    public Optional<BoardDto> findByNo(int boardNo) {
        List<BoardDto> board = jdbcTemplate.query("SELECT * FROM board WHERE board_no=?", memberRowMapper(), boardNo);
        return board.stream().findAny();
    }

    private RowMapper<BoardDto> memberRowMapper() {
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
            board.setBoardIpAddress(rs.getString("board_ip_address"));
            return board;
        };
    }
}
