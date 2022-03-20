package com.yeverchan.recycling_machine.service;

import com.yeverchan.recycling_machine.domain.UserHistoryDto;

import java.util.List;

public interface UserHistoryService {
    int createHistory(UserHistoryDto userHistory);
    List<UserHistoryDto> getUserHistories(String user_id);
}
