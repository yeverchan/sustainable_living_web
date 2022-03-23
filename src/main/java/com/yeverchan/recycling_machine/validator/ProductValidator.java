package com.yeverchan.recycling_machine.validator;

import com.yeverchan.recycling_machine.domain.ProductDto;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class ProductValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return ProductDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        ProductDto productDto = (ProductDto) target;


        String name = productDto.getName();
        Long price = productDto.getPrice();

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required", "enter product name");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "required", "enter product price");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "required", "enter product description");

        if ((name.length() > 30 || 5 > name.length()) && name.length() >= 1) {
            errors.rejectValue("name", "length", new String[]{"5", "30"}, "name is must be between {0} and {1} character long");
        }
        if (price == null) {
            errors.reject("price");
        } else {
            if (price <= 0 || price < 100 || Long.MAX_VALUE <= price) {
                errors.rejectValue("price", "min", "try again enter the price.");
            }
        }
    }
}
