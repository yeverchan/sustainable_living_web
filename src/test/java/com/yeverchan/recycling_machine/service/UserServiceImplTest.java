package com.yeverchan.recycling_machine.service;

import com.yeverchan.recycling_machine.domain.RegisterDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class UserServiceImplTest {

    @Autowired
    UserService userService;
    @Autowired
    PointService pointService;

    @Test
    public void register() {
        RegisterDto registerDto = new RegisterDto("testid", "12341234", "12341234", "email@email.com", "test");

        try {
            userService.register(registerDto);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}