package com.yeverchan.recycling_machine.service;

import com.yeverchan.recycling_machine.domain.ProductDto;

import java.util.List;
import java.util.Map;

public interface ProductService {
    int addProduct(ProductDto productDto);
    List<ProductDto> getMyProduct(String user_id);
    List<ProductDto> getAllProduct();
    ProductDto getProduct(Map<String, String> product);
    int modifyProduct(ProductDto productDto);
    int removeProduct(Map<String, String> product);
}
