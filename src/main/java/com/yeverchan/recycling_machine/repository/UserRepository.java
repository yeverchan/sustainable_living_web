package com.yeverchan.recycling_machine.repository;

import com.yeverchan.recycling_machine.domain.RegisterDto;
import com.yeverchan.recycling_machine.domain.UserDto;

import java.util.Map;

public interface UserRepository {
    UserDto select(String id) throws Exception;
    UserDto selectUser(String id) throws Exception;
    UserDto selectEmail(String email) throws Exception;
    int insert(RegisterDto register) throws Exception;
    void updateName(Map<String, String> name);
    void updateEmail(Map<String, String> email);
}
