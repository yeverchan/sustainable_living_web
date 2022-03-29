package com.yeverchan.recycling_machine.repository;


import com.yeverchan.recycling_machine.domain.PointDto;
import com.yeverchan.recycling_machine.domain.PointHistoryDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class PointHistoryRepositoryImplTest {

    @Autowired
    PointRepository pointRepository;

    @Autowired
    PointHistoryRepository pointHistoryRepository;

    @Test
    public void insertTest(){
        int point_id = pointRepository.selectIdByUserId("zxcvzxcv");
        assertEquals(21, point_id);
        PointHistoryDto pointHistoryDto = new PointHistoryDto(point_id, "sold", "product name " + "service type", 500L);
        int check = pointHistoryRepository.insertHistory(pointHistoryDto);
        assertEquals(1, check);
    }

}