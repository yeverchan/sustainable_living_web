package com.yeverchan.recycling_machine.controller;

import com.yeverchan.recycling_machine.domain.ProductDto;
import com.yeverchan.recycling_machine.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/detail")
    public String detail(@RequestParam String product, Model m){
        ProductDto productDto = productService.getProduct(product);

        m.addAttribute("product", productDto);

        return "detail";
    }

    @GetMapping("/modify")
    public String getModify(@RequestParam String product, Model m){

        ProductDto productDto = productService.getProduct(product);

        m.addAttribute("product", productDto);

        return "modify";
    }
}
