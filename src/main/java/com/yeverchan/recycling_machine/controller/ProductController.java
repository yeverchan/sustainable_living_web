package com.yeverchan.recycling_machine.controller;

import com.yeverchan.recycling_machine.domain.ProductDto;
import com.yeverchan.recycling_machine.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/detail")
    public String detail(String product, Model m){
        ProductDto productDto = productService.getProduct(product);

        m.addAttribute("product", productDto);

        return "/detail";
    }
}
