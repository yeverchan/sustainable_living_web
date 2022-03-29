package com.yeverchan.recycling_machine.service;

import com.yeverchan.recycling_machine.domain.ProductDto;

public interface PointService {
    Long getPoint(String user_id);
    boolean txPoint(ProductDto product, String ordererId) throws Exception;
}
