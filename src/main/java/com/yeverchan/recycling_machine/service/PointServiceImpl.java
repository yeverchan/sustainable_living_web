package com.yeverchan.recycling_machine.service;

import com.yeverchan.recycling_machine.repository.PointHistoryRepository;
import com.yeverchan.recycling_machine.repository.PointRepository;
import com.yeverchan.recycling_machine.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


}
