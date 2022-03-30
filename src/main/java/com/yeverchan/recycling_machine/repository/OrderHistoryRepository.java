package com.yeverchan.recycling_machine.repository;

import java.util.List;
import java.util.Map;

public interface OrderHistoryRepository {
    List<Map<String, String>> orderHistories(String user_id);
}
