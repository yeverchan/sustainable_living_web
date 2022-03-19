package com.yeverchan.recycling_machine.validator;

import com.yeverchan.recycling_machine.domain.UserDto;
import com.yeverchan.recycling_machine.service.UserService;
import com.yeverchan.recycling_machine.service.UserServiceImpl;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class LoginValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return UserDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "required", "Enter Id");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required", "Enter password");
    }
}
