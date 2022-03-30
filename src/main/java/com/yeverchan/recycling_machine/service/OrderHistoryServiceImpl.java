package com.yeverchan.recycling_machine.service;


import com.yeverchan.recycling_machine.domain.OrderHistoryDto;
import com.yeverchan.recycling_machine.repository.OrderHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrderHistoryServiceImpl implements OrderHistoryService{

    @Autowired
    OrderHistoryRepository orderHistoryRepository;

    @Override
    public List<OrderHistoryDto> getHistory(String user_id){
        return orderHistoryRepository.orderHistories(user_id);
    }
}
