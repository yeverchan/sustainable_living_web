package com.yeverchan.recycling_machine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/product")
public class ProductController {

    @GetMapping
    public String detail(String product_name){

        return "/detail";
    }
}
