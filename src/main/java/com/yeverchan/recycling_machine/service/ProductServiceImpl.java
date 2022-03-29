package com.yeverchan.recycling_machine.service;

import com.yeverchan.recycling_machine.domain.ProductDto;
import com.yeverchan.recycling_machine.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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
    public ProductDto getProduct(Map<String, String> product){
        return productRepository.selectByNameAndId(product);
    }

    @Override
    public int removeProduct(Map<String, String> product){
        return productRepository.delete(product);
    }

    @Override
    public int modifyProduct(ProductDto productDto){
        return productRepository.updateByUserId(productDto);
    }

    @Override
    public int updateState(ProductDto productDto){
        return productRepository.updateProductState(productDto);
    }
}
