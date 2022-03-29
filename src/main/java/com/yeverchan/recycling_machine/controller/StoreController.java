package com.yeverchan.recycling_machine.controller;


import com.yeverchan.recycling_machine.domain.ProductDto;
import com.yeverchan.recycling_machine.domain.UserAuthInfo;
import com.yeverchan.recycling_machine.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String detail(@RequestParam String product, @RequestParam String sign ,Model m) {
        ProductDto productDto = getProduct(product, sign);

        if (productDto == null) {
            m.addAttribute("check", "nfoundpd");
            return "detail";
        }

        m.addAttribute("product", productDto);
        m.addAttribute("com", "com");
        return "detail";
    }

    @GetMapping("/purchase")
    public String purchase(@RequestParam String name, @RequestParam String id,Model m){
        ProductDto productDto = getProduct(name, id);
        m.addAttribute("product" , productDto);
        if (productDto == null) {
            m.addAttribute("check", "nfoundpd");
            return "detail";
        }
        if(productDto.getState() != 1){
            m.addAttribute("check", "ntexso");
            return "purchase";
        }
        return "purchase";
    }

    @PostMapping("/purchase")
    public String purchase(@ModelAttribute(value = "order") @RequestParam Map<String, String> order, Model m){
        ProductDto productDto = getProduct(order.get("name"), order.get("id"));
        if(productDto.getState() != 1){
            m.addAttribute("check", "ntexso");
            return "purchase";
        }
        return "purchase";
    }


    private ProductDto getProduct(String name, String id){
        Map<String, String> map = new HashMap<>();
        map.put("name", name);
        map.put("id", id);
        return productService.getProduct(map);
    }
}

