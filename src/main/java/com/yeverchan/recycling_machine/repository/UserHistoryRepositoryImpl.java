package com.yeverchan.recycling_machine.repository;

import com.yeverchan.recycling_machine.domain.UserHistoryDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserHistoryRepositoryImpl implements UserHistoryRepository{

    @Autowired
    SqlSession sqlSession;

    String namespace = "com.yeverchan.recycling_machine.repository.BoardMapper.";

    @Override
    public List<UserHistoryDto> selectAllByUserId(String user_id) {
        return sqlSession.selectList(namespace+"selectAllHistory", user_id);
    }

    @Override
    public int insert(UserHistoryDto userHistory) {
        return sqlSession.insert(namespace+"insertHistory", userHistory);
    }
}
