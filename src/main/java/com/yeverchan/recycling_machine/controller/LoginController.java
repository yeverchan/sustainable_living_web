package com.yeverchan.recycling_machine.controller;


import com.yeverchan.recycling_machine.domain.Point;
import com.yeverchan.recycling_machine.domain.UserAuthInfo;
import com.yeverchan.recycling_machine.domain.UserDto;
import com.yeverchan.recycling_machine.service.PointService;
import com.yeverchan.recycling_machine.service.UserService;
import com.yeverchan.recycling_machine.validator.LoginValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @Autowired
    PointService pointService;

    @InitBinder
    private void loginValidator(WebDataBinder binder) {
        binder.setValidator(new LoginValidator());
    }

    @GetMapping("/login")
    public String login(HttpServletRequest request) {
        if(request.getSession(false).getAttribute("auth") != null){
            return "redirect:/";
        }
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession(false).invalidate();
        return "redirect:/";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute(value = "login") @Valid UserDto user, BindingResult bindingResult, HttpServletRequest request) throws Exception {

        if (!bindingResult.hasErrors()) {
            try {
                UserAuthInfo authInfo = userService.login(user);
                Point point = pointService.getPoint(user.getId());

                authInfo.setAmount(point.getAmount());
                HttpSession session = request.getSession();
                session.setAttribute("auth", authInfo);
                return "home";
            } catch (RuntimeException e) {
                request.setAttribute("message", e.getMessage());
                return "login";
            }
        }
        return "login";
    }

}
