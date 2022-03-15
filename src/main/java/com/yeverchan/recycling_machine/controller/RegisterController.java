package com.yeverchan.recycling_machine.controller;


import com.yeverchan.recycling_machine.domain.RegisterDto;
import com.yeverchan.recycling_machine.service.UserService;
import com.yeverchan.recycling_machine.validator.RegisterValidator;
import org.apache.ibatis.javassist.bytecode.DuplicateMemberException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    UserService userService;

    @InitBinder
    public void registerValid(WebDataBinder binder) {
        binder.setValidator(new RegisterValidator());
    }

    @GetMapping("/create")
    public String create() {
        return "create";
    }

    @PostMapping("/create")
    public String crete_account(@ModelAttribute(value = "register") @Valid RegisterDto register, BindingResult bindingResult, Model m) throws Exception {
        if (!bindingResult.hasErrors()) {
            try {
                userService.register(register);
            }catch (RuntimeException e){
                e.getMessage();
                return "create";
            }
            return "redirect:/";
        }
        return "create";
    }
}
