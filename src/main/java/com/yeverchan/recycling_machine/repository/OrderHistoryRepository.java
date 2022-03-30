package com.yeverchan.recycling_machine.repository;

import com.yeverchan.recycling_machine.domain.OrderHistoryDto;

import java.util.List;

public interface OrderHistoryRepository {
    List<OrderHistoryDto> orderHistories(String user_id);
    int insertHistory(OrderHistoryDto orderHistoryDto);
}
