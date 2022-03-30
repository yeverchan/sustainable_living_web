package com.yeverchan.recycling_machine.repository;

import com.yeverchan.recycling_machine.domain.OrderHistoryDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.regex.Pattern;


import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class OrderHistoryRepositoryImplTest {

    @Autowired
    OrderHistoryRepository orderHistoryRepository;

    @Test
    public void selectHistoriesTest(){
        String user_id = "zxcvzxcv";

        List<OrderHistoryDto> orderHistories = orderHistoryRepository.orderHistories(user_id);

        assertNotNull(orderHistories);

        System.out.println(orderHistories);

    }

    @Test
    public void insertHistoryTest(){
        OrderHistoryDto orderHistoryDto = new OrderHistoryDto();
        orderHistoryDto.setUser_id("zxcvzxcv");
        orderHistoryDto.setId(2);
        orderHistoryDto.setOrderer_name("test_user");
        orderHistoryDto.setOrderer_address("test address");
        orderHistoryDto.setOrderer_phone_number("test number");

        int check = orderHistoryRepository.insertHistory(orderHistoryDto);

        assertEquals(1, check);

    }
}