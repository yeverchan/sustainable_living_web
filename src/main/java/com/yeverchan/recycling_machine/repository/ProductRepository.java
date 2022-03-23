package com.yeverchan.recycling_machine.repository;


import com.yeverchan.recycling_machine.domain.ProductDto;

import java.util.List;
import java.util.Map;

public interface ProductRepository {
    int insert(ProductDto product);
    List<ProductDto> selectAll();
    List<ProductDto> selectAllByUserId(String user_id);
    ProductDto selectByNameAndId(Map<String, String> product);
    int updateByUserId(ProductDto productDto);
}
