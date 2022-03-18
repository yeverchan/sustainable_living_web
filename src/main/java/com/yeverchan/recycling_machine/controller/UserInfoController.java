package com.yeverchan.recycling_machine.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/manage")
public class UserInfoController {

    @GetMapping("/my")
    public String info(HttpServletRequest request){

        if(request.getSession(false).getAttribute("auth") == null){
            return "redirect:/login";
        }

        // TODO: 2022/03/18 유저 검증
        return "userInfo";
    }

    @GetMapping("/change")
    public String changeInfo(){
        return "userInfoChange";
    }

    @PostMapping("/nameChange")
    public String nameChange(String name, String id){
        // TODO: 2022/03/18 변경 사항 검사, 업데이트, 히스토리
        return "userInfoChange";
    }

    @PostMapping("/emailChange")
    public String emailChange(String email, String id){
        // TODO: 2022/03/18 변경 사항 검사, 중복 검사, 업데이트, 히스토리
        return "userInfoChange";
    }

}
