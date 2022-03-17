package com.yeverchan.recycling_machine.service;

import com.yeverchan.recycling_machine.domain.Point;

public interface PointService {
    int init(String user_id);
    Point getPoint(String user_id);
}
