package com.yeverchan.recycling_machine.service;

import com.yeverchan.recycling_machine.domain.*;
import com.yeverchan.recycling_machine.handler.LoginException;
import com.yeverchan.recycling_machine.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserHistoryService userHistoryService;

    @Autowired
    PointService pointService;

    @Override
    public UserDto findById(String id) throws Exception {
        return userRepository.select(id);
    }

    @Override
    public UserDto findByEmail(String email) throws Exception {
        return userRepository.selectEmail(email);
    }

    @Override
    public UserAuthInfo login(UserDto user) throws Exception {
        UserDto target = userRepository.selectUser(user.getId());
        if (target == null) {
            throw new LoginException("Couldn't find account");
        } else {
            if (!target.getPassword().equals(user.getPassword())) {
                throw new LoginException("incorrect Password");
            }
        }
        UserAuthInfo authInfo = new UserAuthInfo(target.getId(), target.getEmail(), target.getName());

        return authInfo;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void changeName(UserAuthInfo authInfo, String name) {

        Map<String, String> map = new HashMap<>();
        map.put("name", name);
        map.put("id", authInfo.getId());
        userRepository.updateName(map);

        UserHistoryDto userHistory = new UserHistoryDto(authInfo.getId(), authInfo.getName(), authInfo.getEmail());
        userHistoryService.createHistory(userHistory);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void changeEmail(UserAuthInfo authInfo, String email) {

        Map<String, String> map = new HashMap<>();
        map.put("email", email);
        map.put("id", authInfo.getId());

        userRepository.updateEmail(map);

        UserHistoryDto userHistory = new UserHistoryDto(authInfo.getId(), authInfo.getName(), authInfo.getEmail());
        userHistoryService.createHistory(userHistory);
    }

    @Override
    public void changePwd(UserAuthInfo authInfo, String newPWd) {
        Map<String, String> map = new HashMap<>();
        map.put("password", newPWd);
        map.put("id", authInfo.getId());
        userRepository.updatePwd(map);
    }
}
