package com.yeverchan.recycling_machine.repository;

import com.yeverchan.recycling_machine.domain.PointHistoryDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PointHistoryRepositoryImpl implements PointHistoryRepository {

    @Autowired
    SqlSession sqlSession;

    String namespace = "com.yeverchan.recycling_machine.repository.BoardMapper.";

    @Override
    public int insertHistory(PointHistoryDto pointHistoryDto){
        return sqlSession.insert(namespace+"insertPointHistory", pointHistoryDto);
    }
}
