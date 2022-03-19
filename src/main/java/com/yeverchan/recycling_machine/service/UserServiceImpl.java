package com.yeverchan.recycling_machine.service;

import com.yeverchan.recycling_machine.domain.RegisterDto;
import com.yeverchan.recycling_machine.domain.UserAuthInfo;
import com.yeverchan.recycling_machine.domain.UserDto;
import com.yeverchan.recycling_machine.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

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

    @Override
    public UserAuthInfo login(UserDto user) throws Exception{
        UserDto target = userRepository.selectUser(user.getId());
        if(target == null){
            throw new RuntimeException("Couldn't find account");
        }else {
            if(!target.getPassword().equals(user.getPassword())) {
                throw new RuntimeException("incorrect Password");
            }
        }

        return new UserAuthInfo(target.getId(), target.getEmail(), target.getName());
    }

    @Override
    public void setName(Map<String, String> name) {
        userRepository.updateName(name);
    }

    @Override
    public void setEmail(Map<String, String> email) {
        userRepository.updateEmail(email);
    }
}
