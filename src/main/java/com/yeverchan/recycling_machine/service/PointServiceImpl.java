package com.yeverchan.recycling_machine.service;

import com.yeverchan.recycling_machine.domain.PointHistoryDto;
import com.yeverchan.recycling_machine.domain.ProductDto;
import com.yeverchan.recycling_machine.domain.ServiceType;
import com.yeverchan.recycling_machine.repository.PointHistoryRepository;
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
    PointHistoryRepository pointHistoryRepository;

    @Autowired
    ProductRepository productRepository;

    @Override
    public Long getPoint(String user_id) {
        return pointRepository.selectAmountById(user_id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean txPoint(ProductDto product, String ordererId) throws Exception{
        if (pointRepository.selectAmountById(ordererId) - product.getPrice() < 0) {
            return false;
        }

        Map<String, String> merchant = new HashMap<>();
        merchant.put("amount", (pointRepository.selectAmountById(product.getUser_id())) + product.getPrice() + "");
        merchant.put("user_id", product.getUser_id());
        int check = pointRepository.updatePoint(merchant);
        if(check != 1){
            throw new Exception();
        }
        pointHistoryRepository.insertHistory(setPointHistory(product, product.getUser_id(), ServiceType.SOLD));

        Map<String, String> orderer = new HashMap<>();
        orderer.put("amount", (pointRepository.selectAmountById(ordererId) - product.getPrice()) + "");
        orderer.put("user_id", ordererId);
        int check2 = pointRepository.updatePoint(orderer);
        if(check2 != 1){
            throw new Exception();
        }
        pointHistoryRepository.insertHistory(setPointHistory(product, ordererId, ServiceType.PURCHASED));

        return true;
    }


    private PointHistoryDto setPointHistory(ProductDto product, String id, ServiceType serviceType){
        PointHistoryDto pointHistory = new PointHistoryDto();
        pointHistory.setPoint_id(pointRepository.selectIdByUserId(id));
        pointHistory.setService_type(serviceType+"");
        pointHistory.setService_description(product.getName() + " "+ serviceType);
        pointHistory.setAmount(product.getPrice());
        return pointHistory;
    }
}
