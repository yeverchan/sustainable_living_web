package com.yeverchan.recycling_machine.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class PointRepositoryImpl implements PointRepository {

    @Autowired
    SqlSession sqlSession;

    String namespace = "com.yeverchan.recycling_machine.repository.BoardMapper.";

    @Override
    public int init(String user_id) throws Exception {

        return sqlSession.insert(namespace + "insertPoint", user_id);
    }

    @Override
    public Long selectAmountById(String user_id) {
        return sqlSession.selectOne(namespace + "selectAmountById", user_id);
    }
    @Override
    public int selectIdByUserId(String user_id) {
        return sqlSession.selectOne(namespace + "selectIdByUserId", user_id);
    }

    @Override
    public int updatePoint(Map<String, String> value) {
        return sqlSession.update(namespace+"updatePoint", value);
    }
}
