package com.yeverchan.recycling_machine.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class OrderHistoryRepositoryImplTest {

    @Autowired
    OrderHistoryRepository orderHistoryRepository;

    @Test
    public void selectHistoriesTest(){
        String user_id = "zxcvzxcv";

        List<Map<String,String>> orderHistories = orderHistoryRepository.orderHistories(user_id);

        assertNotNull(orderHistories);

        System.out.println(orderHistories);
    }

}