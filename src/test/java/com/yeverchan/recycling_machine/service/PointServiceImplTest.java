package com.yeverchan.recycling_machine.service;

import com.yeverchan.recycling_machine.domain.ProductDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class PointServiceImplTest {

    @Autowired
    PointService pointService;

    @Autowired
    ProductService productService;

    @Autowired
    OrderService orderService;

    @Test
    public void calculatePointTest(){
        Map<String, String> map = new HashMap<>();
        map.put("name", "sdfsdf");
        map.put("id", "51");

        ProductDto productDto = productService.getProduct(map);
        Long merchantBefore = pointService.getPoint(productDto.getUser_id());
        Long ordererBefore = pointService.getPoint("testqq");

        try {
            boolean testValue = orderService.txProduct(productDto, "testqq");
        } catch (Exception e) {
        }

        Long merchantAfter = pointService.getPoint(productDto.getUser_id());
        Long ordererAfter = pointService.getPoint("testqq");

        assertEquals((Long) ( merchantBefore+ productDto.getPrice()), merchantAfter);
        assertEquals((Long) (ordererBefore - productDto.getPrice()), ordererAfter);
//        assertFalse(testValue);

    }

    @Test
    public void txUpdateTest(){

        Map<String, String> map = new HashMap<>();
        map.put("name", "sdfsdf");
        map.put("id", "51");

        ProductDto productDto = productService.getProduct(map);
        Long merchantBefore = pointService.getPoint(productDto.getUser_id());
        Long ordererBefore = pointService.getPoint("testqq");

        try {
            boolean testValue = orderService.txProduct(productDto, "testqq");
        } catch (Exception e) {
        }

        Long merchantAfter = pointService.getPoint(productDto.getUser_id());
        Long ordererAfter = pointService.getPoint("testqq");

        assertEquals(merchantBefore, merchantAfter);
        assertEquals(ordererBefore, ordererAfter);



    }
}