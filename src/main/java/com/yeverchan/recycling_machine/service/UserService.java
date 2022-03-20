package com.yeverchan.recycling_machine.service;

import com.yeverchan.recycling_machine.domain.PwdChangeDto;
import com.yeverchan.recycling_machine.domain.RegisterDto;
import com.yeverchan.recycling_machine.domain.UserAuthInfo;
import com.yeverchan.recycling_machine.domain.UserDto;

import java.util.Map;

public interface UserService {
    UserDto findById(String id) throws Exception;
    UserDto findByEmail(String email) throws Exception;
    UserAuthInfo login(UserDto user) throws Exception;
    void changeName(UserAuthInfo authInfo, String name);
    void changeEmail(UserAuthInfo authInfo, String email);
    void changePwd(UserAuthInfo authInfo, String newPwd);
}
