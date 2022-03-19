package com.yeverchan.recycling_machine.repository;


import com.yeverchan.recycling_machine.domain.ProductDto;

import java.util.List;

public interface ProductRepository {
    int insert(ProductDto product);
    List<ProductDto> selectAll(String user_id);
}
