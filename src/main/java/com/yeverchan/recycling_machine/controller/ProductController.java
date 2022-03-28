package com.yeverchan.recycling_machine.controller;

import com.yeverchan.recycling_machine.domain.ProductDto;
import com.yeverchan.recycling_machine.domain.UserAuthInfo;
import com.yeverchan.recycling_machine.service.ProductService;
import com.yeverchan.recycling_machine.validator.ProductValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @InitBinder
    private void productValid(WebDataBinder binder) {

        binder.setValidator(new ProductValidator());
    }


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
    public String modify(@ModelAttribute(value = "product") @Valid ProductDto productDto, BindingResult bindingResult, HttpSession session, Model m) {
        UserAuthInfo authInfo = (UserAuthInfo) session.getAttribute("auth");
        productDto.setUser_id(authInfo.getId());
        if (!bindingResult.hasErrors()) {
            int check = productService.modifyProduct(productDto);
            if(check != 1){
                m.addAttribute("com", "error");
                return "manageProduct";
            }

            m.addAttribute("com", "com");

            return "manageProduct";
        }

        return "manageProduct";
    }


    @GetMapping("/addProduct")
    public String addProduct() {
        return "manageProduct";
    }

    @PostMapping("/addProduct")
    public String addProduct(@ModelAttribute(value = "product") @Valid ProductDto product, BindingResult bindingResult, HttpServletRequest request) throws Exception {

        UserAuthInfo authInfo = (UserAuthInfo) request.getSession(false).getAttribute("auth");
        product.setUser_id(authInfo.getId());


        if (!bindingResult.hasErrors()) {
            productService.addProduct(product);
            request.setAttribute("com", "com");
            return "manageProduct";
        }

        return "manageProduct";
    }

    @PostMapping("/removeProduct")
    public String remove(@RequestParam String name, @RequestParam String id, HttpServletRequest request) {

        UserAuthInfo authInfo = (UserAuthInfo) request.getSession(false).getAttribute("auth");

        Map<String, String> product = new HashMap<>();
        product.put("user_id", authInfo.getId());
        product.put("id", id);
        product.put("name", name);

        productService.removeProduct(product);
        request.getSession(false).setAttribute("com", "com");

        return "redirect:/store/home";

    }

}
