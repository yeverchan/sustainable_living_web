package com.yeverchan.recycling_machine.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/store")
public class StoreController {

    @GetMapping("/home")
    public String home(){
        return "store";
    }

    @GetMapping("/myInfo")
    public String myInfo(){
        return "storeMyInfo";
    }
}

