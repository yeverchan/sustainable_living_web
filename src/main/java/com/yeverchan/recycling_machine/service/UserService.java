package com.yeverchan.recycling_machine.service;

import com.yeverchan.recycling_machine.domain.RegisterDto;
import com.yeverchan.recycling_machine.domain.UserAuthInfo;
import com.yeverchan.recycling_machine.domain.UserDto;

import java.util.Map;

public interface UserService {
    UserDto findById(String id) throws Exception;
    UserDto findByEmail(String email) throws Exception;
    void register(RegisterDto register) throws Exception;
    UserAuthInfo login(UserDto user) throws Exception;
    void setName(Map<String, String> name);
    void setEmail(Map<String, String> email);
}
