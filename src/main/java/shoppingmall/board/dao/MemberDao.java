package shoppingmall.board.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import shoppingmall.board.dto.MemberDto;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class MemberDao implements JdbcDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MemberDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public MemberDto save(MemberDto memberDto) {
        return null;
    }

    @Override
    public Optional<MemberDto> findById(String id) {
        return Optional.empty();
    }

    @Override
    public Optional<MemberDto> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public List<MemberDto> findAll() {
        return null;
    }
}
