package com.yeverchan.recycling_machine.repository;

import com.yeverchan.recycling_machine.domain.RegisterDto;
import com.yeverchan.recycling_machine.domain.UserDto;

public interface UserRepository {
    UserDto select(String id) throws Exception;
    UserDto selectEmail(String email) throws Exception;
    int insert(RegisterDto register) throws Exception;
}
