package com.yeverchan.recycling_machine.controller;


import com.yeverchan.recycling_machine.domain.ProductDto;
import com.yeverchan.recycling_machine.domain.UserAuthInfo;
import com.yeverchan.recycling_machine.service.PointService;
import com.yeverchan.recycling_machine.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/store")
public class StoreController {

    @Autowired
    ProductService productService;

    @Autowired
    PointService pointService;

    @GetMapping("/home")
    public String home(HttpServletRequest request) {
        List<ProductDto> AllProductList = productService.getAllProduct();

        UserAuthInfo authInfo = (UserAuthInfo) request.getSession(false).getAttribute("auth");

        if(authInfo != null){
            request.setAttribute("point", pointService.getPoint(authInfo.getId()));
        }

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
    public String detail(@RequestParam String product, @RequestParam String sign ,HttpServletRequest request ,Model m) {
        ProductDto productDto = getProduct(product, sign);
        UserAuthInfo authInfo = (UserAuthInfo) request.getSession(false).getAttribute("auth");
        if (productDto == null) {
            m.addAttribute("check", "nfoundpd");
            return "detail";
        }

        if(authInfo != null){
            m.addAttribute("point", pointService.getPoint(authInfo.getId()));
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
    public String purchase(@ModelAttribute(value = "order") @RequestParam Map<String, String> order, HttpServletRequest request, RedirectAttributes attributes) throws Exception {
        ProductDto productDto = getProduct(order.get("name"), order.get("id"));
        UserAuthInfo auth = (UserAuthInfo) request.getSession(false).getAttribute("auth");
        String ordererId = auth.getId();
        String path = request.getHeader("referer");

        if(productDto.getState() != 1){
            attributes.addFlashAttribute("check", "ntexso");
            return "redirect:"+path;
        }
        Long amount = pointService.getPoint(ordererId);
        if(productDto.getPrice() > amount){
            attributes.addFlashAttribute("check", "nenopp");
            return "redirect:"+path;
        }

        boolean check = pointService.calculatePoint(productDto, ordererId);

        if(!check){
            attributes.addFlashAttribute("check", "txerror");
            return "redirect:"+path;
        }

        productDto.setState(0);
        productService.updateState(productDto);

        attributes.addFlashAttribute("check", "compleTx");
        return "redirect:/store/home";
    }


    private ProductDto getProduct(String name, String id){
        Map<String, String> map = new HashMap<>();
        map.put("name", name);
        map.put("id", id);
        return productService.getProduct(map);
    }
}

