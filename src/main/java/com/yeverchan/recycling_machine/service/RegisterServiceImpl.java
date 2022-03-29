package com.yeverchan.recycling_machine.service;


import com.yeverchan.recycling_machine.domain.RegisterDto;
import com.yeverchan.recycling_machine.domain.UserHistoryDto;
import com.yeverchan.recycling_machine.repository.PointRepository;
import com.yeverchan.recycling_machine.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PointRepository pointRepository;
    @Autowired
    UserHistoryService userHistoryService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void register(RegisterDto register) throws Exception{
        if(userRepository.selectEmail(register.getEmail()) != null){
            throw new RuntimeException("duplicated email");
        }
        if (userRepository.select(register.getId()) != null){
            throw new RuntimeException("duplicated id");
        }

        init(register.getId());
        userHistoryService.createHistory(new UserHistoryDto(register.getId(), register.getName(), register.getEmail()));
        userRepository.insert(register);


    }

    @Override
    public int init(String user_id) throws Exception{
        return pointRepository.init(user_id);
    }
}
