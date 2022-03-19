package com.yeverchan.recycling_machine.controller;

import com.yeverchan.recycling_machine.domain.UserAuthInfo;
import com.yeverchan.recycling_machine.domain.UserHistoryDto;
import com.yeverchan.recycling_machine.service.UserHistoryService;
import com.yeverchan.recycling_machine.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
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

    @Autowired
    UserHistoryService userHistoryService;

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
    @Transactional(rollbackFor = Exception.class)
    public String nameChange(@ModelAttribute(value = "name") String name, Errors error, HttpServletRequest request) {

        HttpSession session = request.getSession(false);
        UserAuthInfo authInfo = (UserAuthInfo) session.getAttribute("auth");
        if(name.equals(authInfo.getName())){
            error.reject(name, "There is no change");
            return "userInfoChange";
        }

        Map<String, String> map = new HashMap<>();
        map.put("name", name);
        map.put("id", authInfo.getId());
        userService.setName(map);

        authInfo.setName(name);
        session.setAttribute("auth", authInfo);

        UserHistoryDto userHistory = new UserHistoryDto(authInfo.getId(), authInfo.getName(), authInfo.getEmail());
        userHistoryService.createHistory(userHistory);

        return "userInfoChange";
    }

    @PostMapping("/emailChange")
    @Transactional(rollbackFor = Exception.class)
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

        Map<String, String> map = new HashMap<>();
        map.put("email", email);
        map.put("id", authInfo.getId());
        userService.setEmail(map);

        authInfo.setEmail(email);
        session.setAttribute("auth", authInfo);

        UserHistoryDto userHistory = new UserHistoryDto(authInfo.getId(), authInfo.getName(), authInfo.getEmail());
        userHistoryService.createHistory(userHistory);

        return "userInfoChange";
    }


}
