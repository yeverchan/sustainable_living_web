package com.yeverchan.recycling_machine.service;

import com.yeverchan.recycling_machine.domain.ProductDto;

public interface OrderService {
    boolean txProduct(ProductDto product, String ordererId) throws Exception;
}
