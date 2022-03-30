package com.yeverchan.recycling_machine.repository;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class OrderHistoryRepositoryImpl implements OrderHistoryRepository {

    @Autowired
    SqlSession sqlSession;

    String namespace = "com.yeverchan.recycling_machine.repository.BoardMapper.";

    @Override
    public List<Map<String, String>> orderHistories(String user_id){
        return sqlSession.selectList(namespace+"selectOrderHistoryByUserId", user_id);
    }
}
