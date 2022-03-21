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

import javax.servlet.http.HttpServletRequest;;
import java.util.List;

@Controller
@RequestMapping("/store")
public class StoreController {

    @Autowired
    ProductService productService;

    @GetMapping("/home")
    public String home(HttpServletRequest request) {
        List<ProductDto> AllProductList = productService.getAllProduct();
        if (AllProductList.size() != 0) {
            request.setAttribute("Products", AllProductList);
        }
        return "store";
    }

    @GetMapping("/myInfo")
    public String myInfo(HttpServletRequest request) {
        UserAuthInfo authInfo = (UserAuthInfo) request.getSession(false).getAttribute("auth");

        List<ProductDto> myProductList = productService.getMyProduct(authInfo.getId());

        if (myProductList.size() == 0) {
            return "storeMyInfo";
        } else {
            request.setAttribute("myProducts", myProductList);
        }

        return "storeMyInfo";
    }

    @GetMapping("/addProduct")
    public String goAddProduct() {
        return "addProduct";
    }

    @PostMapping("/addProduct")
    public String addProduct(@ModelAttribute(value = "product") ProductDto product, HttpServletRequest request) throws Exception {

        UserAuthInfo authInfo = (UserAuthInfo) request.getSession(false).getAttribute("auth");
        product.setUser_id(authInfo.getId());

        int check = productService.addProduct(product);

        if (check != 1) {
            throw new Exception();
        }

        request.setAttribute("com", "com");

        return "addProduct";
    }
}

