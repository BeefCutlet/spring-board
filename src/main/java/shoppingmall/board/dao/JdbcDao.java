package shoppingmall.board.dao;

import shoppingmall.board.dto.MemberDto;

import java.util.List;
import java.util.Optional;

public interface JdbcDao {

    MemberDto save(MemberDto memberDto);
    Optional<MemberDto> findById(String id);
    Optional<MemberDto> findByName(String name);
    List<MemberDto> findAll();
}
