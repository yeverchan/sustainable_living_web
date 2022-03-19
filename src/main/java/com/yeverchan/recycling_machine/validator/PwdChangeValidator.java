package com.yeverchan.recycling_machine.validator;

import com.yeverchan.recycling_machine.domain.PwdChangeDto;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class PwdChangeValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {

        return PwdChangeDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        PwdChangeDto pwdChange = (PwdChangeDto) target;

        String newPwd = pwdChange.getNewPwd();
        String checkNewPwd = pwdChange.getCheckNewPwd();

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "current", "required", "Enter current password");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "newPwd", "required", "Enter new password");


         if (newPwd.length() >= 1 && newPwd.length() <= 6) {
            errors.rejectValue("newPwd", "length", new String[]{"7"}, "password length must be at least ");
        }else {
            if (!newPwd.equals(checkNewPwd)) {
                errors.rejectValue("checkNewPwd", "match", "not equal password");
            }
        }
    }
}
