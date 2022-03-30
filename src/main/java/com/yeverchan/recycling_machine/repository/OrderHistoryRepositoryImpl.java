package com.yeverchan.recycling_machine.repository;


import com.yeverchan.recycling_machine.domain.OrderHistoryDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderHistoryRepositoryImpl implements OrderHistoryRepository {

    @Autowired
    SqlSession sqlSession;

    String namespace = "com.yeverchan.recycling_machine.repository.BoardMapper.";

    @Override
    public List<OrderHistoryDto> orderHistories(String user_id){
        return sqlSession.selectList(namespace+"selectOrderHistoryByUserId", user_id);
    }

    @Override
    public int insertHistory(OrderHistoryDto orderHistoryDto){
        return sqlSession.insert(namespace+"insertOrderHistory", orderHistoryDto);
    }
}
