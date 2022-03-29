package com.yeverchan.recycling_machine.repository;

import com.yeverchan.recycling_machine.domain.PointHistoryDto;

public interface PointHistoryRepository {
    int insertHistory(PointHistoryDto pointHistoryDto);
}
