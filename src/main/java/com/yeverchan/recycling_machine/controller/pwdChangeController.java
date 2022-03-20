package com.yeverchan.recycling_machine.controller;


import com.yeverchan.recycling_machine.domain.PwdChangeDto;
import com.yeverchan.recycling_machine.domain.UserAuthInfo;
import com.yeverchan.recycling_machine.domain.UserDto;
import com.yeverchan.recycling_machine.service.UserService;
import com.yeverchan.recycling_machine.validator.PwdChangeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


@Controller
public class pwdChangeController {

    @Autowired
    UserService userService;

    @InitBinder
    private void pwdChangeValid(WebDataBinder binder) {
        binder.setValidator(new PwdChangeValidator());
    }

    @GetMapping("/manage/pwdChange")
    public String getPasswordChange() {

        return "pwdChange";
    }


    @PostMapping("/manage/pwdChange")
    public String passwordChange(@ModelAttribute(value = "pwdChange") @Valid PwdChangeDto pwdChange, BindingResult bindingResult, HttpServletRequest request) throws Exception {
        request.setAttribute("pwd", pwdChange);

        if (!bindingResult.hasErrors()) {

            UserAuthInfo authInfo = (UserAuthInfo) request.getSession(false).getAttribute("auth");
            UserDto user = userService.findById(authInfo.getId());

            if (!pwdChange.getCurrent().equals(user.getPassword())) {
                bindingResult.rejectValue("current", "incorrect", "incorrect Password");
                return "pwdChange";
            }
            if (pwdChange.getNewPwd().equals(user.getPassword())) {
                bindingResult.rejectValue("newPwd", "duplicated");
                return "pwdChange";
            }

            userService.changePwd(authInfo, pwdChange.getNewPwd());
            request.setAttribute("com", "com");

            return "pwdChange";
        }

        return "pwdChange";
    }
}
