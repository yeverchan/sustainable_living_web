package com.yeverchan.recycling_machine.controller;


import com.yeverchan.recycling_machine.domain.Order;
import com.yeverchan.recycling_machine.domain.ProductDto;
import com.yeverchan.recycling_machine.domain.UserAuthInfo;
import com.yeverchan.recycling_machine.service.OrderHistoryService;
import com.yeverchan.recycling_machine.service.OrderService;
import com.yeverchan.recycling_machine.service.PointService;
import com.yeverchan.recycling_machine.service.ProductService;
import com.yeverchan.recycling_machine.validator.OrderValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
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

    @Autowired
    OrderService orderService;

    @Autowired
    OrderHistoryService orderHistoryService;

    @InitBinder("order")
    public void orderValid(WebDataBinder binder){
        binder.setValidator(new OrderValidator());
    }

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
    public String detail(@RequestParam String product, @RequestParam int sign ,HttpServletRequest request ,Model m) {
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
    public String purchase(@RequestParam String name, @RequestParam int id,Model m){
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
    public String purchase(@ModelAttribute(value = "order") @Valid Order order, BindingResult bindingResult, HttpServletRequest request, RedirectAttributes attributes) throws Exception {
        String path = request.getHeader("referer");

        if(bindingResult.hasErrors()){
            attributes.addFlashAttribute("org.springframework.validation.BindingResult.order", bindingResult);
            attributes.addFlashAttribute("order", order);
            return "redirect:"+path;
        }
        ProductDto productDto = getProduct(order.getProductName(), order.getProductId());
        UserAuthInfo auth = (UserAuthInfo) request.getSession(false).getAttribute("auth");
        String ordererId = auth.getId();

        if(productDto.getState() != 1){
            attributes.addFlashAttribute("check", "ntexso");
            return "redirect:"+path;
        }

        Long amount = pointService.getPoint(ordererId);

        if(productDto.getPrice() > amount){
            attributes.addFlashAttribute("check", "nenopp");
            return "redirect:"+path;
        }

        boolean check = orderService.txProduct(productDto, ordererId);

        if(!check){
            attributes.addFlashAttribute("check", "txerror");
            return "redirect:"+path;
        }

        orderHistoryService.setHistory(order, ordererId);

        attributes.addFlashAttribute("check", "compleTx");
        return "redirect:/store/home";
    }


    private ProductDto getProduct(String name, int id){
        Map<String, String> map = new HashMap<>();
        map.put("name", name);
        map.put("id", id+"");
        return productService.getProduct(map);
    }
}

