package com.yeverchan.recycling_machine.service;

import com.yeverchan.recycling_machine.domain.PointHistoryDto;

import java.util.List;

public interface PointHistoryService {
    List<PointHistoryDto> getAllHistory(String user_id);
}
