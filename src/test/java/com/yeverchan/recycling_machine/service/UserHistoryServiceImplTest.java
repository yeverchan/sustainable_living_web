package com.yeverchan.recycling_machine.service;

import com.yeverchan.recycling_machine.domain.UserHistoryDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class UserHistoryServiceImplTest {

    @Autowired
    UserHistoryService userHistoryService;

    @Test
    public void userHistoryInsertTest() throws InterruptedException {
        UserHistoryDto userHistory = new UserHistoryDto("testid", "test", "test@email.com");
        int check = userHistoryService.createHistory(userHistory);
        assertEquals(1, check);
        userHistory.setName("changeName");
        Thread.sleep(1500);
        check = userHistoryService.createHistory(userHistory);
        assertEquals(1, check);
        userHistory.setEmail("change@email.com");
        Thread.sleep(1500);
        check = userHistoryService.createHistory(userHistory);
        assertEquals(1, check);
    }

    @Test
    public void getUserHistoryTest(){
        List<UserHistoryDto> userHistories = userHistoryService.getUserHistories("testid");
        System.out.println(userHistories);
    }
}