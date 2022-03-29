package com.yeverchan.recycling_machine.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class PointRepositoryImplTest {

    @Autowired
    PointRepository pointRepository;

    @Test
    public void updateTest(){
        Map<String, String> map = new HashMap<>();

        map.put("amount", "600");
        map.put("user_id", "zxcvzxcv");
        pointRepository.updatePoint(map);

        Long testValue = pointRepository.selectById("zxcvzxcv");

        assertEquals((Long) 600L, testValue);
    }


}