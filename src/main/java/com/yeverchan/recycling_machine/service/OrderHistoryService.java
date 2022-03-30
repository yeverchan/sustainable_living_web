package com.yeverchan.recycling_machine.service;

import com.yeverchan.recycling_machine.domain.Order;
import com.yeverchan.recycling_machine.domain.OrderHistoryDto;

import java.util.List;

public interface OrderHistoryService {
    List<OrderHistoryDto> getHistory(String user_id);
    int setHistory(Order order, String user_id) throws Exception;
}
