package com.yeverchan.recycling_machine.service;

import com.yeverchan.recycling_machine.domain.RegisterDto;
import com.yeverchan.recycling_machine.domain.UserDto;
import com.yeverchan.recycling_machine.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDto findById(String id) throws Exception {
        return userRepository.select(id);
    }

    @Override
    public UserDto findByEmail(String email) throws Exception {
        return userRepository.selectEmail(email);
    }

    @Override
    public void register(RegisterDto register) throws Exception{
        if(userRepository.selectEmail(register.getEmail()) != null){
            throw new RuntimeException("duplicated email");
        }
        if (userRepository.select(register.getId()) != null){
            throw new RuntimeException("duplicated id");
        }
        userRepository.insert(register);
    }
}
