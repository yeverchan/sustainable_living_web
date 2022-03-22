package com.yeverchan.recycling_machine.service;

import com.yeverchan.recycling_machine.domain.ProductDto;
import com.yeverchan.recycling_machine.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository productRepository;

    @Override
    public int addProduct(ProductDto productDto){
        return productRepository.insert(productDto);
    }

    @Override
    public List<ProductDto> getMyProduct(String user_id){
        return productRepository.selectAllByUserId(user_id);
    }

    @Override
    public List<ProductDto> getAllProduct(){
        return productRepository.selectAll();
    }

    @Override
    public ProductDto getProduct(String product_name){
        return productRepository.selectByName(product_name);
    }
}
