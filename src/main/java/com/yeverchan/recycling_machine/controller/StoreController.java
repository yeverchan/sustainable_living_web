package com.yeverchan.recycling_machine.controller;


import com.yeverchan.recycling_machine.domain.ProductDto;
import com.yeverchan.recycling_machine.domain.UserAuthInfo;
import com.yeverchan.recycling_machine.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @GetMapping("/detail")
    public String detail(@RequestParam String product, @RequestParam String sign, Model m) {
        Map<String, String> map = new HashMap<>();
        map.put("name", product);
        map.put("id", sign);
        ProductDto productDto = productService.getProduct(map);

        if (productDto == null) {
            m.addAttribute("check", "nfoundpd");
            return "detail";
        }

        m.addAttribute("product", productDto);
        m.addAttribute("com", "com");

        return "detail";
    }

    @GetMapping("/purchase")
    public String purchase(){
        return "purchase";
    }
}

