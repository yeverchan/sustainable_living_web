package com.yeverchan.recycling_machine.controller;

import com.yeverchan.recycling_machine.domain.ProductDto;
import com.yeverchan.recycling_machine.domain.UserAuthInfo;
import com.yeverchan.recycling_machine.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;


    @GetMapping("/modify")
    public String modify(@RequestParam String product, @RequestParam String sign, Model m) {
        Map<String, String> map = new HashMap<>();
        map.put("name", product);
        map.put("id", sign);
        ProductDto productDto = productService.getProduct(map);

        m.addAttribute("product", productDto);
        m.addAttribute("mode", "modify");

        return "manageProduct";
    }

    @PostMapping("/modify")
    public String modify(@ModelAttribute(value = "product") ProductDto productDto, HttpSession session, Model m) {
        UserAuthInfo authInfo = (UserAuthInfo) session.getAttribute("auth");
        productDto.setUser_id(authInfo.getId());

        productService.modifyProduct(productDto);

        m.addAttribute("com", "com");

        return "manageProduct";
    }


    @GetMapping("/addProduct")
    public String addProduct() {
        return "manageProduct";
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

        return "manageProduct";
    }

}
