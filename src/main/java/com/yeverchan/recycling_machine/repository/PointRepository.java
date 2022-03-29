package com.yeverchan.recycling_machine.repository;

import com.yeverchan.recycling_machine.domain.Point;

public interface PointRepository {
    int init(String user_id) throws Exception;
    Long selectById(String user_id);
}
