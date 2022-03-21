package com.yeverchan.recycling_machine.service;

import com.yeverchan.recycling_machine.domain.ProductDto;

import java.util.List;

public interface ProductService {
    int addProduct(ProductDto productDto);

    List<ProductDto> getMyProduct(String user_id);
    List<ProductDto> getAllProduct();
}
