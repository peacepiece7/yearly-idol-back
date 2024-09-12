package com.yearly.idol.api.yearly_idol.Common.validator;

import com.yearly.idol.api.yearly_idol.Common.annotation.Password;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<Password, String> {

    private Password con;

    @Override
    public void initialize(Password constraintAnnotation) {
        // ConstraintValidator.super.initialize(constraintAnnotation);
        this.con = constraintAnnotation;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext ctx) {
        boolean isValid = true;
        if(!con.regex().matches(value)) {
            ctx.buildConstraintViolationWithTemplate(con.message()).addConstraintViolation();
            isValid = false;
        }

        if(!con.regexpLength().matches(value)) {
            ctx.buildConstraintViolationWithTemplate(con.messageLength()).addConstraintViolation();
            isValid = false;
        }

        if(!con.regexpUpperCase().matches(value)) {
            ctx.buildConstraintViolationWithTemplate(con.messageUpperCase()).addConstraintViolation();
            isValid = false;
        }

        if(!con.regexpLowerCase().matches(value)) {
            ctx.buildConstraintViolationWithTemplate(con.messageLowerCase()).addConstraintViolation();
            isValid = false;
        }
        return isValid;
    }
}
