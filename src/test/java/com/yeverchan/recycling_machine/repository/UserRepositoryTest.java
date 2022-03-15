package com.yeverchan.recycling_machine.repository;

import com.yeverchan.recycling_machine.domain.UserDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;


    @Test
    public void selectUserTest() throws Exception {
        UserDto user = userRepository.select("test");
        assertEquals("test", user.getId());
    }
}