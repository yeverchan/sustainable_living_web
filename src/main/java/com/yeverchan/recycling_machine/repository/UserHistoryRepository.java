package com.yeverchan.recycling_machine.repository;

import com.yeverchan.recycling_machine.domain.UserHistoryDto;

import java.util.List;

public interface UserHistoryRepository{
    List<UserHistoryDto> selectAllByUserId(String user_id);
    int insert(UserHistoryDto userHistory);
}
