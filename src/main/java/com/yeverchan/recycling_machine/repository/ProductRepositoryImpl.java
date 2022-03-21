package com.yeverchan.recycling_machine.repository;


import com.yeverchan.recycling_machine.domain.ProductDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository{

    @Autowired
    SqlSession sqlSession;

    String namespace = "com.yeverchan.recycling_machine.repository.BoardMapper.";


    @Override
    public int insert(ProductDto product) {
        return sqlSession.insert(namespace+"insertProduct", product);
    }

    @Override
    public List<ProductDto> selectAll(){
        return sqlSession.selectList(namespace+"selectAllProduct");
    }

    @Override
    public List<ProductDto> selectAllByUserId(String user_id){
        return sqlSession.selectList(namespace+"selectAllProductByUserId", user_id);
    }
}
