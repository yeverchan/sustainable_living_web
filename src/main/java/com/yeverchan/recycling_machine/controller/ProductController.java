package com.yeverchan.recycling_machine.controller;

import com.yeverchan.recycling_machine.domain.ProductDto;
import com.yeverchan.recycling_machine.domain.UserAuthInfo;
import com.yeverchan.recycling_machine.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

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
