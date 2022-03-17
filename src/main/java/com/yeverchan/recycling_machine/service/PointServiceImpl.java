package com.yeverchan.recycling_machine.service;

import com.yeverchan.recycling_machine.repository.PointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PointServiceImpl implements PointService {

    @Autowired
    PointRepository pointRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int init(String user_id){
        return pointRepository.init(user_id);
    }
}
