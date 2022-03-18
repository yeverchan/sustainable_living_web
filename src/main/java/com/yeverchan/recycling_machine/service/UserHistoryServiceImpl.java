package com.yeverchan.recycling_machine.service;

import com.yeverchan.recycling_machine.domain.UserHistoryDto;
import com.yeverchan.recycling_machine.repository.UserHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserHistoryServiceImpl implements UserHistoryService{

    @Autowired
    UserHistoryRepository userHistoryRepository;

    @Override
    public List<UserHistoryDto> getUserHistories(String user_id) {
        return userHistoryRepository.selectAllByUserId(user_id);
    }

    @Override
    public int createHistory(UserHistoryDto userHistory) {
        return userHistoryRepository.insert(userHistory);
    }
}
