package com.yeverchan.recycling_machine.controller;

import com.yeverchan.recycling_machine.domain.UserAuthInfo;
import com.yeverchan.recycling_machine.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/manage")
public class UserInfoController {

    @Autowired
    UserService userService;

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
    public String nameChange(@ModelAttribute(value = "name") String name, Errors error, HttpServletRequest request) {
        // TODO: 2022/03/18 변경 사항 검사, 업데이트, 히스토리

        HttpSession session = request.getSession(false);
        UserAuthInfo authInfo = (UserAuthInfo) session.getAttribute("auth");
        if(name.equals(authInfo.getName())){
            error.reject(name, "There is no change");
            return "userInfoChange";
        }
        // 유저 업데이트 후 어서 업데이트
        Map<String, String> map = new HashMap<>();
        map.put("name", name);
        map.put("id", authInfo.getId());
        userService.setName(map);

        authInfo.setName(name);
        session.setAttribute("auth", authInfo);

        return "userInfoChange";
    }

    @PostMapping("/emailChange")
    public String emailChange(@ModelAttribute(value = "email") String email, Errors error, HttpServletRequest request) throws Exception {
        // TODO: 2022/03/18 변경 사항 검사, 중복 검사, 업데이트, 히스토리

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

        Map<String, String> map = new HashMap<>();
        map.put("email", email);
        map.put("id", authInfo.getId());
        userService.setEmail(map);

        authInfo.setEmail(email);
        session.setAttribute("auth", authInfo);
        return "userInfoChange";
    }

}
