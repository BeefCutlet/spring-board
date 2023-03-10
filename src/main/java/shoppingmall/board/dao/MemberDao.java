package shoppingmall.board.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import shoppingmall.board.dto.MemberDto;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class MemberDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MemberDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public int save(MemberDto memberDto) {
        int rows = jdbcTemplate.update("INSERT INTO member VALUES(?, ?, ?, ?, ?, ?)",
                memberDto.getId(),
                memberDto.getPassword(),
                memberDto.getEmail(),
                memberDto.getJoinDate(),
                memberDto.getLastLogin(),
                memberDto.getStatus());

        return rows;
    }

    public int update(MemberDto memberDto) {
        int rows = jdbcTemplate.update("UPDATE member SET " +
                " nickname=?, password=?, email=?, profile_img=?");

        return rows;
    }

    public Optional<MemberDto> findById(String id) {
        List<MemberDto> result = jdbcTemplate.query(
                "SELECT " +
                        "id, nickname, password, email, profile_img, join_date, last_login, status " +
                        "FROM member" +
                        "JOIN nick ON member.id = nick.nick_id" +
                        "WHERE id=?", memberRowMapper(), id);
        return result.stream().findAny();
    }

    public Optional<MemberDto> findByName(String nickname) {
        List<MemberDto> result = jdbcTemplate.query(
                "SELECT " +
                        "id, nickname, password, email, profile_img, join_date, last_login, status " +
                        "FROM member" +
                        "JOIN nick ON member.id = nick.nick_id" +
                        "WHERE nickname=?", memberRowMapper(), nickname);
        return result.stream().findAny();
    }

    public List<MemberDto> findAll() {
        List<MemberDto> memberList = jdbcTemplate.query(
                "SELECT " +
                        "id, nickname, password, email, profile_img, join_date, last_login, status " +
                        "FROM member" +
                        "JOIN nick ON member.id = nick.nick_id", memberRowMapper());

        return memberList;
    }

    private RowMapper<MemberDto> memberRowMapper() {
        return (rs, rowNum) -> {
            MemberDto member = new MemberDto();
            member.setId(rs.getString("id"));
            member.setNickname(rs.getString("nickname"));
            member.setPassword(rs.getString("password"));
            member.setEmail(rs.getString("email"));
            member.setProfileImg(rs.getString("profile_img"));
            member.setJoinDate(rs.getString("join_date"));
            member.setLastLogin(rs.getString("last_login"));
            member.setStatus(rs.getInt("status"));
            return member;
        };
    }
}
