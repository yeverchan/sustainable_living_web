package com.yeverchan.recycling_machine.validator;

import com.yeverchan.recycling_machine.domain.Order;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Pattern;

public class OrderValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Order.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Order order = (Order) target;

        String phone = order.getOrdererPhone();

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ordererName", "required", "Enter name");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ordererAddress", "required", "Enter address");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ordererPhone", "required", "Enter phone number");

        if (phone.length() > 0 && !Pattern.matches("^01\\d-\\d{4}-\\d{4}$", phone)) {
            errors.rejectValue("ordererPhone", "regex", "010-xxxx-xxxx");
        }
    }
}
