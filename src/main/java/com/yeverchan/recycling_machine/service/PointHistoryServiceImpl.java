package com.yeverchan.recycling_machine.service;

import com.yeverchan.recycling_machine.domain.PointHistoryDto;
import com.yeverchan.recycling_machine.repository.PointHistoryRepository;
import com.yeverchan.recycling_machine.repository.PointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PointHistoryServiceImpl implements PointHistoryService{

    @Autowired
    PointHistoryRepository pointHistoryRepository;

    @Autowired
    PointRepository pointRepository;

    @Override
    public List<PointHistoryDto> getAllHistory(String user_id){
        int point_id = pointRepository.selectIdByUserId(user_id);
        return pointHistoryRepository.selectAllById(point_id);
    }
}
