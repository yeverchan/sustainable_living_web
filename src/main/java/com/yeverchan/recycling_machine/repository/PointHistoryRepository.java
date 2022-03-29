package com.yeverchan.recycling_machine.repository;

import com.yeverchan.recycling_machine.domain.PointHistoryDto;

import java.util.List;

public interface PointHistoryRepository {
    int insertHistory(PointHistoryDto pointHistoryDto);
    List<PointHistoryDto> selectAllById(int point_id);
}
