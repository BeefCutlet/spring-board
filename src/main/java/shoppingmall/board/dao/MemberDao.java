package shoppingmall.board.dao;

import shoppingmall.board.dto.MemberDto;

import java.util.List;
import java.util.Optional;

public class MemberDao implements JdbcDao {

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
