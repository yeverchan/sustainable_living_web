package com.yeverchan.recycling_machine.controller;

import com.yeverchan.recycling_machine.domain.PointHistoryDto;
import com.yeverchan.recycling_machine.domain.UserAuthInfo;
import com.yeverchan.recycling_machine.domain.UserDto;
import com.yeverchan.recycling_machine.service.PointHistoryService;
import com.yeverchan.recycling_machine.service.PointService;
import com.yeverchan.recycling_machine.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping("/manage")
public class UserInfoController {

    @Autowired
    UserService userService;

    @Autowired
    PointService pointService;

    @Autowired
    PointHistoryService pointHistoryService;

    @GetMapping("/my")
    public String info(HttpServletRequest request) throws Exception{
        UserAuthInfo auth = (UserAuthInfo) request.getSession(false).getAttribute("auth");

        UserDto user = userService.findById(auth.getId());
        Long point = pointService.getPoint(user.getId());
        request.setAttribute("point", point);
        return "userInfo";
    }

    @GetMapping("/change")
    public String changeInfo() {
        return "userInfoChange";
    }

    @PostMapping("/nameChange")
    public String nameChange(@ModelAttribute(value = "name") String name, Errors error, HttpServletRequest request) {

        HttpSession session = request.getSession(false);
        UserAuthInfo authInfo = (UserAuthInfo) session.getAttribute("auth");
        if (name.equals(authInfo.getName())) {
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
        if (email.equals(authInfo.getEmail())) {
            error.reject(email, "There is no change");
            return "userInfoChange";
        }
        if (userService.findByEmail(email) != null) {
            error.reject(email, "Duplicated email");
            return "userInfoChange";
        }

        userService.changeEmail(authInfo, email);

        authInfo.setEmail(email);
        session.setAttribute("auth", authInfo);
        request.setAttribute("com", "com");

        return "userInfoChange";
    }

    @GetMapping("/point/list")
    public String pointHistory(HttpServletRequest request){

        UserAuthInfo authInfo = (UserAuthInfo) request.getSession(false).getAttribute("auth");

        if(authInfo != null){
            List<PointHistoryDto> AllHistoryList = pointHistoryService.getAllHistory(authInfo.getId());
            if (AllHistoryList.size() != 0) {
                request.setAttribute("histories", AllHistoryList);
            }
        }

        return "pointHistory";
    }

}
