package com.yeverchan.recycling_machine.controller;


import com.yeverchan.recycling_machine.domain.RegisterDto;
import com.yeverchan.recycling_machine.domain.UserHistoryDto;
import com.yeverchan.recycling_machine.service.PointService;
import com.yeverchan.recycling_machine.service.UserHistoryService;
import com.yeverchan.recycling_machine.service.UserService;
import com.yeverchan.recycling_machine.validator.RegisterValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    UserService userService;
    @Autowired
    UserHistoryService userHistoryService;
    @Autowired
    PointService pointService;

    @InitBinder
    private void registerValid(WebDataBinder binder) {
        binder.setValidator(new RegisterValidator());
    }

    @GetMapping("/create")
    public String create() {
        return "create";
    }

    @PostMapping("/create")
    @Transactional(rollbackFor = Exception.class)
    public String crete_account(@ModelAttribute(value = "register") @Valid RegisterDto register, BindingResult bindingResult, HttpServletRequest request) throws Exception {
        if (!bindingResult.hasErrors()) {
            try {
                userService.register(register);
                pointService.init(register.getId());
                userHistoryService.createHistory(new UserHistoryDto(register.getId(), register.getName(), register.getEmail()));
                request.getSession(false).setAttribute("com", "com");
            }catch (RuntimeException e){
                request.setAttribute("message",  e.getMessage());
                return "create";
            }
            return "create";
        }
        return "create";
    }
}
