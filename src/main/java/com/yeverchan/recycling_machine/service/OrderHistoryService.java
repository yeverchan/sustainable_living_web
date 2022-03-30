package com.yeverchan.recycling_machine.service;

import com.yeverchan.recycling_machine.domain.OrderHistoryDto;

import java.util.List;

public interface OrderHistoryService {
    List<OrderHistoryDto> getHistory(String user_id);
}
