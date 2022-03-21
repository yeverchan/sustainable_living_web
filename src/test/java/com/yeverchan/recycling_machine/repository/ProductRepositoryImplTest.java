package com.yeverchan.recycling_machine.repository;

import com.yeverchan.recycling_machine.domain.ProductDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class ProductRepositoryImplTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    public void insertProductTest(){
        ProductDto product = new ProductDto("testid","test bag", "this is a insert test", 1000L);

        int check = productRepository.insert(product);

        assertEquals(1, check);
    }

    @Test
    public void selectAllByUserId(){
        List<ProductDto> product = productRepository.selectAllByUserId("testid");

        assertNotNull(product);

        System.out.println(product);
    }
}