package com.yeverchan.recycling_machine.repository;


import com.yeverchan.recycling_machine.domain.ProductDto;

public interface ProductRepository {
    int insert(ProductDto product);
}
