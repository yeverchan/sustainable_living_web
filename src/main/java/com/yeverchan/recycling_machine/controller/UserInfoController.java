package com.yeverchan.recycling_machine.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserInfoController {

    @GetMapping("/info")
    public String info(HttpServletRequest request){

        if(request.getSession(false).getAttribute("auth") == null){
            return "redirect:/login";
        }

        //validate auth. auth.equals user.id, user.email
        return "userInfo";
    }
}
