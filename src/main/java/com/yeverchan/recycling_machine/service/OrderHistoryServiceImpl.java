package com.yeverchan.recycling_machine.service;


import com.yeverchan.recycling_machine.domain.Order;
import com.yeverchan.recycling_machine.domain.OrderHistoryDto;
import com.yeverchan.recycling_machine.repository.OrderHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrderHistoryServiceImpl implements OrderHistoryService {

    @Autowired
    OrderHistoryRepository orderHistoryRepository;

    @Override
    public List<OrderHistoryDto> getHistory(String user_id) {
        return orderHistoryRepository.orderHistories(user_id);
    }

    @Override
    public int setHistory(Order order, String user_id) throws Exception{
        OrderHistoryDto orderHistoryDto = new OrderHistoryDto();
        orderHistoryDto.setUser_id(user_id);
        orderHistoryDto.setId(order.getProductId());
        orderHistoryDto.setOrderer_name(order.getOrdererName());
        orderHistoryDto.setOrderer_address(order.getOrdererAddress());
        orderHistoryDto.setOrderer_phone_number(order.getOrdererPhone());

        int check = orderHistoryRepository.insertHistory(orderHistoryDto);
        if(check != 1){
            throw new Exception();
        }
        return check;
    }
}
