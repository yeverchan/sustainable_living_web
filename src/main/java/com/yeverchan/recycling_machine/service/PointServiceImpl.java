package com.yeverchan.recycling_machine.service;

import com.yeverchan.recycling_machine.domain.ProductDto;
import com.yeverchan.recycling_machine.repository.PointRepository;
import com.yeverchan.recycling_machine.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
public class PointServiceImpl implements PointService {

    @Autowired
    PointRepository pointRepository;

    @Autowired
    ProductRepository productRepository;

    @Override
    public Long getPoint(String user_id) {
        return pointRepository.selectById(user_id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean calculatePoint(ProductDto product, String ordererId) throws Exception{
        if (pointRepository.selectById(ordererId) - product.getPrice() < 0) {
            return false;
        }

        Map<String, String> merchant = new HashMap<>();
        merchant.put("amount", (pointRepository.selectById(product.getUser_id())) + product.getPrice() + "");
        merchant.put("user_id", product.getUser_id());
        int check = pointRepository.updatePoint(merchant);
        System.out.println(check);
        if(check != 1){
            throw new Exception();
        }

        Map<String, String> orderer = new HashMap<>();
        orderer.put("amount", (pointRepository.selectById(ordererId) - product.getPrice()) + "");
        orderer.put("user_id", ordererId);
        int check2 = pointRepository.updatePoint(orderer);
        System.out.println(check2);
        if(check2 != 1){
            throw new Exception();
        }

        return true;
    }

}
