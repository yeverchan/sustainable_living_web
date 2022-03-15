package com.yeverchan.recycling_machine.service;

import com.yeverchan.recycling_machine.domain.RegisterDto;
import com.yeverchan.recycling_machine.domain.UserDto;

public interface UserService {
    UserDto findById(String id) throws Exception;
    UserDto findByEmail(String email) throws Exception;
    void register(RegisterDto register) throws Exception;
}
