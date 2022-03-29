package com.yeverchan.recycling_machine.repository;

import java.util.Map;

public interface PointRepository {
    int init(String user_id) throws Exception;
    Long selectAmountById(String user_id);
    int selectIdByUserId(String user_id);
    int updatePoint(Map<String, String> value);
}
