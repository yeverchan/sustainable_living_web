package com.yeverchan.recycling_machine.service;

import com.yeverchan.recycling_machine.domain.UserHistoryDto;

import java.util.List;

public interface UserHistoryService {
    List<UserHistoryDto> getUserHistories(String user_id);
    int createHistory(UserHistoryDto userHistory);
}
