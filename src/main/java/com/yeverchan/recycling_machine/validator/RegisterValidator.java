package com.yeverchan.recycling_machine.validator;

import com.yeverchan.recycling_machine.domain.RegisterDto;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class RegisterValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return RegisterDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        RegisterDto register = (RegisterDto) target;

        String id = register.getId();
        String password = register.getPassword();
        String checkPassword = register.getCheckPassword();

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "required", "Enter Id");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required","Enter password");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "checkPassword", "required","Enter check password");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required","Enter name");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required","Enter email");

        if (id.length() <= 4) {
            errors.rejectValue("id", "length", new String[]{"5"}, "id length must be at least ");
        }
        if (password.length() <= 6) {
            errors.rejectValue("password", "length", new String[]{"7"},"password length must be at least ");
        }

        if (!password.equals(checkPassword)) {
            errors.rejectValue("checkPassword", "match","not equal password");
        }
    }
}






