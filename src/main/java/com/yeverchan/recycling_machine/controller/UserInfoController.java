package com.yeverchan.recycling_machine.controller;

import com.yeverchan.recycling_machine.domain.UserAuthInfo;
import com.yeverchan.recycling_machine.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/manage")
public class UserInfoController {

    @Autowired
    UserService userService;

    @GetMapping("/my")
    public String info(){

        // TODO: 2022/03/18 유저 검증
        return "userInfo";
    }

    @GetMapping("/change")
    public String changeInfo(){
        return "userInfoChange";
    }

    @PostMapping("/nameChange")
    public String nameChange(@ModelAttribute(value = "name") String name, Errors error, HttpServletRequest request) {

        HttpSession session = request.getSession(false);
        UserAuthInfo authInfo = (UserAuthInfo) session.getAttribute("auth");
        if(name.equals(authInfo.getName())){
            error.reject(name, "There is no change");
            return "userInfoChange";
        }

        userService.changeName(authInfo, name);

        authInfo.setName(name);
        session.setAttribute("auth", authInfo);
        request.setAttribute("com", "com");

        return "userInfoChange";
    }

    @PostMapping("/emailChange")
    public String emailChange(@ModelAttribute(value = "email") String email, Errors error, HttpServletRequest request) throws Exception {

        HttpSession session = request.getSession(false);
        UserAuthInfo authInfo = (UserAuthInfo) session.getAttribute("auth");
        if(email.equals(authInfo.getEmail())){
            error.reject(email, "There is no change");
            return "userInfoChange";
        }
        if(userService.findByEmail(email) != null){
            error.reject(email, "Duplicated email");
            return "userInfoChange";
        }

        userService.changeEmail(authInfo, email);

        authInfo.setEmail(email);
        session.setAttribute("auth", authInfo);
        request.setAttribute("com", "com");

        return "userInfoChange";
    }


}
