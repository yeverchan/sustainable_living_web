package com.yeverchan.recycling_machine.controller;


import com.yeverchan.recycling_machine.domain.ProductDto;
import com.yeverchan.recycling_machine.domain.UserAuthInfo;
import com.yeverchan.recycling_machine.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/store")
public class StoreController {

    @Autowired
    ProductService productService;

    @GetMapping("/home")
    public String home(){
        return "store";
    }

    @GetMapping("/myInfo")
    public String myInfo(){
        return "storeMyInfo";
    }

    @GetMapping("/addProduct")
    public String goAddProduct(){
        return "addProduct";
    }

    @PostMapping("/addProduct")
    public String addProduct(@ModelAttribute(value = "product") ProductDto product, HttpSession session) throws Exception {

        UserAuthInfo authInfo = (UserAuthInfo) session.getAttribute("auth");
        product.setUser_id(authInfo.getId());

        int check = productService.addProduct(product);

        if(check != 1){
            throw new Exception();
        }

        return "storeMyInfo";
    }
}

