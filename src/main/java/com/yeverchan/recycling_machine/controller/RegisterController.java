package com.yeverchan.recycling_machine.controller;


import com.yeverchan.recycling_machine.domain.RegisterDto;
import com.yeverchan.recycling_machine.service.RegisterService;
import com.yeverchan.recycling_machine.validator.RegisterValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    RegisterService registerService;

    @InitBinder
    private void registerValid(WebDataBinder binder) {
        binder.setValidator(new RegisterValidator());
    }

    @GetMapping("/create")
    public String create() {
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute(value = "register") @Valid RegisterDto register, BindingResult bindingResult, HttpServletRequest request) {

        request.setAttribute("createTemp", register);

        if (!bindingResult.hasErrors()) {
            try {
                registerService.register(register);
                request.setAttribute("com", "com");
                return "create";
            } catch (Exception e) {
                request.setAttribute("message", e.getMessage());
                return "create";
            }
        }
        return "create";
    }
}
